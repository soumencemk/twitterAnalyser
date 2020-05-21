# Twitter Stream analyser
Using Twitter4j and MonkeyLearn API
Demo : [https://twittersoumen.herokuapp.com/](https://twittersoumen.herokuapp.com/)
#How to use
* Register for Twitter4j and Monkey learn age get the API Keys
* Relace the values in `application.properties` and `twitter4j.properties`-
application.properties:  
``` java
# Monkey Learn --
monkeylearn.apikey=<EnterAPIKey>
monkeylearn.model_id=<Enter Model ID>
```
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