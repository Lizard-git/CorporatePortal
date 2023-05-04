package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Updates", schema = "dashboard")
public class UpdatesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 10, min = 5, message = "Значение логин должно быть от 5 до 50 символов")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "versionUpdate")
    private String version;

    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    @NotEmpty(message = "Описание обновления не может быть пустым. Опишите кратко что нового!")
    @Size(min = 20, max = 512, message = "Минимум - 20 символов, максимально - 512 символов для описания роли")
    @Column(name = "description", length = 512, nullable = false)
    private String description;
}
