package com.soumen.twitterstream.util;

public class TweetCleaner {

    public static String cleanTweet(String tweet) {
        return tweet.trim()
                .replaceAll("http.*?[\\S]+", "")
                .replaceAll("@[\\S]+", "")
                .replaceAll("[\\s]+", " ")
                .replaceAll("#", "");
    }
}
