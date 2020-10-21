package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.Search;
import com.soumen.twitterstream.repo.SearchRepo;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchRecorderService {
    private final SearchRepo searchRepo;

    @Async
    public void recordSearch(String searchText) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Search search = new Search();
        search.setUserName(authentication.getName());
        search.setSearchText(searchText);
        searchRepo.save(search);
    }

}
