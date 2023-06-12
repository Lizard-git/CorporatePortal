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
@Table(name = "Authority", schema = "dashboard")
public class AuthorityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 50, message = "Имя прав доступа не должно быть более 50 символов")
    @NotEmpty(message = "Имя прав доступа не должно быть пустым")
    @UniqueElements(message = "Такое имя прав доступа уже сущесвует в системе")
    @Column(name = "name" , nullable = false, unique = true, length = 50)
    private String name;

    @NotEmpty(message = "Имя права доступа не может быть пустым. (Имя будет указанно в системе)")
    @Size(min = 20, max = 50, message = "Минимум - 20 символов, максимально - 50 символов для описания роли")
    @Column(name = "shortName", nullable = false, length = 50)
    private String shortName;

    @NotEmpty(message = "Описание прав доступа не может быть пустым. Опишите кратко какую функциональную особенность дают права доступа")
    @Size(min = 20, max = 256, message = "Минимум - 20 символов, максимально - 256 символов для описания прав доступа")
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "authority", fetch = FetchType.EAGER)
    private List<RolesEntity> roles;

    @ManyToMany(mappedBy = "authority", fetch = FetchType.LAZY)
    private List<ApplicationsEntity> applications;
}
