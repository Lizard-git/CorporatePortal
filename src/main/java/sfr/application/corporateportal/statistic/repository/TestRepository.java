package sfr.application.corporateportal.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.statistic.entity.MSZEntityInStatistic;

import java.util.List;

public interface TestRepository extends JpaRepository<MSZEntityInStatistic, Long> {
    List<MSZEntityInStatistic> getBySnilsContaining(String snils);
}