package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.ChatUsersEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;

import java.util.List;

public interface ChatUserRepository extends JpaRepository<ChatUsersEntity, Long> {
    List<ChatUsersEntity> getAllByUser(UsersEntity user);
}