package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.SecurityService;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private final SecurityService securityService;

    @GetMapping("")
    public String HomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = securityService.findByUserLogin(auth.getName());

        model.addAttribute("User", user);
        return "portal/dashboard";
    }
}
