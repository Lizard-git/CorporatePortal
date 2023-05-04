package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {
}