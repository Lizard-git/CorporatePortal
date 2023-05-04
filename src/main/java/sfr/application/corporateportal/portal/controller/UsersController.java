package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    UserRepository userRepository;

    @GetMapping("")
    public String HomePage(Model model) {
        model.addAttribute("AllUsers", userRepository.findAll());
        return "portal/users";
    }
}
