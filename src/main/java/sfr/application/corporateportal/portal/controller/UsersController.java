package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.repository.UserRepository;

@Controller
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    UserRepository userRepository;

    @GetMapping("")
    public String UsersPage(Model model) {
        model.addAttribute("AllUsers", userRepository.findAll());
        return "portal/users";
    }

    @GetMapping("/get/{id}")
    public String UserPage(Model model, @PathVariable Long id) {
        model.addAttribute("User", userRepository.getReferenceById(id));
        return "portal/profile";
    }

    @PostMapping("/add")
    public String AddUser(Model model) {
        model.addAttribute("AllUsers", userRepository.findAll());
        return "portal/users";
    }
}
