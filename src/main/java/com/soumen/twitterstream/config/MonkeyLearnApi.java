package com.soumen.twitterstream.config;

import com.monkeylearn.MonkeyLearn;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Configuration
public class MonkeyLearnApi {

    @Value("${monkeylearn.apikey}")
    private String apiKey;

    @Bean
    public MonkeyLearn monkeyLearn(){
        MonkeyLearn monkeyLearn = new MonkeyLearn(apiKey);
        return monkeyLearn;
    }
}
