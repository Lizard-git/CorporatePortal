package sfr.application.corporateportal.statistic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/statistic")
public class TestController {
    @GetMapping("")
    public String GetTestAppPage() {
        return "statistic/index";
    }
}
