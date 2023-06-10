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
import sfr.application.corporateportal.portal.entity.*;
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
    private final ApplicationService applicationService;

    //-----------------------------------------------Настройка профиля-----------------------------------------------//
    @GetMapping(path = {"", "/profile"})
    public String ProfilePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("User", usersService.convertUserInDataUser(user));
        model.addAttribute("AllAddress", addressService.getAllAddress());
        model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
        model.addAttribute("AllPosition", positionService.getAllPosition());
        return "portal/settings-page/settings-profile";
    }
    //--------------------------------------------Настройка профиля конец--------------------------------------------//

    //---------------------------------------------Настройка безопасности--------------------------------------------//
    @GetMapping(path = {"/security"})
    public String SecurityPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("User", user);
        model.addAttribute("AuthData", new AuthDataDTO());
        return "portal/settings-page/settings-security";
    }
    //------------------------------------------Настройка безопасности конец-----------------------------------------//

    //-------------------------------------Настройка для сотрудника безопасности-------------------------------------//
    @GetMapping(path = {"/user/security"})
    public String UserSecurityPage(Model model) {
        model.addAttribute("AllAddress", addressService.getAllAddress());
        model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
        model.addAttribute("AllPosition", positionService.getAllPosition());
        model.addAttribute("AllRoles", securityService.getAllRoles());
        model.addAttribute("AllAuthority", securityService.getAllAuthority());
        model.addAttribute("NewUser", new CreateUserDTO());
        return "portal/settings-page/settings-user-security";
    }
    //----------------------------------Настройка для сотрудника безопасности конец----------------------------------//

    //-------------------------------------Настройка для сотрудника безопасности-------------------------------------//
    @GetMapping(path = {"/user/administrator"})
    public String UserAdminPage(Model model) {
        model.addAttribute("AllRoles", securityService.getAllRoles());
        model.addAttribute("AllAuthority", securityService.getAllAuthority());
        model.addAttribute("NewRole", new RolesEntity());
        model.addAttribute("NewAuthority", new AuthorityEntity());
        model.addAttribute("NewNews", new NewsEntity());
        model.addAttribute("NewApp", new ApplicationsEntity());
        model.addAttribute("AllStatus", applicationService.getAllStatusApp());
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
