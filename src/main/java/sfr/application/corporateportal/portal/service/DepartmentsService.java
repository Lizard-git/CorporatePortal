package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.repository.DepartmentsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;
    public List<DepartmentsEntity> getAllDepartment() {
        return departmentsRepository.findAll();
    }
}
