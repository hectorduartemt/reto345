/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.repositorio;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Client;
import mt.usa.reto3.Reto_3.repositorios.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hldua
 */
@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository repo;
    

    public List<Client> getAll(){
        return (List<Client>)repo.findAll();       
    }
    
    public Optional <Client> getClient(int id){
        return repo.findById(id);
    }
    
    public Client save(Client client){
        return repo.save(client);
    }
     public void delete(Client client){
        repo.delete(client);
    }


    
}
