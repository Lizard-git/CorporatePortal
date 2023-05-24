package sfr.application.corporateportal.portal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sfr.application.corporateportal.portal.entity.DataUsersEntity;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;

import java.util.List;

public interface DataUserRepository extends JpaRepository<DataUsersEntity, Long> {

    List<DataUsersEntity> getAllByDepartments(DepartmentsEntity departments);
    Page<DataUsersEntity> getAllByDepartments(DepartmentsEntity departments, Pageable pageable);


}