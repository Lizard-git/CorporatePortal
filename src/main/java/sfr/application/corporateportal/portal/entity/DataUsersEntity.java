package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "DataUser", schema = "dashboard")
public class DataUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    @Column(name = "middleName", length = 100)
    private String middleName;

    //Адрес
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAddress")
    private AddressEntity address;

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
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateExperience;

    //Дата рождения
    @Column(name = "dateBirthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateBirthday;

    //Номер кабинета
    @Column(name = "cabinetNumber", length = 50)
    private String cabinetNumber;

    //ip адресс рабочего компьютера
    @Column(name = "ipAddressPC", length = 50)
    private String ipAddressPC;

    @ManyToOne
    @JoinColumn(name = "idDdepartments")
    private DepartmentsEntity departments;

    @ManyToOne
    @JoinColumn(name = "position")
    private PositionEntity position;

    @OneToOne
    private UsersEntity user;
}
