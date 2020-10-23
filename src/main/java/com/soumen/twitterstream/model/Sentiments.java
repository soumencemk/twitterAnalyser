package com.soumen.twitterstream.model;

public enum Sentiments {
    Very_Negative(0),
    Negative(1),
    Neutral(2),
    Positive(3),
    Very_Positive(4);

    public final int value;

    Sentiments(int i) {
        this.value = i;
    }

    public static Sentiments getSentiment(int n) {
        for (Sentiments elem : values()) {
            if (elem.value == n) {
                return elem;
            }
        }
        return null;
    }
}
