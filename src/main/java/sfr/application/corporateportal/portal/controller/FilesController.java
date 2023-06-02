package sfr.application.corporateportal.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sfr.application.corporateportal.portal.entity.FilesEntity;
import sfr.application.corporateportal.portal.entity.FilesStatusEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.FilesService;
import sfr.application.corporateportal.portal.service.UsersService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Controller
@RequestMapping("/resources")
public class FilesController {
    @Value("${upload.path}")
    private String uploadPath;
    private UsersService usersService;
    private FilesService filesService;
    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setFilesService(FilesService filesService) { this.filesService = filesService; }

    @GetMapping("/get/all/files")
    public String HomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("AllFiles", filesService.getAll());
        model.addAttribute("NewFile", new FilesEntity());
        model.addAttribute("AllStatus", filesService.getAllStatus());
        //model.addAttribute("News", newsService.getAllNews());
        return "portal/all-files";
    }

    @PostMapping("/add")
    public String SavaFile(@RequestParam("status")FilesStatusEntity status,
                           @RequestParam("file") MultipartFile file) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        String fileName = null;
        // Загрузка файла для получения пути
        if (!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                String filePath = uploadPath + "/users";
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

        FilesEntity newFile = FilesEntity.builder()
                .tagName(file.getOriginalFilename().split("\\.")[0])
                .status(status)
                .urlImg("/files/user/" + fileName)
                .userAdd(user)
                .build();
        filesService.save(newFile);
        return "redirect:/resources/get/all/files";
    }
}
