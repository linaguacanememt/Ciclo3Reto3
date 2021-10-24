package Reto3Ciclo3.api.repository;

import Reto3Ciclo3.api.model.Client;
import Reto3Ciclo3.api.repository.Crud.ClientCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepo clientCrudRepo;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepo.findAll();
    }

    public Optional<Client> getClient(int Clientid) {
        return clientCrudRepo.findById(Clientid);
    }

    public Client save(Client client){
        return clientCrudRepo.save(client);
    }

    public void delete(Client client){
        clientCrudRepo.delete(client);
    }
}
