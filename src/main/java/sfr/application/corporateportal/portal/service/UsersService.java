package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sfr.application.corporateportal.portal.dto.input_entity_dto.AuthDataDTO;
import sfr.application.corporateportal.portal.dto.input_entity_dto.ChangeUserDto;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.UserRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Slf4j
public class UsersService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final HistoryService historyService;

    public UsersEntity getById(Long id) {
        return userRepository.findById(id).get();
    }

    public ChangeUserDto convertUserInDataUser(UsersEntity users) {
        return ChangeUserDto.builder()
                .address(users.getAddress())
                .homeEmail(users.getHomeEmail())
                .ipAddressPC(users.getIpAddressPC())
                .ipPhone(users.getIpPhone())
                .middleName(users.getMiddleName())
                .name(users.getName())
                .phone(users.getPhone())
                .mobilePhone(users.getMobilePhone())
                .departments(users.getDepartments())
                .position(users.getPosition())
                .surname(users.getSurname())
                .workEmail(users.getWorkEmail())
                .cabinetNumber(users.getCabinetNumber())
                .dateBirthday(users.getDateBirthday())
                .build();
    }

    public UsersEntity convertDataUserInUser(ChangeUserDto userDto, UsersEntity user) {
        user.setAddress(userDto.getAddress());
        user.setHomeEmail(userDto.getHomeEmail());
        user.setIpAddressPC(userDto.getIpAddressPC());
        user.setIpPhone(userDto.getIpPhone());
        user.setMiddleName(userDto.getMiddleName());
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        user.setDepartments(userDto.getDepartments());
        user.setPosition(userDto.getPosition());
        user.setSurname(userDto.getSurname());
        user.setWorkEmail(userDto.getWorkEmail());
        user.setCabinetNumber(userDto.getCabinetNumber());
        user.setDateBirthday(userDto.getDateBirthday());
        user.setMobilePhone(userDto.getMobilePhone());
        return user;
    }




//    public DataUsersEntity getDataUserById(Long id) {
//        return dataUserRepository.findById(id).get();
//    }
    /**
     * Получает список всех не удаленных пользователей из БД
     * @return List<UsersEntity>
     */
    public List<UsersEntity>getAllIsNotDeleted() {
        return userRepository.findAllByDeleteDateNotNull();
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
        return userRepository.getAllByDepartments(department);
    }

    /**
     * Метод добавляет нового пользователя в базу данных
     * @param user - добовляемый пользователь
     * @param userAction - то, кто добавляет
     */
    public void add(CreateUserDTO user, UsersEntity userAction) {
        try {
        //Проверка на Login
            if (!ObjectUtils.isEmpty(userRepository.getByLogin(user.getLogin()))) {
                throw new NullPointerException();
            }
            if (!ObjectUtils.isEmpty(user)) {
                UsersEntity newUser = UsersEntity.builder()
                        .creationDate(new Date())
                        .lastModifiedDate(new Date())
                        .login(user.getLogin())
                        .password(passwordEncoder.encode(user.getPassword()))
                        .roles(Collections.singletonList(user.getRole()))
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .isAccountNonExpired(true)
                        .isEnabled(true)
                        .surname(user.getSurname())
                        .name(user.getName())
                        .middleName(user.getMiddleName())
                        .dateBirthday(user.getDateBirthday())
                        .homeEmail(user.getHomeEmail())
                        .departments(user.getDepartment())
                        .address(user.getAddress())
                        .cabinetNumber(user.getCabinetNumber())
                        .ipAddressPC(user.getIpAddressPC())
                        .ipPhone(user.getIpPhone().toString())
                        .phone(user.getPhone())
                        .workEmail(user.getWorkEmail())
                        .position(user.getPosition())
                        .mobilePhone(user.getMobilePhone())
                        .build();
                newUser = userRepository.save(newUser);
                log.info("Add new user!");
                historyService.addNewHistory("Добавлен новый пользователь: " + user.getLogin(), userAction);
            }
        } catch (NullPointerException e) {
            log.error("Error save user! (Login) ");
            historyService.addNewHistory("ОШИБКА! При добавлении пользователя: "
                    + user.getLogin() + " произошла ошибка! Пользователь с таким логином уже существует!", userAction);
        } catch (Exception e) {
            log.error("Error save user!");
            historyService.addNewHistory("ОШИБКА! При добавлении пользователя: "
                    + user.getLogin() + " произошла ошибка! Обратитесь к администратору.", userAction);
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
     * Метод для изменения личных данных пользователя
     * @param dataUser - Измененные данные
     * @param user - тот, кто меняет
     */
    public void changeDataUser(ChangeUserDto dataUser, UsersEntity user) {
        if (!convertUserInDataUser(user).equals(dataUser)) {
            try {
                userRepository.save(convertDataUserInUser(dataUser, user));
                log.info("Change data user!");
                historyService.addNewHistory("Изменены данные пользователя: " + user.getLogin(), user);
            } catch (Exception e) {
                log.error("Error change data user!");
                historyService.addNewHistory("ОШИБКА! При изменении данных пользователя: " + user.getLogin() + " произошла ошибка! Обратитесь к администратору.", user);
            }
        }
    }

    /**
     * Метод меняет пароль зарегистрированного пользователя
     * @param dataUsers -
     * @param user
     */
    public void changeDataAuth(AuthDataDTO dataUsers, UsersEntity user) {
        if (passwordEncoder.matches(dataUsers.getOldPassword(), user.getPassword())) {
            try {
                user.setPassword(passwordEncoder.encode(dataUsers.getNewPassword()));
                userRepository.save(user);
                log.info("Change password user!");
                historyService.addNewHistory("Изменен пароль пользователя: " + user.getLogin(), user);
            } catch (Exception e) {
                log.error("Error change password user!");
                historyService.addNewHistory("ОШИБКА! При изменении пароля пользователя: " + user.getLogin() + " произошла ошибка! Обратитесь к администратору.", user);
            }
        }
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

    /**
     *
     * @param blockUser
     * @param user
     */
    public void block(UsersEntity blockUser, UsersEntity user) {
        try {
            blockUser.setIsAccountNonLocked(false);
            userRepository.save(blockUser);
            historyService.addNewHistory("Пользователь: " + user.getLogin() + " заблокирован и более не сможет войти", user);
        } catch (Exception e) {
            log.info("Error ! User not blocked!");
            historyService.addNewHistory("Пользователь: " + user.getLogin() + " не заблокирован, произошла ошибка! Обратитесь к администратору.", user);
        }
    }
}
