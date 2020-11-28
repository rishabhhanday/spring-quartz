package com.poc.quartz.jobs;

import com.poc.quartz.config.*;
import com.poc.quartz.entity.*;
import com.poc.quartz.repository.*;
import com.poc.quartz.service.*;
import lombok.extern.slf4j.*;
import org.quartz.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class TokenRefreshJob implements CustomJob {

  private final String tokenId = "e42763f1-535e-4683-83a6-944dd1da4f0f";
  private TokenRepository tokenRepository;
  private TokenService tokenService;

  public TokenRefreshJob() {
    this.tokenRepository = SpringContext.getBean(TokenRepository.class);
    this.tokenService = SpringContext.getBean(TokenService.class);
  }

  @Override
  public String getTriggerIdentity() {
    return "token-refresh";
  }

  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info("checking token expiry");

    String token = tokenRepository.findById(tokenId).get().getToken();

    if (tokenService.isTokenExpired(tokenId)) {
      log.info("Token expired, refreshing token");

      String refreshToken = tokenService.createToken();
      Token.builder().id(tokenId).token(refreshToken);
    }
  }
}
