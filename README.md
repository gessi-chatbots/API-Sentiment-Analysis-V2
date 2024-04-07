# API Sentiment Analysis
A RESTFul API for Sentiment Analysis in Spanish.

## Documentation
https://twittersentimentanalysis.github.io/API-Sentiment-Analysis/javadoc/index.html

## Test
http://gessi-sw.essi.upc.edu:8080/sentiment-analysis-api/swagger-ui.html

## How to run 
### Local
1. Clone this project to a local folder and go to root folder

   `git clone https://github.com/twittersentimentanalysis/API-Sentiment-Analysis.git`

2. Build the Spring Boot project with Maven

    `mvn clean install`
    
3. Run the project

    `mvn spring-boot:run`
    
4. Go to http://localhost:8080/swagger-ui.html and test the API


### Tomcat
1. Clone this project to a local folder and go to root folder

   `git clone https://github.com/twittersentimentanalysis/API-Sentiment-Analysis.git`

2. Build the Spring Boot project with Maven to generate a WAR file

    `mvn clean package`
    
3. Run Tomcat server (you can download it [here](https://tomcat.apache.org/download-80.cgi))

4. Go to http://localhost:8080/manager/html

5. Load generated WAR file into section `Deploy > WAR file to deploy` and click on `Deploy`

    > *By default generated WAR file is saved on target folder in the root project folder*

6. Go to http://localhost:8080/sentiment-analysis-api/swagger-ui.html and test the API



***Note: File `src/main/resources/config.properties` can be modified at anytime to point to localhost or gessi endpoint.*


## Endpoints
### Base URLs
#### Localhost
http://localhost:8080/api/
#### GESSI Server
http://gessi-sw.essi.upc.edu:8080/sentiment-analysis-api/

### Path
#### Translator
`translator?translator=Microsoft`
#### Sentiment analysis
- BERT: `emotion?tool=BERT`
- BETO: `emotion?tool=BETO`
- SVC: `emotion?tool=SVC`
- ParallelDots: `emotion?tool=ParallelDots`


## How to deploy
1. 
    `docker build -t api_sentiment_analyisis:latest .`
2. 
    `docker run -d --name API_Sentiment_Analyisis -p 3005:3005 api_sentiment_analyisis:latest`
