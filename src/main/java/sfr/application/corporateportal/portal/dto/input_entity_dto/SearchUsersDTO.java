package sfr.application.corporateportal.portal.dto.input_entity_dto;

import lombok.*;
import sfr.application.corporateportal.portal.entity.AddressEntity;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchUsersDTO {
    private AddressEntity address;

    private DepartmentsEntity department;

    private String FullName;

    private String Phone;

    private String Position;
}
