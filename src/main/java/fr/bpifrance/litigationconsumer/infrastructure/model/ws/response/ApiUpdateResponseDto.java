package fr.bpifrance.litigationconsumer.infrastructure.model.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.bpifrance.litigationconsumer.infrastructure.model.type.ErrorMessage;
import java.util.List;
import lombok.Data;

@Data
public class ApiUpdateResponseDto {

  @JsonProperty("STATUS")
  private String STATUS;

  @JsonProperty(" messageList")
  private List<ErrorMessage> messageList;

  public boolean isSuccess() {
    return "OK".equals(STATUS);
  }
}
