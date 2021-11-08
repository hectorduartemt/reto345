/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.servicios;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Category;
import mt.usa.reto3.Reto_3.repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List <Category>getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category>getCategory(int idCategory){
        return categoryRepository.getCategory(idCategory);
    }
    
    public Category save(Category category){
        if (category.getId()== null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> evt=categoryRepository.getCategory(category.getId());
            if (evt.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> g=categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
            }
            if(category.getName()!=null){
                g.get().setName(category.getName());
            }
            return categoryRepository.save(g.get());
        }
        return category;
    }
    
    public boolean deleteCategory(int idCategory){
        Boolean d = getCategory(idCategory).map(category->{
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}
