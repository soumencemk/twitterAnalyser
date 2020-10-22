package com.soumen.twitterstream.service;

import lombok.RequiredArgsConstructor;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

import java.util.Queue;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@RequiredArgsConstructor
public class TwitterStreamListner implements StatusListener {

    private final Queue<Status> queue;

    @Override
    public void onStatus(Status status) {
        queue.offer(status);
    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

    }

    @Override
    public void onScrubGeo(long userId, long upToStatusId) {

    }

    @Override
    public void onStallWarning(StallWarning warning) {

    }

    @Override
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
}
