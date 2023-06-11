package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ApplicationStatus", schema = "dashboard")
public class ApplicationStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 50, message = "Имя статуса не должно быть более 50 символов")
    @NotEmpty(message = "Имя статуса не должно быть пустым")
    @UniqueElements(message = "Такое имя статуса уже сущесвует в системе")
    @Column(name = "statusName" , nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "description")
    private String description;
}
