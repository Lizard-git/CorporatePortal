package sfr.application.corporateportal.portal.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sfr.application.corporateportal.portal.dto.input_entity_dto.CreateUserDTO;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.SecurityService;
import sfr.application.corporateportal.portal.service.UsersService;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {
    private final SecurityService securityService;
    private final UsersService usersService;

    @GetMapping("")
    public String UsersPage(Model model) {
        model.addAttribute("AllUsers", usersService.getAll());
        return "portal/users";
    }

    @GetMapping("/get/{id}")
    public String UserPage(Model model, @PathVariable Long id) {
        UsersEntity user =  usersService.getById(id);

        model.addAttribute("User", user);
        return "portal/profile";
    }

    @PostMapping("/add")
    public String AddUser(@ModelAttribute("NewUser") @Valid CreateUserDTO userDTO,
                          BindingResult bindingResult,
                          Model model) {
        if (!bindingResult.hasErrors()) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UsersEntity user = usersService.findByUserLogin(auth.getName());


        } else {
            model.addAttribute("Error", true);
            return "redirect:/settings";
        }

        return "portal/users";
    }
}
