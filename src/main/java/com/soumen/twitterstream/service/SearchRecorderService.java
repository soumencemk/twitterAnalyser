package com.soumen.twitterstream.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SearchRecorderService {

    @Async
    public void recordSearch(String searchText) {
    }

}
