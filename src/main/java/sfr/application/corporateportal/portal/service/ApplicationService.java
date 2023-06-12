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

    /**
     * Метод получает все статусы приложений из базы данных
     * @return List<ApplicationStatusEntity>
     */
    public List<ApplicationStatusEntity> getAllStatusApp() {
        return applicationStatusRepository.findAll();
    }

    /**
     * Метод получает все приложения зарегистрированные в базе данных
     * @return List<ApplicationsEntity>
     */
    public List<ApplicationsEntity> getAll() { return applicationRepository.findAll(); }

//    /**
//     * Метод вернет все приложения котрый доступны по правам доступа
//     * @param authority - права доступа
//     * @return List<ApplicationsEntity>
//     */
//    public List<ApplicationsEntity> getAllByAuthority(List<AuthorityEntity> authority) {
//        return applicationRepository.findAllByAuthority(authority);
//    }

    /**
     * Метод регистрирует новое приложение в базе данных путем добавления записи
     * @param application - сущность приложения
     */
    public void add(ApplicationsEntity application) {
        applicationRepository.save(application);
    }
}
