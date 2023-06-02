package sfr.application.corporateportal.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    Optional<UsersEntity> findByLogin(String login);

    UsersEntity getByLogin(String login);

    List<UsersEntity> getAllByDepartments(DepartmentsEntity departments);
    Optional<UsersEntity> findById(Long id);

    List<UsersEntity> findAllByDeleteDateNotNull();
}
