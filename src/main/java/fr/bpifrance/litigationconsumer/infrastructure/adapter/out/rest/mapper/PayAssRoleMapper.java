package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest.mapper;

import fr.bpifrance.litigationconsumer.domain.model.AddPayAssRoleResponse;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.ApiUpdateResponseDto;
import java.util.Collections;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class PayAssRoleMapper {

    public AddPayAssRoleResponse toDomain(ApiUpdateResponseDto dto) {
        if (dto == null) {
            return new AddPayAssRoleResponse(false, Collections.emptyList());
        }
        if (dto.getMessageList() == null) {
            return new AddPayAssRoleResponse(dto.isSuccess(), Collections.emptyList());
        }

        return new AddPayAssRoleResponse(
                dto.isSuccess(),
                dto.getMessageList().stream().map(Object::toString).collect(Collectors.toList()));
    }
}
