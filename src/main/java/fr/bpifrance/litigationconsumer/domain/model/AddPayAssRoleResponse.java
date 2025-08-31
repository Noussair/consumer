package fr.bpifrance.litigationconsumer.domain.model;

import java.util.List;
import lombok.Value;

@Value
public class AddPayAssRoleResponse {
  boolean success;
  List<String> messages;
}
