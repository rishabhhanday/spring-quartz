package com.poc.quartz.service;

import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.exceptions.*;
import com.poc.quartz.repository.*;
import java.time.*;
import java.time.temporal.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class TokenService {

  @Autowired
  TokenRepository tokenRepository;
  Algorithm algorithm = Algorithm.HMAC256("secret");

  public Boolean isTokenExpired(String token) {
    try {
      JWTVerifier verifier = JWT.require(algorithm)
          .build();
      verifier.verify(token);
    } catch (JWTVerificationException exception) {
      return true;
    }

    return false;
  }

  public String createToken() {
    return JWT.create()
        .withExpiresAt(Date.from(Instant.now().minus(5, ChronoUnit.HOURS)))
        .sign(algorithm);
  }
}
