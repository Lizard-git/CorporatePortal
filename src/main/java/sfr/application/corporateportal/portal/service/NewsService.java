package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sfr.application.corporateportal.portal.entity.NewsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.CommentRepository;
import sfr.application.corporateportal.portal.repository.NewsRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;
    private final HistoryService historyService;
    public final CommentRepository commentRepository;
    /**
     * Метод получает все новости (опубликованные, неопубликованные, предложенные)
     * @return
     */
    public List<NewsEntity> getAllNews() {
        return newsRepository.findAll();
    }

    /**
     * Метод добавляет новую новость
     * @param news - добавляемая новость
     * @param actionUser - тот, кто добавляет
     */
    public void create(NewsEntity news, UsersEntity actionUser) {
        if (!ObjectUtils.isEmpty(news)) {
            try {
                newsRepository.save(news);
                log.info("Add new news!");
                historyService.addNewHistory("Добавил новость: " + news.getTitle(), actionUser);
            } catch (Exception e) {
                log.error("ERROR! No new news added!");
                historyService.addNewHistory("Не удалось добавил новость: " + news.getTitle() + " обратитесь к администратору!", actionUser);
            }
        }
    }

    /**
     * Метод редактирует новость
     * @param news - изменяемая новость
     * @param actionUser - тот, кто добавляет
     */
    public void change(NewsEntity news, UsersEntity actionUser) {
        NewsEntity newsDB = newsRepository.getReferenceById(news.getId());
        if (!newsDB.equals(news)) {
            try {
                newsRepository.save(news);
                log.info("Change news!");
                historyService.addNewHistory("Изменил новость: " + news.getTitle(), actionUser);
            } catch (Exception e) {
                log.error("ERROR! No change news!");
                historyService.addNewHistory("Не удалось изменить новость: " + news.getTitle() + " обратитесь к администратору!", actionUser);
            }
        }
    }

    /**
     * Метод удаляет новость из системы
     * @param news - удаляемая новость
     * @param actionUser - тот, кто удаляет
     */
    public void delete(NewsEntity news, UsersEntity actionUser) {
        try {
            newsRepository.delete(news);
            log.info("Deleted news!");
            historyService.addNewHistory("Удалена новость: " + news.getTitle(), actionUser);
        } catch (Exception e) {
            log.error("ERROR! News not deleted!");
            historyService.addNewHistory("Не удалось удалить новость: " + news.getTitle() + " обратитесь к администратору!", actionUser);
        }
    }
}
