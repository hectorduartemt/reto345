/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.repositorio;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Reservation;
import mt.usa.reto3.Reto_3.repositorios.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hldua
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository repo;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) repo.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return repo.findById(id);
    }
    public Reservation save(Reservation reservation){
        return repo.save(reservation);
    }
     public void delete(Reservation reservation){
        repo.delete(reservation);
    }
     
     
}
