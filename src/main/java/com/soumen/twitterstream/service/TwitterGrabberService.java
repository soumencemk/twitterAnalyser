package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.TweetFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Service
@RequiredArgsConstructor
public class TwitterGrabberService {

    private final TwitterSentimentAnalyser analyser;

    public Flux<TweetFeed> grabTweets(String text) {
        Queue<Status> queue = new ConcurrentLinkedQueue<>();
        TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
        twitterStream.addListener(new TwitterStreamListner(queue));
        twitterStream.filter(text);
        return Flux.interval(Duration.ofMillis(1000))
                .onBackpressureDrop()
                .map(aLong ->
                {
                    try {
                        return new TweetFeed(queue.poll());
                    } catch (Exception e) {
                        return new TweetFeed();
                    }
                }).filter(tweetFeed -> "en".equalsIgnoreCase(tweetFeed.getLanguage()))
                .map(t -> {
                    try {
                        return analyser.doAnalysis(t);
                    } catch (Exception e) {
                        System.out.println("monkey learn exception ...");
                        return t;
                    }
                });
    }
}
