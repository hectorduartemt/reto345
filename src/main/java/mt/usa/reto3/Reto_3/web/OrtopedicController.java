/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.usa.reto3.Reto_3.web;

import java.util.List;
import java.util.Optional;
import mt.usa.reto3.Reto_3.modelo.Ortopedic;
import mt.usa.reto3.Reto_3.servicios.OrtopedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hldua
 */
@RestController
@RequestMapping("/api/Ortopedic")
public class OrtopedicController {
    
    @GetMapping("/holamundo")
    public String saludar(){
        return "Hola Mundo Tutorias";
    }
    
    @Autowired
    private OrtopedicService ortopedicService;
    
    @GetMapping("/holaMundo")
    public String saludo(){
        return "Hola Mundo Tutoria";
    }
    
    @GetMapping("/all")
    public List<Ortopedic> getOrtopedic(){
        return ortopedicService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Ortopedic> getOrtopedic(@PathVariable("id") int idOrtopedic){
        return ortopedicService.getOrtopedic(idOrtopedic);
    }
        
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic save(@RequestBody Ortopedic ortopedic){
        return ortopedicService.save(ortopedic);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortopedic update(@RequestBody Ortopedic ortopedic){
        return ortopedicService.update(ortopedic);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int idOrtopedic){
        return ortopedicService.deleteOrtopedic(idOrtopedic);
    }
}
