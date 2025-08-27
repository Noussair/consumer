package fr.bpifrance.litigationconsumer.infrastructure.model.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddActRoleRequestDto {

  @NotBlank(message = "actcode is required")
  @JsonProperty("actcode")
  private String actcode;

  @NotBlank(message = "rolcode is required")
  @JsonProperty("rolcode")
  private String rolcode;

  @NotBlank(message = "actcodegest is required")
  @JsonProperty("actcodegest")
  private String actcodegest;
}
