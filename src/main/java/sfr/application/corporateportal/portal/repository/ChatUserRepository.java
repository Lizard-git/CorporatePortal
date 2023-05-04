package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.ChatUsersEntity;

public interface ChatUserRepository extends JpaRepository<ChatUsersEntity, Long> {
}