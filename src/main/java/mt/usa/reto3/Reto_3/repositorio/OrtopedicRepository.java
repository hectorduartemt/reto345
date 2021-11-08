/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.repositorio;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Ortopedic;
import mt.usa.reto3.Reto_3.repositorios.crud.OrtopedicCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hldua
 */
@Repository
public class OrtopedicRepository {
    
    @Autowired
    private OrtopedicCrudRepository repo;
    
    public List<Ortopedic> getAll(){
        return (List<Ortopedic>) repo.findAll();
    }
    
    public Optional<Ortopedic> getOrtopedic(int id) {
        return repo.findById(id);
    }
    
    public Ortopedic save(Ortopedic ortopedic){
        return repo.save(ortopedic);
    }
    
    public void delete(Ortopedic ortopedic){
        repo.delete(ortopedic);
    }
}
