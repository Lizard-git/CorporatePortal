package sfr.application.corporateportal.msz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.msz.entity.MSZEntity;

import java.util.List;

public interface TestRepository extends JpaRepository<MSZEntity, Long> {
    List<MSZEntity> getBySnilsContaining(String snils);
}