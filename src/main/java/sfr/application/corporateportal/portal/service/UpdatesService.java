package sfr.application.corporateportal.portal.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.repository.UpdatesRepository;

@Service
@AllArgsConstructor
@Slf4j
public class UpdatesService {
    private final UpdatesRepository updatesRepository;
    private final HistoryService historyService;
}
