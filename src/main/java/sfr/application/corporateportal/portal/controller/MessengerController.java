package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sfr.application.corporateportal.portal.entity.ChatsEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.ChatService;
import sfr.application.corporateportal.portal.service.UsersService;

@Controller
@AllArgsConstructor
@RequestMapping("/messenger")
public class MessengerController {
    private final UsersService usersService;
    private final ChatService chatService;

    @GetMapping("")
    public String HomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("Chats", chatService.getAllChatForUser(user));
        return "portal/messenger";
    }

    @GetMapping("/new/{id}")
    public String NewChat(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        if (!chatService.checkCreationChat(user, usersService.getById(id))) {
            ChatsEntity newChat = chatService.newChat(user);
            chatService.addUserInChat(newChat, user, true);
            chatService.addUserInChat(newChat, usersService.getById(id), false);
        }

        return "redirect:/messenger";
    }
}
