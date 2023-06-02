package sfr.application.corporateportal.portal.dto.input_entity_dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDataDTO {
    @Size(max = 50, min = 6, message = "Значение пароля должно быть от 6 до 50 символов")
    private String oldPassword;

    @Size(max = 50, min = 6, message = "Значение пароля должно быть от 6 до 50 символов")
    private String newPassword;

    @Size(max = 50, min = 6, message = "Значение пароля должно быть от 6 до 50 символов")
    private String newCheckPassword;
}
