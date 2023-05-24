package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.PositionEntity;
import sfr.application.corporateportal.portal.repository.PositionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    /**
     * Получает все должности сотрудников
     * @return List<PositionEntity>
     */
    public List<PositionEntity> getAllPosition() {
        return positionRepository.findAll();
    }

    // Методы CRUD
}
