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
@Table(name = "Position", schema = "dashboard")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 256, message = "Слишком длинное название должности")
    @NotEmpty(message = "Название должности не может быть пустым")
    @UniqueElements(message = "Такое название должности уже существует")
    @Column(name = "name" , nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "position")
    private List<DataUsersEntity> users;
}
