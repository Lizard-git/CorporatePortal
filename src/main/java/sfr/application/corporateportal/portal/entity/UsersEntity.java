package sfr.application.corporateportal.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users", schema = "dashboard")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Логин пользователя
    @Size(max = 50, min = 5, message = "Значение логин должно быть от 5 до 50 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "login", nullable = false, unique = true, length = 50)
    private String login;

    //Пароль пользователя (для входа)
    @JsonIgnore
    @Size(max = 100, min = 5, message = "Значение пароля должно быть от 5 до 100 символов")
    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    //Дата создания пользователя
    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    //Дата последнего изменения учетных данных
    @LastModifiedDate
    @Column ( name =  "lastModifiedDate" )
    private Date lastModifiedDate ;

    //Дата удаления пользователя
    @Column(name = "deleteDate")
    private Date deleteDate;

    //Срок действия учетной записи не истек
    @Column(name = "isAccountNonExpired")
    private Boolean isAccountNonExpired;

    //учетная запись не заблокирована
    @Column(name = "isAccountNonLocked")
    private Boolean isAccountNonLocked;

    //Срок действия учетных данных не истек
    @Column(name = "isCredentialsNonExpired")
    private Boolean isCredentialsNonExpired;

    //включен
    @Column(name = "isEnabled")
    private Boolean isEnabled;

//    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
//    @JoinColumn(name = "dataUser", nullable = false)
//    private DataUsersEntity data;

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
    @Size(max = 100, message = "Отчество должно быть до 100 символов")
    @Column(name = "middleName", length = 100)
    private String middleName;

    //Адрес
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAddress")
    private AddressEntity address;

    //IP телефон
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


    //Удалить при следующей генерации
    //Опыт сотрудника (стаж)
    @Column(name = "dateExperience")
    @CreatedDate
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateExperience;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDdepartments")
    private DepartmentsEntity departments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position")
    private PositionEntity position;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<NewsEntity> news;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ChatsEntity> chats;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ChatUsersEntity> chatsUsers;

    @JsonIgnore
    @OneToMany(mappedBy = "userAdd", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FilesEntity> files;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Users_Roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_USER_ROLES"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_ROLES_USER"))},
            schema = "dashboard"
    )
    private List<RolesEntity> roles;
}
