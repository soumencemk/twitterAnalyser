package com.soumen.twitterstream.repo;

import com.soumen.twitterstream.model.Search;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchRepo extends MongoRepository<Search,Long> {}
