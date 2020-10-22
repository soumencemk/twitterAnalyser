package com.soumen.twitterstream.service;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnResponse;
import com.soumen.twitterstream.model.TweetFeed;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Service
@RequiredArgsConstructor
public class MonkeyLearnService {

    private final MonkeyLearn monkeyLearn;
    @Value("${monkeylearn.model_id}")
    private String modelId;

    @SneakyThrows
    @Async
    public CompletableFuture<String> doAnalysis(TweetFeed feed) {
        String[] data = new String[1];
        data[0] = feed.getMessageTxt();
        try {
            MonkeyLearnResponse res = monkeyLearn.classifiers.classify(modelId, data);
            String s = res.arrayResult.toJSONString();
            return CompletableFuture.completedFuture(s);
        } catch (Exception e) {
            throw new Exception("Monkey Learn service not available : " + e.getMessage());
        }
    }
}
