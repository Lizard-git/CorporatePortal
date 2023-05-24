package sfr.application.corporateportal.portal.entity;

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
@Table(name = "News", schema = "dashboard")
public class NewsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 100, message = "Слишком длинный заколовок")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "title", nullable = false, unique = true, length = 100)
    private String title;

    @Size(max = 3000, message = "Слишком длинная новось! Попробуйте разделить.")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "text", nullable = false, length = 3000)
    private String text;

    @Column(name = "URLDoc", length = 1500)
    private String urlDoc;

    @Column(name = "URLImg", length = 1500)
    private String urlImg;

    //Добавить при следующем рендеренге базы
//    @Column(name = "type")
//    private String type;

    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "userPublication", nullable = false)
    private UsersEntity user;

    @OneToMany(mappedBy = "news")
    private List<CommentsEntity> comments;
}
