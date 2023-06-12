package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sfr.application.corporateportal.portal.entity.DepartmentsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.UsersService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class HomeController {
    private final UsersService usersService;
    @GetMapping(path = {"/home", "/"})
    public String HomePage(Model model) {
        //Получение авторизированного пользователя
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("User", user);

        //Получение всех пользователей из отдела авторизированного пользователя кроме себя
        DepartmentsEntity department = user.getDepartments();
        List<UsersEntity> users = usersService.getAllByDepartment(department);
        users = users.stream().filter(usersEntity -> !usersEntity.getId().equals(user.getId())).collect(Collectors.toList());
        model.addAttribute("Users", new PageImpl<>(users, PageRequest.of(0, 10), users.size()) );

        //Получение всех доступных авторизированному пользователю приложений

        return "portal/dashboard";
    }
}
