package com.soumen.twitterstream.controller;

import com.soumen.twitterstream.model.TweetFeed;
import com.soumen.twitterstream.service.SearchRecorderService;
import com.soumen.twitterstream.service.TwitterGrabberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@RestController
@RequiredArgsConstructor
public class Controller {

    private final TwitterGrabberService twitterGrabberService;
    private final SearchRecorderService searchRecorderService;

    @GetMapping(value = "/tweets/{text}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TweetFeed> streamOfTweets(@PathVariable String text, ServerWebExchange webExchange) {
        searchRecorderService.recordSearch("local", text,webExchange);
        return twitterGrabberService.grabTweets(text);

    }

    @GetMapping("/user")
    public Mono<Map<String, Object>> user() {
        return Mono.just(Collections.singletonMap("name", "localUser"));
    }
}

