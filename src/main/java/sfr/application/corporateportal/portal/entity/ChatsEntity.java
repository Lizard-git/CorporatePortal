package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
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
@Table(name = "Chats", schema = "dashboard")
public class ChatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UsersEntity user;

    @Size(max = 100, message = "Слишком длинный название")
    @Column(name = "name", length = 100)
    private String name;

    @CreatedDate
    @Column(name = "creationDate")
    private Date creationDate;

    @Column(name = "URLImg", length = 1500)
    private String urlImg;

    @OneToMany(mappedBy = "chat", fetch = FetchType.EAGER)
    private List<ChatUsersEntity> usersInChat;
}
