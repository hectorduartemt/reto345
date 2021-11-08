/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.repositorio;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Message;
import mt.usa.reto3.Reto_3.repositorios.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hldua
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository repo;
    public List<Message> getAll(){
        return (List<Message>) repo.findAll();
    }
    public Optional<Message> getMessage(int id){
        return repo.findById(id);
    }

    public Message save(Message messages){
        return repo.save(messages);
    }
    
    public void delete(Message messages){
        repo.delete(messages);
    }
}
