package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.FilesEntity;
import sfr.application.corporateportal.portal.entity.FilesStatusEntity;
import sfr.application.corporateportal.portal.repository.FilesRepository;
import sfr.application.corporateportal.portal.repository.FilesStatusRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FilesService {
    private final HistoryService historyService;
    private final FilesRepository filesRepository;
    private final FilesStatusRepository filesStatusRepository;

    public List<FilesStatusEntity> getAllStatus() {
        return filesStatusRepository.findAll();
    }

    public void save(FilesEntity file) {
        filesRepository.save(file);
    }

    public List<FilesEntity> getAll() {
        return filesRepository.findAll();
    }

    public List<FilesEntity> getAllByStatus(FilesStatusEntity filesStatus) {
        return filesRepository.getAllByStatus(filesStatus);
    }

    public void addFile(FilesEntity files) {
        filesRepository.save(files);
    }


}
