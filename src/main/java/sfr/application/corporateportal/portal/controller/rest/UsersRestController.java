package sfr.application.corporateportal.portal.controller.rest;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.SecurityService;
import sfr.application.corporateportal.portal.service.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UsersRestController {
    private final SecurityService securityService;
    private final UsersService usersService;
    @RequestMapping(value = {"/get/all"}, method = RequestMethod.POST)
    @ResponseBody
    public List<UsersEntity> GetAllUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        List<UsersEntity> users = usersService.getAll();
        users = users.stream().filter(usersEntity -> !usersEntity.getId().equals(user.getId())).collect(Collectors.toList());
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
