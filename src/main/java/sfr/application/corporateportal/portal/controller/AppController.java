package sfr.application.corporateportal.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.entity.UsersEntity;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/apps")
public class AppController {
    @GetMapping("")
    public String HomePage(Model model) {
        List<UsersEntity> users = new ArrayList<>();
        model.addAllAttributes(users);
        return "portal/apps";
    }
}
