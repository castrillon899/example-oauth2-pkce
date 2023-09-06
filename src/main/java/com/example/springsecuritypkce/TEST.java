package com.example.springsecuritypkce;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.util.StringUtils;

public class TEST {
  public static void main(String[] args) {

      String codeVerifier = "8b876fc78b3ca6f51dca057013207ace265567bdd314dd9adb563393";
      String codeChallengeMethod = "S256";
      String codeChallenge = "wd5lR3j27YXK2FOOAfmyyrjFMBWO8SB85sVUkkiXrW4";
        if ("S256".equals(codeChallengeMethod)) {
          try {
              MessageDigest md = MessageDigest.getInstance("SHA-256");
              byte[] digest = md.digest(codeVerifier.getBytes(StandardCharsets.US_ASCII));
              String encodedVerifier = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
          System.out.println(encodedVerifier.equals(codeChallenge));
          } catch (NoSuchAlgorithmException ex) {
              // It is unlikely that SHA-256 is not available on the server. If it is not available,
              // there will likely be bigger issues as well. We default to SERVER_ERROR.
              throw new OAuth2AuthenticationException(OAuth2ErrorCodes.SERVER_ERROR);
          }
      }

  }
}
