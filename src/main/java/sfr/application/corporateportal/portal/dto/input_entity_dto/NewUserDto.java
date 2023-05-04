package sfr.application.corporateportal.portal.dto.input_entity_dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import sfr.application.corporateportal.portal.entity.AddressEntity;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserDto {

    //Логин пользователя
    @Size(max = 50, min = 5, message = "Значение логин должно быть от 5 до 50 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    //Пароль пользователя (для входа)
    @Size(max = 50, min = 5, message = "Значение пароля должно быть от 5 до 50 символов")
    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    //Фамилия
    @Size(max = 100, min = 2, message = "Фамилии должна быть от 2 до 100 символов")
    @NotEmpty(message = "Фамилия не может быть пустым")
    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    //Имя
    @Size(max = 100, min = 2, message = "Имя должно быть от 2 до 100 символов")
    @NotEmpty(message = "Имя не может быть пустым")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    //Отчество
    @Size(max = 100, min = 2,message = "Отчество должно быть от 2 до 100 символов")
    @Column(name = "middle_name", length = 100)
    private String middleName;

    //Адрес
    @OneToOne
    @Column(name = "idAddress")
    private AddressEntity idAddressEntity;

    //IP телефон
    @Size(max = 4, min = 4, message = "В IP номере 4 цифры")
    @Column(name = "ipPhone", length = 100)
    private String ipPhone;

    //Телефон
    @Column(name = "phone", length = 100)
    private String phone;

    //Мобильный телефон
    @Column(name = "mobilePhone", length = 100)
    private String mobilePhone;

    //Рабочий Email
    @Email(message = "Неверно введен Email")
    @Column(name = "workEmail", length = 100)
    private String workEmail;

    //Домашний Email
    @Email(message = "Неверно введен Email")
    @Column(name = "homeEmail", length = 100)
    private String homeEmail;

    //Опыт сотрудника (стаж)
    @Column(name = "dateExperience")
    private Date dateExperience;

    //Дата рождения
    @Column(name = "dateBirthday")
    private Date dateBirthday;

    //Номер кабинета
    @Column(name = "cabinetNumber", length = 50)
    private String cabinetNumber;

    //ip адресс рабочего компьютера
    @Column(name = "ipAddressPC", length = 50)
    private String ipAddressPC;
}
