package sfr.application.corporateportal.portal.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sfr.application.corporateportal.portal.entity.NewsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.NewsService;
import sfr.application.corporateportal.portal.service.UsersService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Controller
@RequestMapping("/news")
public class NewsController {

    @Value("${upload.path}")
    private String uploadPath;

    private NewsService newsService;
    private UsersService usersService;
    @Autowired
    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("")
    public String HomePage(Model model) {
        UsersEntity user = null;
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            user = usersService.findByUserLogin(auth.getName());
        } catch (Exception e) {

        }
        model.addAttribute("User", user);
        //model.addAttribute("News", newsService.getAllNews());
        return "portal/news";
    }

    @PostMapping("/add")
    public String AddNews(
            @ModelAttribute("NewNews") @Valid NewsEntity news,
            BindingResult bindingResult,
            @RequestParam("avatar") MultipartFile file,
            Model model
    ) {
        if (!bindingResult.hasErrors()) {
            String fileName = null;
            // Загрузка файла для получения пути
            if (!file.isEmpty()){
                try{
                    byte[] bytes = file.getBytes();
                    String filePath = uploadPath + "/news";
                    File newFile = new File(filePath);
                    if (!newFile.exists()) {
                        newFile.mkdirs();
                    }
                    fileName = UUID.randomUUID() + "." + file.getOriginalFilename().split("\\.")[1];
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile + "/" + fileName));
                    stream.write(bytes);
                    stream.close();
                    //historyService.newHistory("Загрузка файла импорта прошла успешно");
                }catch (Exception e){
                    //log.error("Error import: " + e.getMessage());
                    //historyService.newHistory("Ошибка загрузки файла импорта");
                }
            }

            news.setUrlImg("/files/img/news/" + fileName);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            UsersEntity user = usersService.findByUserLogin(auth.getName());
            newsService.create(news, user);
        } else {

        }
        return "redirect:/news";
    }


}
