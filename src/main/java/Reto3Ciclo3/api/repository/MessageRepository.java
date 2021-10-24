package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Message;
import Reto3Ciclo3.api.repository.Crud.MessageCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepo messageCrudRepo;

    public List<Message> getAll(){
        return (List<Message>)messageCrudRepo.findAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageCrudRepo.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepo.save(message);
    }

    public void delete(Message message){
        messageCrudRepo.delete(message);
    }
}
