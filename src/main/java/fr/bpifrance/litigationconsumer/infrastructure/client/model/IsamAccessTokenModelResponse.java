package fr.bpifrance.litigationconsumer.infrastructure.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class IsamAccessTokenModelResponse {

  @JsonProperty("access_token")
  public String accessToken;

  @JsonProperty("scope")
  public String scope;

  @JsonProperty("token_type")
  public String tokenType;

  @JsonProperty("expires_in")
  public Integer expiresIn;
}
