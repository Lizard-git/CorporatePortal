package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.ApplicationsEntity;

public interface ApplicationRepository extends JpaRepository<ApplicationsEntity, Long> {
    //List<ApplicationsEntity> findAllByAuthority(List<AuthorityEntity> authority);
}