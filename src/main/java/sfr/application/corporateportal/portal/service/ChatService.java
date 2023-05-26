package sfr.application.corporateportal.portal.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sfr.application.corporateportal.portal.repository.ChatRepository;
import sfr.application.corporateportal.portal.repository.ChatUserRepository;

@Service
@Slf4j
@AllArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatUserRepository chatUserRepository;
    private final HistoryService historyService;
}
