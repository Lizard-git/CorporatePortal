package sfr.application.corporateportal.portal.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.SecurityService;
import sfr.application.corporateportal.portal.service.UsersService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersRestController {
    private final SecurityService securityService;
    private final UsersService usersService;
    @PostMapping(value = {""})
    @ResponseBody
    public List<UsersEntity> GetAllUsers() {
        List<UsersEntity> users = new ArrayList<>();
       // users = usersService.
        return users;
    }

    @PostMapping(value = {"/get/by/department"})
    @ResponseBody
    public List<UsersEntity> GetAllUsersByDepartment() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        List<UsersEntity> users = new ArrayList<>();
        return users;
    }
}
