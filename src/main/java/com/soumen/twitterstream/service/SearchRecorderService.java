package com.soumen.twitterstream.service;

import com.soumen.twitterstream.model.Search;
import com.soumen.twitterstream.repo.SearchRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import java.util.Objects;

@Service
@AllArgsConstructor
public class SearchRecorderService {
    private final SearchRepo searchRepo;

    @Async
    public void recordSearch(String userName, String searchText, ServerWebExchange webExchange) {
        Search search = new Search();
        search.setUserName(userName);
        search.setSearchText(searchText);
        ServerHttpRequest request = webExchange.getRequest();
        String hostAddress = Objects.requireNonNull(request.getRemoteAddress()).getAddress().getHostAddress();
        search.setIpAddress(hostAddress);
        String header = request.getHeaders().toString();
        search.setHeader(header);
        searchRepo.save(search);
    }

}
