package sfr.application.corporateportal.msz.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.msz.entity.TestEntity;
import sfr.application.corporateportal.msz.repository.TestRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    List<TestEntity> testServiceMethod(String snils) {
        return testRepository.getBySnilsContaining(snils);
    }
}
