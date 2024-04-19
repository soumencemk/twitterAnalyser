# Twitter Stream analyser 
![Java CI with Maven](https://github.com/soumencemk/twitterAnalyser/workflows/Java%20CI%20with%20Maven/badge.svg) ![GitHub language count](https://img.shields.io/github/languages/count/soumencemk/twitterAnalyser?style=plastic)

Using Twitter4j and ![Stanford NLP Library](https://stanfordnlp.github.io/)

# How to use
* Register for Twitter4j and get the API Keys
* Relace the values in `twitter4j.properties`-

twitter4j.properties
``` java
oauth.consumerKey=<>
oauth.consumerSecret=<>
oauth.accessToken=<>
oauth.accessTokenSecret=<>
```
* Then run the spring boot app either from command line or using maven 
```shell
./mvnw spring-boot:run
```
Open `http://localhost:8080/` and Enjoy !
