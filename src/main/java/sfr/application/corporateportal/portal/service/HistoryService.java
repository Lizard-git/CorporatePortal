package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.HistoryEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.HistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    /**
     * Создает новую историю в приложении
     * @param msg - текстовые изменения
     * @param user - пользователь, который внес изменения в программу
     */
    public void addNewHistory(String msg, UsersEntity user) {
        HistoryEntity newHistory = HistoryEntity.builder()
                .action(msg)
                .dateAction(LocalDateTime.now())
                .user(user)
                .build();
        historyRepository.save(newHistory);
    }

    /**
     * вернет список всех событий в программе
     * @param pageable - объект пагинации
     * @return все истории изменений в программе в объекте пагинации
     */
    public Page<HistoryEntity> getAll(Pageable pageable) {
        return historyRepository.findAll(pageable);
    }

    /**
     * Получает всю историю конкретного пользователя
     * @param users - пользователь
     * @param pageable - объект пагинации
     * @return всю сторию пользователя в виде объекта пагинации
     */
    public Page<HistoryEntity> getAllByUser(UsersEntity users, Pageable pageable){
        return historyRepository.findByUser(users, pageable);
    }

    /**
     * Метод для дулаения истории
     * Удаляет историю у которой дата создания была 4 года назад
     */
    public void delete() { //Не используется пока что
        LocalDateTime dateTime = LocalDateTime.now();
        List<HistoryEntity> historyEntities = historyRepository.findAll();
        historyEntities.forEach(historyEntity -> {
            if (historyEntity.getDateAction().isBefore(dateTime.minusYears(4))) historyRepository.delete(historyEntity);
        });
    }
}
