package com.soumen.twitterstream.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Search {
    @Id
    private String id;
    private String userName;
    private String searchText;
}
