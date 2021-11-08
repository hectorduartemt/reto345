/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.servicios;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Message;
import mt.usa.reto3.Reto_3.repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messagesRepository;
    
    public List<Message>getAll(){
        return messagesRepository.getAll();
    }
    
    public Optional<Message>getMessage(int idMessage){
        return messagesRepository.getMessage(idMessage);
    }
    
    public Message save(Message messages){
        if (messages.getIdMessage()== null){
            return messagesRepository.save(messages);
        }else{
            Optional<Message> evt=messagesRepository.getMessage(messages.getIdMessage());
            if (evt.isEmpty()){
                return messagesRepository.save(messages);
            }else{
                return messages;
            }
        }
    }
    
    public Message update(Message messages){
        if(messages.getIdMessage()!=null){
            Optional<Message> e=messagesRepository.getMessage(messages.getIdMessage());
            if(!e.isEmpty()){
                if(messages.getMessageText()!=null){
                    e.get().setMessageText(messages.getMessageText());
                }
            return messagesRepository.save(e.get());
            }else {
                return messages;
            }
        }else {
            return messages;
        }
    }
    
    public boolean deleteMessage(int idMessage){
        Boolean a = getMessage(idMessage).map(messages->{
            messagesRepository.delete(messages);
            return true;
        }).orElse(false);
        return a;
    }
}
