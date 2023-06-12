package sfr.application.corporateportal.portal.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.entity.ApplicationsEntity;
import sfr.application.corporateportal.portal.service.ApplicationService;

@Controller
@AllArgsConstructor
@RequestMapping("/apps")
public class AppController {
    private final ApplicationService applicationService;
    @GetMapping("")
    public String HomePage(Model model) {
        model.addAttribute("AllApp", applicationService.getAll());
        return "portal/apps";
    }

    @PostMapping("/add")
    public String AddApp(@ModelAttribute("NewApp") @Valid ApplicationsEntity application) {
        applicationService.add(application);
        return "redirect:/apps";
    }
}
