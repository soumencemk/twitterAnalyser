package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.TweetFeed;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import twitter4j.Status;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class TwitterGrabberService {

    private final TwitterSentimentAnalyser analyser;

    public Flux<TweetFeed> grabTweets(String text) {
        Queue<Status> queue = new ConcurrentLinkedQueue<>();
        TwitterStream twitterStream = TwitterStreamFactory.getSingleton();
        twitterStream.addListener(new TwitterStreamListner(queue));
        twitterStream.filter(text);
        return Flux.interval(Duration.ofMillis(500))
                .onBackpressureDrop()
                .map(aLong ->
                {
                    try {
                        Status tweet = queue.poll();
                        return tweet == null ? new TweetFeed() : new TweetFeed(tweet);
                    } catch (Exception e) {
                        log.error(e);
                        return new TweetFeed();
                    }
                }).filter(tweetFeed -> "en".equalsIgnoreCase(tweetFeed.getLanguage()))
                .map(t -> {
                    try {
                        return analyser.doAnalysis(t);
                    } catch (Exception e) {
                        log.error("monkey learn exception", e);
                        return t;
                    }
                });
    }
}
