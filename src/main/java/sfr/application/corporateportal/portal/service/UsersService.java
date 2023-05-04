package sfr.application.corporateportal.portal.service;

import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.dto.input_entity_dto.SearchUsersDTO;
import sfr.application.corporateportal.portal.entity.AddressEntity;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.PositionEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
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
