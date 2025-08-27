package fr.bpifrance.litigationconsumer.infrastructure.model.type;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessage {
  @JsonProperty("DOSREFERENCE")
  private String dosReference;

  @JsonProperty("TTCCODE")
  private String ttcCode;

  @JsonProperty("MSGID")
  private String msgId;

  @JsonProperty("MSGLIBELLE")
  private String msgLibelle;

  @JsonProperty("FLAGERROR")
  private int flagError;

  @Override
  public String toString() {
    return msgLibelle;
  }
}
