package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.dto.input_entity_dto.SearchUsersDTO;
import sfr.application.corporateportal.portal.entity.*;
import sfr.application.corporateportal.portal.repository.DataUserRepository;
import sfr.application.corporateportal.portal.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
    private final DataUserRepository dataUserRepository;
    public Page<DataUsersEntity> getAllByDepartment(DepartmentsEntity department, Pageable pageable) {
        return dataUserRepository.getAllByDepartments(department, pageable);
    }

    public void delete(UsersEntity user, UsersEntity userAction) {

    }

    public void add(UsersEntity user, UsersEntity userAction) {

    }
    public void change(UsersEntity user, UsersEntity userAction) {

    }
    public UsersEntity get(UsersEntity user, UsersEntity userAction) {
        return new UsersEntity();
    }

    public List<UsersEntity> getAll(UsersEntity user, UsersEntity userAction) {
        return new ArrayList<>();
    }

    public List<UsersEntity> search(SearchUsersDTO searchUsersDTO) {
        return new ArrayList<>();
    }

    public List<UsersEntity> getByAddress(AddressEntity address) {
        return new ArrayList<>();
    }

    public List<UsersEntity> getByDepartment(DepartmentsEntity department) {
        return new ArrayList<>();
    }

    public List<UsersEntity> getByFullName(String keyword) {
        return new ArrayList<>();
    }

    public List<UsersEntity> getByPhone(String keyword) {
        return new ArrayList<>();
    }

    public List<UsersEntity> getByPosition(PositionEntity position) {
        return new ArrayList<>();
    }
}
