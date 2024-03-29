package cyberminds.backend.service.chat;

import cyberminds.backend.dto.request.ChatMessageDTO;
import cyberminds.backend.exception.AppException;
import cyberminds.backend.model.chat.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    ChatMessage sendMessage(ChatMessageDTO message) throws AppException;
    List<ChatMessage> getChatMessages(String senderId, String receiverId);
    List<ChatMessage> getChatMessagesForUser(String userId);
    void deleteUser(String userId) throws AppException;
}
