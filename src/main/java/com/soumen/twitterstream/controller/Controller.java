package com.soumen.twitterstream.controller;

import com.soumen.twitterstream.model.TweetFeed;
import com.soumen.twitterstream.service.TwitterGrabberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(value = "/tweets/{text}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<TweetFeed> streamOfTweets(@PathVariable String text) {
        return twitterGrabberService.grabTweets(text);

    }

    @GetMapping("/user")
    public Mono<Map<String, Object>> user(@AuthenticationPrincipal OAuth2User principal) {
        return Mono.just(Collections.singletonMap("name", principal.getAttribute("name")));
    }
}

