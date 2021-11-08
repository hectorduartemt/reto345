/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.repositorios.crud;

import mt.usa.reto3.Reto_3.modelo.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author hldua
 */
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
