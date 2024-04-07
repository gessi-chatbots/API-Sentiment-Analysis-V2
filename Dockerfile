FROM maven:3.8.6-openjdk-18-slim

WORKDIR /api-sentiment

COPY . /api-sentiment/

RUN mvn clean package

EXPOSE 3005

CMD ["java", "-jar", "./target/sentiment-analysis-api.war"]
