package sfr.application.corporateportal.portal.dto.input_entity_dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthDataDTO {
    private Long idUser;

    @Size(max = 50, message = "Значение логин должно быть до 50 символов")
    private String login;

    @Size(max = 50, min = 6, message = "Значение пароля должно быть от 5 до 50 символов")
    private String oldPassword;

    @Size(max = 50, min = 6, message = "Значение пароля должно быть от 5 до 50 символов")
    private String newPassword;

    @Size(max = 50, min = 6, message = "Значение пароля должно быть от 5 до 50 символов")
    private String newCheckPassword;
}
