package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.FilesStatusEntity;

public interface FilesStatusRepository extends JpaRepository<FilesStatusEntity, Long> {
}