package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.CommentsEntity;

public interface CommentRepository extends JpaRepository<CommentsEntity, Long> {
}