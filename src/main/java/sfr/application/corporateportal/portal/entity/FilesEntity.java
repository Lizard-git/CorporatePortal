package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Files", schema = "dashboard")
public class FilesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 100, min = 2, message = "Имя должно быть от 2 до 100 символов")
    @NotEmpty(message = "Имя не может быть пустым")
    @Column(name = "tagName", nullable = false, length = 100)
    private String tagName;

    @Column(name = "URLImg", length = 1500)
    private String urlImg;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private UsersEntity userAdd;

    @ManyToOne
    @JoinColumn(name = "idStatus", nullable = false)
    private FilesStatusEntity status;
}
