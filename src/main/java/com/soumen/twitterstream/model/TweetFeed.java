package com.soumen.twitterstream.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import twitter4j.Status;

import java.util.Date;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Data
@NoArgsConstructor
public class TweetFeed {
    private String userName;
    private String userId;
    private Date postDate;
    private String messageTxt;
    private String userLocation;
    private String language;
    private Sentiments sentiment;

    public TweetFeed(Status status) {
        setUserId(String.valueOf(status.getUser().getId()));
        setUserName(status.getUser().getName());
        setPostDate(status.getCreatedAt());
        setMessageTxt(status.getText());
        setUserLocation(status.getUser().getLocation());
        setLanguage(status.getLang());
    }

    @Override
    public String toString() {
        return "{\"userName\":" + (userName == null ? "null" : "\"" + userName + "\"") + ", " +
                "\"messageTxt\":" + (messageTxt == null ? "null" : "\"" + messageTxt + "\"") + ", " +
                "\"sentiment\":" + (sentiment == null ? "null" : "\"" + sentiment + "\"") +
                "}";
    }
}
