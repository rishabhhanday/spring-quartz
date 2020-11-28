package com.poc.quartz.repository;

import com.poc.quartz.entity.*;
import org.socialsignin.spring.data.dynamodb.repository.*;
import org.springframework.data.repository.*;

@EnableScan
public interface TokenRepository extends CrudRepository<Token, String> {

}
