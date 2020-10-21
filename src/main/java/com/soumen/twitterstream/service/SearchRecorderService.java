package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.Search;
import com.soumen.twitterstream.repo.SearchRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchRecorderService {
    private final SearchRepo searchRepo;

    @Async
    public void recordSearch(String userName, String searchText) {
        Search search = new Search();
        search.setUserName(userName);
        search.setSearchText(searchText);
        searchRepo.save(search);
    }

}
