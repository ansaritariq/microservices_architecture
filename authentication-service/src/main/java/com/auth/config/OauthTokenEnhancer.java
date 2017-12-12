package com.auth.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.auth.entity.Users;
import com.auth.service.UserService;

@Component
public class OauthTokenEnhancer implements TokenEnhancer {

  @Autowired
  private UserService userService;
  
  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken,
      OAuth2Authentication authentication) {
    String userName = authentication.getName();
    Users user = userService.findByUsername(userName);
    final Map<String, Object> additionalInfo = new HashMap<>();
    additionalInfo.put("name", user.getFirstName());
    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
    return accessToken;
  }

}
