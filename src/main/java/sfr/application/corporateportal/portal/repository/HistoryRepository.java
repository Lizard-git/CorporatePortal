package sfr.application.corporateportal.portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.HistoryEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    Page<HistoryEntity> findByUser(UsersEntity user, Pageable pageable);
}