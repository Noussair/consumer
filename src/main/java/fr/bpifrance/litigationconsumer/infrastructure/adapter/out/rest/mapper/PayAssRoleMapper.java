package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest.mapper;

import fr.bpifrance.litigationconsumer.domain.model.AddPayAssRoleResponse;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.ApiUpdateResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PayAssRoleMapper {

    public AddPayAssRoleResponse toDomain(ApiUpdateResponseDto dto) {
        if (dto == null) {
            return new AddPayAssRoleResponse(false);
        }
        return new AddPayAssRoleResponse(dto.isSuccess());
    }
}
