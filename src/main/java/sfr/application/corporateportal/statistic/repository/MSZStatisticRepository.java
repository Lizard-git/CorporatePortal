package sfr.application.corporateportal.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sfr.application.corporateportal.statistic.entity.MSZEntityInStatistic;

import java.util.List;

@Repository
public interface MSZStatisticRepository extends JpaRepository<MSZEntityInStatistic, Long> {
    List<MSZEntityInStatistic> getBySnilsContaining(String snils);
}