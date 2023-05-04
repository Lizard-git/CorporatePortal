package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.UpdatesEntity;

public interface UpdatesRepository extends JpaRepository<UpdatesEntity, Long> {
}