package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.HistoryEntity;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
}