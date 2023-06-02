package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.entity.ChatUsersEntity;
import sfr.application.corporateportal.portal.entity.ChatsEntity;
import sfr.application.corporateportal.portal.entity.MessagesEntity;
import sfr.application.corporateportal.portal.entity.UsersEntity;
import sfr.application.corporateportal.portal.repository.ChatRepository;
import sfr.application.corporateportal.portal.repository.ChatUserRepository;
import sfr.application.corporateportal.portal.repository.MessageRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatUserRepository chatUserRepository;
    private final HistoryService historyService;
    private final MessageRepository messageRepository;

    public ChatsEntity getChatById(Long id) {
        return chatRepository.findById(id).get();
    }

    public List<ChatsEntity> getAllChatForUser(UsersEntity user) {
        List<ChatUsersEntity> chatsAndUser = chatUserRepository.getAllByUser(user);
        return chatsAndUser.stream().map(ChatUsersEntity::getChat).collect(Collectors.toList());
    }

    public ChatsEntity newChat(String name, UsersEntity user) {
        ChatsEntity newChat = ChatsEntity.builder()
                .creationDate(new Date())
                .name(name)
                .user(user)
                .build();
        return chatRepository.save(newChat);
    }
    public ChatsEntity newChat(UsersEntity user) {
        ChatsEntity newChat = ChatsEntity.builder()
                .creationDate(new Date())
                .name("Default")
                .user(user)
                .build();
        return chatRepository.save(newChat);
    }

    public void addUserInChat(ChatsEntity chat, UsersEntity user, boolean isAdmin) {
        ChatUsersEntity newChatUser = ChatUsersEntity.builder()
                .chat(chat)
                .dateAddInChat(new Date())
                .isAdmin(isAdmin)
                .user(user)
                .build();
        chatUserRepository.save(newChatUser);
    }

    public boolean checkCreationChat(UsersEntity userOne, UsersEntity userTwo) {
        List<ChatsEntity> chats = getAllChatForUser(userOne);
        //chats.get(1).usersInChat.get(1).getUser().getId().equals(userTwo.getId())
        boolean result = false;
        List<ChatsEntity> filterChatsForTwoUser = chats.stream().filter(chat -> chat.getUsersInChat().size() == 2).toList();
        for (var chat: filterChatsForTwoUser) {
            for (var user: chat.getUsersInChat()) {
                if (user.getUser().getId().equals(userTwo.getId())) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public List<MessagesEntity> getAllMessageByChat(ChatsEntity chat) {
        return messageRepository.getAllByChat(chat);
    }

    public void newMessage(MessagesEntity messages) {
        messageRepository.save(messages);
    }

    public Long getIdChat(UsersEntity userOne, UsersEntity userTwo) {
        List<ChatsEntity> chats = getAllChatForUser(userOne);
        List<ChatsEntity> filterChatsForTwoUser = chats.stream().filter(chat -> chat.getUsersInChat().size() == 2).toList();
        for (var chat: filterChatsForTwoUser) {
            if (chat.getUsersInChat().get(0).getUser().getId() == userOne.getId()) {
                if (chat.getUsersInChat().get(1).getUser().getId() == userTwo.getId()) {
                    return chat.getId();
                }
            }
            if (chat.getUsersInChat().get(0).getUser().getId() == userTwo.getId()) {
                if (chat.getUsersInChat().get(1).getUser().getId() == userOne.getId()) {
                    return chat.getId();
                }
            }
        }
        return null;
    }
}
