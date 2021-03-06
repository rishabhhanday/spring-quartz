package com.poc.quartz.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Token")
@Builder
public class Token {

  @DynamoDBHashKey
  @DynamoDBAutoGeneratedKey
  private String id;

  @DynamoDBAttribute
  private String token;
}
