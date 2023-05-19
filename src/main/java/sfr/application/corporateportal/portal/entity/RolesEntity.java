package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Roles", schema = "dashboard")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 50, message = "Имя роли не должно быть более 50 символов")
    @NotEmpty(message = "Имя роли не должно быть пустым, ")
    @UniqueElements(message = "Такое имя роли уже существует")
    @Column(name = "name" , nullable = false, unique = true, length = 50)
    private String name;

    @NotEmpty(message = "Имя роли не может быть пустым. Которую пользователи будут видет в системе, например: \"Администратор\"")
    @Size(min = 20, max = 50, message = "Минимум - 20 символов, максимально - 50 символов для описания роли")
    @Column(name = "shortName", length = 50)
    private String shortName;

    @NotEmpty(message = "Описание роли не может быть пустым. Опишите кратко какую функциональную особенность дает роль")
    @Size(min = 20, max = 256, message = "Минимум - 20 символов, максимально - 256 символов для описания роли")
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<UsersEntity> users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "Roles_Authority",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_ROLE_USER"))},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_AUTHORITY_ROLE"))},
            schema = "dashboard"
    )
    private List<AuthorityEntity> authority;
}
