package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Chat_User", schema = "dashboard")
public class ChatUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "idChat")
    private ChatsEntity chat;

    @Column(name = "isAdmin")
    private Boolean isAdmin;

    @CreatedDate
    @Column(name = "dateAddInChat")
    private Date dateAddInChat;
}
