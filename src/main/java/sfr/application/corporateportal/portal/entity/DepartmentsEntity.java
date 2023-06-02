package sfr.application.corporateportal.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Departments", schema = "dashboard")
public class DepartmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //Логин пользователя
    @Size(max = 256, min = 5, message = "Название отдела не может быть короче 5 символов и дленее 256 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "name", nullable = false, unique = true, length = 256)
    private String name;

    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    @NotEmpty(message = "Описание отдела не может быть пустым. Опишите кратко какую функциональную выполняет отдел")
    @Size(min = 20, max = 512, message = "Минимум - 20 символов, максимально - 512 символов для описания роли")
    @Column(name = "description", length = 512, nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "departments")
    private List<UsersEntity> users;
}
