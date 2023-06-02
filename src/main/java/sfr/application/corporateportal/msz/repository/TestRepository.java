package sfr.application.corporateportal.msz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.msz.entity.TestEntity;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
    List<TestEntity> getBySnilsContaining(String snils);
}