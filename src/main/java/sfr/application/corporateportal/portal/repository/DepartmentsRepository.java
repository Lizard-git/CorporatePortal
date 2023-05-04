package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;

public interface DepartmentsRepository extends JpaRepository<DepartmentsEntity, Long> {
}