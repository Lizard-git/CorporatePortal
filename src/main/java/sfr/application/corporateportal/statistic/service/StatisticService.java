package sfr.application.corporateportal.statistic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.statistic.entity.StatisticEntity;
import sfr.application.corporateportal.statistic.repository.StatisticRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StatisticService {
    private final StatisticRepository statisticRepository;

    List<StatisticEntity> getAll() {
        return statisticRepository.findAll();
    }
}
