package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Long> {
}