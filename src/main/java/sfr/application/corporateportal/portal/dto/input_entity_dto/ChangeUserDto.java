package sfr.application.corporateportal.portal.dto.input_entity_dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import sfr.application.corporateportal.portal.entity.AddressEntity;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.PositionEntity;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeUserDto {
    //Фамилия
    @Size(max = 100, min = 2, message = "Фамилии должна быть от 2 до 100 символов")
    @NotEmpty(message = "Фамилия не может быть пустым")
    private String surname;

    //Имя
    @Size(max = 100, min = 2, message = "Имя должно быть от 2 до 100 символов")
    @NotEmpty(message = "Имя не может быть пустым")
    private String name;

    //Отчество
    @Size(max = 100, message = "Отчество должно быть до 100 символов")
    private String middleName;

    //Адрес
    private AddressEntity address;

    //IP телефон
    private String ipPhone;

    //Телефон
    private String phone;

    //Мобильный телефон
    private String mobilePhone;

    //Рабочий Email
    @Email(message = "Неверно введен Email")
    private String workEmail;

    //Домашний Email
    @Email(message = "Неверно введен Email")
    private String homeEmail;

    //Дата рождения
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirthday;

    //Номер кабинета
    private String cabinetNumber;

    //ip адресс рабочего компьютера
    private String ipAddressPC;

    private DepartmentsEntity departments;

    private PositionEntity position;

}
