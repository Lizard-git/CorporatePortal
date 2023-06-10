package sfr.application.corporateportal.portal.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sfr.application.corporateportal.portal.entity.ChatsEntity;
import sfr.application.corporateportal.portal.entity.MessagesEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.service.ChatService;
import sfr.application.corporateportal.portal.service.UsersService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/messenger")
public class MessengerController {
    private final UsersService usersService;
    private final ChatService chatService;

    //----------------------------------------------Страница с чатом--------------------------------------------------//
    @GetMapping("")
    public String HomePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        model.addAttribute("Chats", chatService.getAllChatForUser(user));
        model.addAttribute("User", user);
        model.addAttribute("Chat", new ChatsEntity());
        model.addAttribute("Messages", new ArrayList<MessagesEntity>());
        return "portal/messenger";
    }
    //---------------------------------------------Страница с чатом конец---------------------------------------------//

    //--------------------------------------------Новый чат с пользователем-------------------------------------------//
    @GetMapping("/new/{id}")
    public String NewChat(@PathVariable Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        if (!chatService.checkCreationChat(user, usersService.getById(id))) {
            ChatsEntity newChat = chatService.newChat(user);
            chatService.addUserInChat(newChat, user, true);
            chatService.addUserInChat(newChat, usersService.getById(id), false);
        } else {
            return "redirect:/messenger/get/chat/" + chatService.getIdChat(user, usersService.getById(id));
        }
        return "redirect:/messenger";
    }
    //-----------------------------------------Новый чат с пользователем конец----------------------------------------//

    //------------------------------------Получение сообщений в конкретном чате---------------------------------------//
    @GetMapping("/get/chat/{id}")
    public String getMessage(@PathVariable Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        ChatsEntity chat = chatService.getChatById(id);
        List<MessagesEntity> messages = chatService.getAllMessageByChat(chat);
        model.addAttribute("Chats", chatService.getAllChatForUser(user));
        model.addAttribute("User", user);
        model.addAttribute("Chat", chat);
        model.addAttribute("Messages", messages);
        return "portal/messenger";
    }
    //----------------------------------Получение сообщений в конкретном чате конец-----------------------------------//

    //----------------------------------------------Отправка сообщеия-------------------------------------------------//
    @PostMapping("/new/message/{id}")
    public String NewMessage(@PathVariable Long id, @RequestParam("message") String message) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UsersEntity user = usersService.findByUserLogin(auth.getName());
        MessagesEntity newMessage = MessagesEntity.builder()
                .message(message)
                .chat(chatService.getChatById(id))
                .user(user)
                .creationDate(new Date())
                .build();
        chatService.newMessage(newMessage);
        return "redirect:/messenger/get/chat/" + id;
    }
    //------------------------------------------Отправка сообщеия конец-----------------------------------------------//
}
