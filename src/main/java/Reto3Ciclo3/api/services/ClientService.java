package Reto3Ciclo3.api.services;

import Reto3Ciclo3.api.model.Boat;
import Reto3Ciclo3.api.model.Client;
import Reto3Ciclo3.api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }

    public Client save(Client client){
        if (client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> baux=clientRepository.getClient(client.getIdClient());
            if (baux.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if (client.getIdClient() !=null){
            Optional<Client> auxUpdt=clientRepository.getClient(client.getIdClient());
            if(!auxUpdt.isEmpty()){
                if (client.getName()!=null){
                    auxUpdt.get().setName(client.getName());
                }
                if (client.getAge()!=null){
                    auxUpdt.get().setAge(client.getAge());
                }
                if (client.getPassword()!=null){
                    auxUpdt.get().setPassword(client.getPassword());
                }
                clientRepository.save(auxUpdt.get());
                return auxUpdt.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(boat -> {
            clientRepository.delete(boat);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
