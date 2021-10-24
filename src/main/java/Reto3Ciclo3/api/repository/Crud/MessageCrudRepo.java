package Reto3Ciclo3.api.repository.Crud;

import Reto3Ciclo3.api.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepo extends CrudRepository<Message, Integer> {
}
