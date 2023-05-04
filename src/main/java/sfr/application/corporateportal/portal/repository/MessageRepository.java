package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.MessagesEntity;

public interface MessageRepository extends JpaRepository<MessagesEntity, Long> {
}