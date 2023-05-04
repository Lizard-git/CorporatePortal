package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.RolesEntity;

public interface RoleRepository extends JpaRepository<RolesEntity, Long> {
}