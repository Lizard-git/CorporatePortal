package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}