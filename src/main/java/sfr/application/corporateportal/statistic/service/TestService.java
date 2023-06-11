package sfr.application.corporateportal.statistic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.statistic.entity.MSZEntityInStatistic;
import sfr.application.corporateportal.statistic.repository.TestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    List<MSZEntityInStatistic> testServiceMethod(String snils) {
        return testRepository.getBySnilsContaining(snils);
    }
}
