package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.ApplicationStatusEntity;
import sfr.application.corporateportal.portal.entity.ApplicationsEntity;
import sfr.application.corporateportal.portal.repository.ApplicationRepository;
import sfr.application.corporateportal.portal.repository.ApplicationStatusRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationStatusRepository applicationStatusRepository;
    private final HistoryService historyService;

    public List<ApplicationStatusEntity> getAllStatusApp() {
        return applicationStatusRepository.findAll();
    }

    public List<ApplicationsEntity> getAll() { return applicationRepository.findAll(); }

    public void add(ApplicationsEntity application) {
        applicationRepository.save(application);
    }
}
