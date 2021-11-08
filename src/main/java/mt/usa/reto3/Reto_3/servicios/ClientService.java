/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.servicios;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Client;
import mt.usa.reto3.Reto_3.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client>getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client>getClient(int idClient){
        return clientRepository.getClient(idClient);
    }
    
    public Client save(Client client){
        if (client.getIdClient()== null){
            return clientRepository.save(client);
        }else{
            Optional<Client> evt=clientRepository.getClient(client.getIdClient());
            if (evt.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e=clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
            }
            if(client.getAge()!=null){
                e.get().setAge(client.getAge());
            }
            return clientRepository.save(e.get());
        }
        return client;
    }
    
    public boolean deleteClient(int idClient){
        Boolean a = getClient(idClient).map(client->{
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return a;
    }
}
