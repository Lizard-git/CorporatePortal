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
@Table(name = "Messages", schema = "dashboard")
public class MessagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idChat")
    private ChatsEntity chat;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UsersEntity user;

    @Size(max = 3000, message = "Слишком длинная новось! Попробуйте разделить.")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "message", nullable = false, length = 3000)
    private String message;

    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "URLDoc", length = 1500)
    private String urlDoc;

    @Column(name = "URLImg", length = 1500)
    private String urlImg;
}
