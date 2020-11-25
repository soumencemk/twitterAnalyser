package com.soumen.twitterstream.controller;

import com.soumen.twitterstream.model.TweetFeed;
import com.soumen.twitterstream.service.TwitterGrabberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/twitter-analyser")
public class Controller {

    private final TwitterGrabberService twitterGrabberService;

    @GetMapping(value = "/tweets/search/{text}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TweetFeed> streamOfTweets(@PathVariable String text) {
        return twitterGrabberService.grabTweets(text);

    }
}

