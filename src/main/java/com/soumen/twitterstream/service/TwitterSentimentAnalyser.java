package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.Sentiments;
import com.soumen.twitterstream.model.TweetFeed;
import com.soumen.twitterstream.util.TweetCleaner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Component
@RequiredArgsConstructor
public class TwitterSentimentAnalyser {

    private final StanfordCoreNLPService stanfordCoreNLPService;

    public TweetFeed doAnalysis(TweetFeed tweetFeed) {
        tweetFeed.setMessageTxt(TweetCleaner.cleanTweet(tweetFeed.getMessageTxt()));
        int sentiment = stanfordCoreNLPService.analyse(tweetFeed.getMessageTxt());
        tweetFeed.setSentiment(Sentiments.getSentiment(sentiment));
        return tweetFeed;
    }
}
