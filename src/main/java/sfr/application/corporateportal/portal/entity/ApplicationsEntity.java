package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Application", schema = "dashboard", uniqueConstraints = { @UniqueConstraint(name = "uk_nameApp", columnNames = "name")})
public class ApplicationsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "URL не должно быть пустым")
    @Column(name = "url", nullable = false, unique = true)
    private String url;

    @NotEmpty(message = "Описание приложения не должно быть пустым")
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty(message = "Имя приложения не должно быть пустым")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "urlImage")
    private String img;

    @Column(name = "urlInstruction")
    private String instruction;

    @ManyToOne
    @JoinColumn(name = "idStatus")
    private ApplicationStatusEntity status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Application_Authority",
            joinColumns = {@JoinColumn(name = "application_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_APPLICATION_AUTHORITY"))},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_1_AUTHORITY_APPLICATION"))},
            schema = "dashboard"
    )
    private List<AuthorityEntity> authority;
}
