package com.poc.quartz;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import java.time.*;
import java.time.temporal.*;
import java.util.*;
import org.junit.jupiter.api.*;

public class TestToken {

  @Test
  void createToken() {
    Algorithm algorithm = Algorithm.HMAC256("secret");
    String token = JWT.create()
        .withExpiresAt(Date.from(Instant.now().minus(5, ChronoUnit.HOURS)))
        .sign(algorithm);

    System.out.println(token);
  }
}
