package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.FilesEntity;
import sfr.application.corporateportal.portal.entity.FilesStatusEntity;

import java.util.List;

public interface FilesRepository extends JpaRepository<FilesEntity, Long> {
    List<FilesEntity> getAllByStatus(FilesStatusEntity status);
}