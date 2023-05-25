package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
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
    @GetMapping("")
    public String HomePage(Model model) {
        // Данные авторизированного пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("User", user);
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

        // Роли
        model.addAttribute("AllRoles", securityService.getAllRoles());
        // -------------------------------------

        // Объект для стоздания нового пользователя
        model.addAttribute("NewUser", new CreateUserDTO());
        // -------------------------------------

        // По дифолту ошибки отключаем
        model.addAttribute("Error", true);
        // -------------------------------------
        return "portal/settings";
    }
}
