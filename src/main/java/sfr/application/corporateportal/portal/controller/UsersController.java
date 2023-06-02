package sfr.application.corporateportal.portal.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import sfr.application.corporateportal.portal.dto.input_entity_dto.AuthDataDTO;
import sfr.application.corporateportal.portal.dto.input_entity_dto.ChangeUserDto;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
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
        //model.addAttribute("AllUsers", usersService.getAll());
        return "portal/users";
    }

    @GetMapping(path = {"/get/{id}"})
    public String ProfileUserPage(@PathVariable Long id, Model model) {
        model.addAttribute("User", usersService.getById(id));
        model.addAttribute("AllRoles", securityService.getAllRoles());
        model.addAttribute("AllAddress", addressService.getAllAddress());
        model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
        model.addAttribute("AllPosition", positionService.getAllPosition());
        return "portal/profile";
    }

    @PostMapping("/change/auth/data")
    public String ChangeAuthDataUser(
            @ModelAttribute("AuthData") @Valid AuthDataDTO dataUsers,
            BindingResult bindingResult,
            Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());

        if (ObjectUtils.isEmpty(dataUsers.getOldPassword())) {
            bindingResult.addError(
                    new FieldError("AuthData", "oldPassword", "Вы не ввели старый пароль")
            );
        }

        if (!dataUsers.getNewPassword().equals(dataUsers.getNewCheckPassword())) {
            bindingResult.addError(
                    new FieldError("AuthData", "newPassword", "Пароли не совпадают")
            );
            bindingResult.addError(
                    new FieldError("AuthData", "newCheckPassword", "Пароли не совпадают")
            );
        }

        if (!bindingResult.hasErrors()) {
            usersService.changeDataAuth(dataUsers, user);
        } else {
            model.addAttribute("User", user);
            return "portal/settings-page/settings-security";
        }
        return "redirect:/settings/security";
    }

    @PostMapping("/change/data")
    public String ChangeDataUser(
            @ModelAttribute("User") @Valid ChangeUserDto dataUsers,
            BindingResult bindingResult,
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());

        if (!bindingResult.hasErrors()) {
            usersService.changeDataUser(dataUsers, user);
        } else {
            model.addAttribute("AllAddress", addressService.getAllAddress());
            model.addAttribute("AllDepartments", departmentsService.getAllDepartment());
            model.addAttribute("AllPosition", positionService.getAllPosition());
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

    @GetMapping("/delete/{id}")
    public String DeleteUser(@PathVariable Long id) {
        UsersEntity deleteUser = usersService.getById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        usersService.remove(deleteUser, user);
        return "redirect:/users/get/" + deleteUser.getId();
    }

    @GetMapping("/block/{id}")
    public String BlockUser(@PathVariable Long id) {
        UsersEntity blockUser = usersService.getById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        usersService.block(blockUser, user);
        return "redirect:/users/get/" + blockUser.getId();
    }
}

