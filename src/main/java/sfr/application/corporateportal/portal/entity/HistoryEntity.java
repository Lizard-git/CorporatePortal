package sfr.application.corporateportal.portal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "History", schema = "dashboard")
public class HistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "action", length = 512, nullable = false)
    private String action;

    @CreatedDate
    @Column(name = "dateAction", nullable = false)
    private LocalDateTime dateAction;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private UsersEntity user;
}
