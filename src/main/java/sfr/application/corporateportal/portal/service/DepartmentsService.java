package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.repository.DepartmentsRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;
    //private final HistoryService historyService;

    /**
     * Метод получает все отделы из базы данных
     * @return List<DepartmentsEntity>
     */
    public List<DepartmentsEntity> getAllDepartment() {
        return departmentsRepository.findAll();
    }
}
