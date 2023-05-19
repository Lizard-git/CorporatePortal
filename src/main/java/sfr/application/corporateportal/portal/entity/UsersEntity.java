package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @Size(max = 50, min = 5, message = "Значение пароля должно быть от 5 до 50 символов")
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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dataUser", nullable = false)
    private DataUsersEntity data;

    @OneToMany(mappedBy = "user")
    private List<NewsEntity> news;

    @OneToMany(mappedBy = "user")
    private List<ChatsEntity> chats;

    @OneToMany(mappedBy = "user")
    private List<ChatUsersEntity> chatsUsers;

    @OneToMany(mappedBy = "userAdd")
    private List<FilesEntity> files;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Users_Roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_USER_ROLES"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_ROLES_USER"))},
            schema = "dashboard"
    )
    private List<RolesEntity> roles;
}
