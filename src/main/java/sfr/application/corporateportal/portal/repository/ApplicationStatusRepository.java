package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.ApplicationStatusEntity;

public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatusEntity, Long> {
}