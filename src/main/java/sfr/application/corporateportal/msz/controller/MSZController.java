package sfr.application.corporateportal.msz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/msz")
public class MSZController {
    @GetMapping("")
    public String GetTestAppPage() {
        return "msz/index";
    }
}
