package sfr.application.corporateportal.portal.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sfr.application.corporateportal.portal.dto.input_entity_dto.AuthDataDTO;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
import sfr.application.corporateportal.portal.entity.DataUsersEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.*;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final SecurityService securityService;
    private final UsersService usersService;
    private final DepartmentsService departmentsService;
    private final PositionService positionService;
    private final AddressService addressService;

    @GetMapping(path = {"/get/all"})
    public String AllUsersPage(Model model) {
        model.addAttribute("AllUsers", usersService.getAll());
        return "portal/users";
    }

    @GetMapping(path = {"/get/{id}"})
    public String ProfileUserPage(@PathVariable Long id, Model model) {
        model.addAttribute("User", usersService.getById(id));
        model.addAttribute("DataUser", usersService.getById(id).getData());
        model.addAttribute("AllRoles", securityService.getAllRoles());

        // Адреса
        model.addAttribute("AllAddress", addressService.getAllAddress());
        // -------------------------------------

        // Отделы
        model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
        // -------------------------------------

        // Позиции
        model.addAttribute("AllPosition", positionService.getAllPosition());
        // -------------------------------------
        return "portal/profile";
    }

    @PostMapping("/change/{id}")
    public String ChangeAuthDataUser(
            @PathVariable(name = "id") Long id,
            @ModelAttribute("AuthData") @Valid AuthDataDTO dataUsers,
            BindingResult bindingResult,
            Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());

        if (!dataUsers.getNewPassword().equals(dataUsers.getNewCheckPassword())) {
            bindingResult.addError(new FieldError("AuthData", "newPassword", "Пароли не совпадают"));
            bindingResult.addError(new FieldError("AuthData", "newCheckPassword", "Пароли не совпадают"));
        }

        if (!bindingResult.hasErrors()) {
            usersService.changeDataAuth(dataUsers, user);
        } else {
            model.addAttribute("User", user);
            return "portal/settings-page/settings-security";
        }
        return "redirect:/settings";
    }

    @PostMapping("/change/data/{id}")
    public String ChangeDataUser(
            @PathVariable(name = "id") Long id,
            @ModelAttribute("DataUser") @Valid DataUsersEntity dataUsers,
            BindingResult bindingResult,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        dataUsers.setId(id);
        if (!bindingResult.hasErrors()) {
            usersService.changeDataUser(dataUsers, user);
        } else {
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
        return "redirect:/settings";
    }

    @PostMapping(path = {"/save"})
    public String SaveNewUser(
            @ModelAttribute("NewUser") @Valid CreateUserDTO userDTO,
            BindingResult bindingResult,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        if (!bindingResult.hasErrors()) {
            usersService.add(userDTO, user);
        } else {
            model.addAttribute("AllRoles", securityService.getAllRoles());
            // Адреса
            model.addAttribute("AllAddress", addressService.getAllAddress());
            // -------------------------------------

            // Отделы
            model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
            // -------------------------------------

            // Позиции
            model.addAttribute("AllPosition", positionService.getAllPosition());
            // -------------------------------------
            return "portal/settings-page/settings-user-security";
        }
        return "redirect:/settings";
    }
}

