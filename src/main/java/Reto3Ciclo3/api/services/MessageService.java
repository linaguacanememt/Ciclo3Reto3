package Reto3Ciclo3.api.services;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.model.Message;
import Reto3Ciclo3.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int messageId){
        return messageRepository.getMessage(messageId);
    }

    public Message save(Message message){
        if (message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> baux=messageRepository.getMessage(message.getIdMessage());
            if (baux.isEmpty()){
                return messageRepository.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if (message.getIdMessage() !=null){
            Optional<Message> auxUpdt=messageRepository.getMessage(message.getIdMessage());
            if(!auxUpdt.isEmpty()){
                if (message.getMessageText()!=null){
                    auxUpdt.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(auxUpdt.get());
                return auxUpdt.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int messageId){
        Boolean aBoolean = getMessage(messageId).map(boat -> {
            messageRepository.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
