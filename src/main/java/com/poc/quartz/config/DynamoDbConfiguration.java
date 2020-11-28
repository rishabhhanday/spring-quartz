package com.poc.quartz.config;

import com.amazonaws.auth.*;
import com.amazonaws.client.builder.*;
import com.amazonaws.regions.*;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.*;
import org.socialsignin.spring.data.dynamodb.repository.config.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.poc.quartz.repository")
public class DynamoDbConfiguration {

  @Value("${amazon.dynamodb.endpoint}")
  private String amazonDynamoDBEndpoint;

  @Value("${amazon.aws.accesskey}")
  private String amazonAWSAccessKey;

  @Value("${amazon.aws.secretkey}")
  private String amazonAWSSecretKey;

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    return AmazonDynamoDBClientBuilder
        .standard()
        .withCredentials(new AWSStaticCredentialsProvider(
            new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey)))
        .withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint,
                Regions.DEFAULT_REGION.getName()))
        .build();
  }

  @Bean
  public DynamoDB dynamoDB() {
    return new DynamoDB(amazonDynamoDB());
  }
}
