package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.dto.input_entity_dto.AuthDataDTO;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
import sfr.application.corporateportal.portal.entity.AuthorityEntity;
import sfr.application.corporateportal.portal.entity.RolesEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.*;

@Controller
@AllArgsConstructor
@RequestMapping("/settings")
public class SettingsController {
    private final SecurityService securityService;
    private final DepartmentsService departmentsService;
    private final PositionService positionService;
    private final AddressService addressService;
    private final UsersService usersService;

    //-----------------------------------------------Настройка профиля-----------------------------------------------//
    @GetMapping(path = {"", "/profile"})
    public String ProfilePage(Model model) {
        // Данные авторизированного пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("DataUser", user.getData());
        // -------------------------------------

        // Адреса
        model.addAttribute("AllAddress", addressService.getAllAddress());
        // -------------------------------------

        // Отделы
        model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
        // -------------------------------------

        // Позиции
        model.addAttribute("AllPosition", positionService.getAllPosition());
        // -------------------------------------
        return "portal/settings-page/settings-profile";
    }
    //--------------------------------------------Настройка профиля конец--------------------------------------------//

    //---------------------------------------------Настройка безопасности--------------------------------------------//
    @GetMapping(path = {"/security"})
    public String SecurityPage(Model model) {
        // Данные авторизированного пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("User", user);
        // -------------------------------------

        // Новые данные авторизации
        model.addAttribute("AuthData", new AuthDataDTO());
        // -------------------------------------
        return "portal/settings-page/settings-security";
    }
    //------------------------------------------Настройка безопасности конец-----------------------------------------//

    //-------------------------------------Настройка для сотрудника безопасности-------------------------------------//
    @GetMapping(path = {"/user/security"})
    public String UserSecurityPage(Model model) {
        // Адреса
        model.addAttribute("AllAddress", addressService.getAllAddress());
        // -------------------------------------

        // Отделы
        model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
        // -------------------------------------

        // Позиции
        model.addAttribute("AllPosition", positionService.getAllPosition());
        // -------------------------------------

        // Роли
        model.addAttribute("AllRoles", securityService.getAllRoles());
        // -------------------------------------

        // Права доступа
        model.addAttribute("AllAuthority", securityService.getAllAuthority());
        // -------------------------------------

        // Объект для стоздания нового пользователя
        model.addAttribute("NewUser", new CreateUserDTO());
        // -------------------------------------
        return "portal/settings-page/settings-user-security";
    }
    //----------------------------------Настройка для сотрудника безопасности конец----------------------------------//

    //-------------------------------------Настройка для сотрудника безопасности-------------------------------------//
    @GetMapping(path = {"/user/administrator"})
    public String UserAdminPage(Model model) {
        // Роли
        model.addAttribute("AllRoles", securityService.getAllRoles());
        // -------------------------------------

        // Права доступа
        model.addAttribute("AllAuthority", securityService.getAllAuthority());
        // -------------------------------------

        // Новая роль
        model.addAttribute("NewRole", new RolesEntity());
        // -------------------------------------

        // Права доступа
        model.addAttribute("NewAuthority", new AuthorityEntity());
        // -------------------------------------



        return "portal/settings-page/settings-administrator";
    }
    //----------------------------------Настройка для сотрудника безопасности конец----------------------------------//

    //--------------------------------------------Дополнительные настройки-------------------------------------------//
    @GetMapping(path = {"/additionally"})
    public String AdditionallyPage(Model model) {
        return "portal/settings-page/settings-additionally";
    }
    //-----------------------------------------Дополнительные настройки конец----------------------------------------//
}
