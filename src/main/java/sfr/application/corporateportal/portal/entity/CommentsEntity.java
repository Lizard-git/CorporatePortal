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
@Table(name = "Comments", schema = "dashboard")
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idNews", nullable = false)
    private NewsEntity news;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private UsersEntity user;

    @Size(max = 1000, message = "Слишком длинный комментарий!")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "text", nullable = false, length = 1000)
    private String text;

    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;
}
