package sfr.application.corporateportal.portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.DataUsersEntity;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;

public interface DataUserRepository extends JpaRepository<DataUsersEntity, Long> {
    Page<DataUsersEntity> getAllByDepartments(DepartmentsEntity departments, Pageable pageable);
}