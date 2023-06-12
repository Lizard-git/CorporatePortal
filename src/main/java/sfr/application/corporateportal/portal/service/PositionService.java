package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.PositionEntity;
import sfr.application.corporateportal.portal.repository.PositionRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;
    //private final HistoryService historyService;

    /**
     * Получает все должности сотрудников из базы данных
     * @return List<PositionEntity>
     */
    public List<PositionEntity> getAllPosition() {
        return positionRepository.findAll();
    }
}
