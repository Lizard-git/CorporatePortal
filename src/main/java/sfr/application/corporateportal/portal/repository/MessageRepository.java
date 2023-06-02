package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.ChatsEntity;
import sfr.application.corporateportal.portal.entity.MessagesEntity;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessagesEntity, Long> {
    List<MessagesEntity> getAllByChat(ChatsEntity chat);
}