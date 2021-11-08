/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.servicios;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Ortopedic;
import mt.usa.reto3.Reto_3.repositorio.OrtopedicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class OrtopedicService {
    
    @Autowired
     private OrtopedicRepository ortopedicRepository; /*metodos crud, lo que nos traemos desde nuestro repositorio*/
    
    public List<Ortopedic> getAll(){
        return ortopedicRepository.getAll();
        
    }
    
    public Optional<Ortopedic> getOrtopedic(int idOrtopedic){
        return ortopedicRepository.getOrtopedic(idOrtopedic);
                       
    }
     
    public Ortopedic save(Ortopedic ortopedic){
        if (ortopedic.getId()== null){
            return ortopedicRepository.save(ortopedic);
        }else{
            Optional<Ortopedic> evt=ortopedicRepository.getOrtopedic(ortopedic.getId());
            if (evt.isEmpty()){
                return ortopedicRepository.save(ortopedic);
            }else{
                return ortopedic;
            }
        }
    }
    
    public Ortopedic update(Ortopedic ortopedic){
        if(ortopedic.getId()!=null){
            Optional<Ortopedic> g=ortopedicRepository.getOrtopedic(ortopedic.getId());
            if(!g.isEmpty()){
                if(ortopedic.getName()!=null){
                    g.get().setName(ortopedic.getName());
                }
            }
            if(ortopedic.getBrand()!=null){
                g.get().setBrand(ortopedic.getBrand());
            }
            if(ortopedic.getYear()!=null){
                g.get().setDescription(ortopedic.getDescription());
            }
            if(ortopedic.getCategory()!=null){
                g.get().setCategory(ortopedic.getCategory());
            }
            return ortopedicRepository.save(g.get());
        }else{
           return ortopedic; 
        }
        
    }
    
    public boolean deleteOrtopedic(int id){
        Boolean d = getOrtopedic(id).map(category->{
            ortopedicRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}
