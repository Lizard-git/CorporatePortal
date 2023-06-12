package sfr.application.corporateportal.msz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sfr.application.corporateportal.msz.entity.MSZEntity;

import java.util.List;

@Repository
public interface MSZRepository extends JpaRepository<MSZEntity, Long> {
    List<MSZEntity> getBySnilsContaining(String snils);
}