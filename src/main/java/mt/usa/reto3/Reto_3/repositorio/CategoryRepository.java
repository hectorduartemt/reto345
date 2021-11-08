/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.repositorio;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Category;
import mt.usa.reto3.Reto_3.repositorios.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hldua
 */
@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository repo;
    
    public List<Category> getAll(){
        return (List<Category>) repo.findAll();
    }
    
    public Optional<Category> getCategory(int id) {
        return repo.findById(id);
    }
    
    public Category save(Category category){
        return repo.save(category);
    }
    
    public void delete(Category category){
        repo.delete(category);
    }
}
