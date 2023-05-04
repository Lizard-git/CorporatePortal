package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}