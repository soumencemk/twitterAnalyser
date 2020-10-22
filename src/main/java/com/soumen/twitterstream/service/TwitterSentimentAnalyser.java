package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.TweetFeed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Component
@RequiredArgsConstructor
public class TwitterSentimentAnalyser {

    private final MonkeyLearnService monkeyLearnService;

    public TweetFeed doAnalysis(TweetFeed msg) throws ExecutionException, InterruptedException {
        CompletableFuture<String> mlFuture = monkeyLearnService.doAnalysis(msg);
        if (mlFuture != null) {
            CompletableFuture.allOf(mlFuture).join();
            msg.setSentiment(mlFuture.get());
        }
        return msg;
    }
}
