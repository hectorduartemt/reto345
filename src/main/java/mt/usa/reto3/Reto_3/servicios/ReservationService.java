/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.servicios;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Reservation;
import mt.usa.reto3.Reto_3.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hldua
 */
/**
 * service
 */
@Service
public class ReservationService {
    
    /**
     * @Autowired
     */
    @Autowired
    /**
    * variable privada reservationRepository
    */
    private ReservationRepository reservationRepository;
    
    /*
    Metodo para obtener los datos
    */
    
    public List<Reservation>getAll(){
        return reservationRepository.getAll();
    }
    /*
    Metodo Optional
    */
    public Optional<Reservation>getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }
    /*
    Metodo para guardar los datos
    */
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()== null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> evt=reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /*
    Metodo para actualizar los datos
    */
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> g=reservationRepository.getReservation(reservation.getIdReservation());
            if(!g.isEmpty()){
                if(reservation.getStartDate()!=null){
                    g.get().setStartDate(reservation.getStartDate());
                }
            if(reservation.getDevolutionDate()!=null){
                g.get().setDevolutionDate(reservation.getDevolutionDate());
            }
            if(reservation.getStatus()!=null){
                g.get().setStatus(reservation.getStatus());
            }
            return reservationRepository.save(g.get());
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    /*
    Metodo para eliminar los datos
    */
    public boolean deleteReservation(int idReservation){
        Boolean d = getReservation(idReservation).map(reservation->{
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
    
    
    
}
