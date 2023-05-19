package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.SecurityService;
import sfr.application.corporateportal.portal.service.UsersService;

@Controller
@AllArgsConstructor
public class HomeController {
    private final SecurityService securityService;
    private final UsersService usersService;
    @GetMapping(path = {"/home", "/"})
    public String HomePage(Model model) {
        //Получение авторизированного пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = securityService.findByUserLogin(auth.getName());
        model.addAttribute("User", user);
        DepartmentsEntity dep = user.getData().getDepartments();
        //Получение всех пользователей из отдела авторизированного пользователя
        model.addAttribute("Users", usersService.getAllByDepartment(dep, PageRequest.of(0, 10)));

        //Получение всех доступных авторизированному пользователю приложений


        return "portal/dashboard";
    }
}
