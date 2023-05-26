package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sfr.application.corporateportal.portal.dto.input_entity_dto.AuthDataDTO;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
import sfr.application.corporateportal.portal.entity.DataUsersEntity;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.DataUserRepository;
import sfr.application.corporateportal.portal.repository.UserRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UsersService {
    private final UserRepository userRepository;
    private final DataUserRepository dataUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final HistoryService historyService;

    public UsersEntity getById(Long id) {
        return userRepository.findById(id).get();
    }

    public DataUsersEntity getDataUserById(Long id) {
        return dataUserRepository.findById(id).get();
    }
    /**
     * Получает список всех пользователей из БД
     * @return List<UsersEntity>
     */
    public List<UsersEntity> getAll() {
        return userRepository.findAll();
    }

    /**
     * Метод получает пользователя из базы данных по его логину
     * @param login - Логин пользователя
     * @return UsersEntity / null
     */
    public UsersEntity findByUserLogin(String login) {
        try {
            return userRepository.findByLogin(login).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Метод получает смисок пользователей в одном отделе
     * @param department - отдел
     * @return List<UsersEntity>
     */
    public List<UsersEntity> getAllByDepartment(DepartmentsEntity department) {
        List<DataUsersEntity> dataUsers = dataUserRepository.getAllByDepartments(department);
        return dataUserRepository.getAllByDepartments(department).stream().map(DataUsersEntity::getUser).collect(Collectors.toList());
    }

    /**
     * Метод добавляет нового пользователя в базу данных
     * @param user - добовляемый пользователь
     * @param userAction - то, кто добавляет
     */
    public void add(CreateUserDTO user, UsersEntity userAction) {
        if (!ObjectUtils.isEmpty(user)) {
            try {
                DataUsersEntity newDataUsers = DataUsersEntity.builder()
                        .surname(user.getSurname())
                        .name(user.getName())
                        .middleName(user.getMiddleName())
                        .dateBirthday(user.getDateBirthday())
                        .dateExperience(new Date())
                        .homeEmail(user.getHomeEmail())
                        .departments(user.getDepartment())
                        .address(user.getAddress())
                        .cabinetNumber(user.getCabinetNumber())
                        .ipAddressPC(user.getIpAddressPC())
                        .ipPhone(user.getIpPhone())
                        .phone(user.getPhone())
                        .workEmail(user.getWorkEmail())
                        .position(user.getPosition())
                        .mobilePhone(user.getMobilePhone())
                        .build();
                newDataUsers = dataUserRepository.save(newDataUsers);
                UsersEntity newUser = UsersEntity.builder()
                        .login(user.getLogin())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(Collections.singletonList(user.getRole()))
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .isAccountNonExpired(true)
                        .isEnabled(true)
                        .data(newDataUsers)
                        .build();
                userRepository.save(newUser);
                log.info("Add new user!");
                historyService.addNewHistory("Добавлен новый пользователь: " + user.getLogin(), userAction);
            } catch (Exception e) {
                log.error("Error save user!");
                historyService.addNewHistory("ОШИБКА! При добавлении пользователя: "
                        + user.getLogin() + " произошла ошибка! Обратитесь к администратору.", userAction);
            }
        }
    }

    /**
     * Метод для изменения пользователя
     * @param user - изменяемый пользователь
     * @param userAction - тот, кто меняет
     */
    public void change(UsersEntity user, UsersEntity userAction) {
        UsersEntity userDB = userRepository.getReferenceById(user.getId());
        if (!user.equals(userDB)) {
            try {
                userRepository.save(user);
                log.info("Change user!");
                historyService.addNewHistory("Изменен пользователь: " + user.getLogin(), userAction);
            } catch (Exception e) {
                log.error("Error change user!");
                historyService.addNewHistory("ОШИБКА! При изменении пользователя: " + userDB.getLogin() + " произошла ошибка! Обратитесь к администратору.", userAction);
            }
        }
    }

    /**
     * Метод для изменения данных пользователя
     * @param dataUser - изменяемый пользователь
     * @param userAction - тот, кто меняет
     */
    public void changeDataUser(DataUsersEntity dataUser, UsersEntity userAction) {
        DataUsersEntity dataDB = dataUserRepository.findById(dataUser.getId()).get();
        if (!dataUser.equals(dataDB)) {
            dataUser.setUser(dataDB.getUser());
            dataUser.setDateExperience(dataDB.getDateExperience());
            try {
                dataUserRepository.save(dataUser);
                log.info("Change data user!");
                historyService.addNewHistory("Изменены данные пользователя: " + dataUser.getUser().getLogin(), userAction);
            } catch (Exception e) {
                log.error("Error change data user!");
                historyService.addNewHistory("ОШИБКА! При изменении данных пользователя: " + dataUser.getUser().getLogin() + " произошла ошибка! Обратитесь к администратору.", userAction);
            }
        }
    }

    public void changeDataAuth(AuthDataDTO dataUsers, UsersEntity user) {

    }

    /**
     * Метод помечает пользователя как удаленного. Пользователь более не сможет войти в систему,
     * весь контент пользователя сохраняется
     * @param user - удаляемый пользователь
     * @param userAction - тот, кто удаляет
     */
    public void remove(UsersEntity user, UsersEntity userAction) {
        user.setDeleteDate(new Date());
        userRepository.save(user);
        log.info("User marked as deleted!");
        historyService.addNewHistory("Пользователь: " + user.getLogin() + " помечен как удаленный и более не сможет войти", userAction);
    }

    /**
     * Метод полностью удаляет пользователя из системы. Если используется этот метод, то
     * будет удален не только пользователь, но и все файлы, контент, и чаты этого пользователя
     * @param user - удаляемый пользователь
     * @param userAction - тот, кто удаляет
     */
    public void delete(UsersEntity user, UsersEntity userAction) {
        try {
            userRepository.delete(user);
            log.info("User deleted!");
            historyService.addNewHistory("Пользователь: " + user.getLogin() + " удален и более не сможет войти", userAction);
        } catch (Exception e) {
            log.info("Error ! User not deleted!");
            historyService.addNewHistory("Пользователь: " + user.getLogin() + " не удален, произошла ошибка! Обратитесь к администратору.", userAction);
        }
    }
}
