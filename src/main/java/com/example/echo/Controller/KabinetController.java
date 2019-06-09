package com.example.echo.Controller;
import com.example.echo.Entity.Kabinet;
import com.example.echo.Repository.KabinetRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class KabinetController {
    public KabinetController(KabinetRepository kabinetRepository) {
        this.kabinetRepository = kabinetRepository;
    }
    @Autowired
    KabinetRepository kabinetRepository;
    
    @GetMapping(value = "/kabineti")
    public List<Kabinet> getKabineti() {
        return (List<Kabinet>) kabinetRepository.findAll();
    }
    //kabineti po idu
    @GetMapping("/kabineti/{id}")
    public ResponseEntity<Kabinet> getKabinetById(@PathVariable(value = "id") Integer idKabineta)
        throws Exception {
      Kabinet kabinet =
          kabinetRepository
              .findById(idKabineta)
              .orElseThrow(() -> new Exception("Kabinet nije pronadjen :: " + idKabineta));
      return ResponseEntity.ok().body(kabinet);
    }
    //kabineti po namjeni, dohvaca sve s namjenom koja je poslana
    @GetMapping("/kabinetinamjena/{namjena}")
    public List<Kabinet> getKabinetByNamjena(@PathVariable(value = "namjena") Boolean namjena){
       List<Kabinet> svi = new ArrayList<Kabinet>();
       svi.addAll((List<Kabinet>) kabinetRepository.findAll()); 
        List<Kabinet> potrebni = new ArrayList<Kabinet>();
        for(Kabinet element : svi){
            if(element.getNamjena() == namjena)potrebni.add(element);
        }
    return potrebni;
    }
    //kabineti prema kapacitetu, dohvaca sve sa vecim kapacitetom
    @GetMapping("/kabinetikapacitet/{kapacitet}")
    public List<Kabinet> getKabinetByKapacitet(@PathVariable(value = "kapacitet") Integer kapacitet){
       List<Kabinet> svi = new ArrayList<Kabinet>();
       svi.addAll((List<Kabinet>) kabinetRepository.findAll()); 
        List<Kabinet> potrebni = new ArrayList<Kabinet>();
        for(Kabinet element : svi){
            if(element.getKapacitet() >= kapacitet)potrebni.add(element);
        }
    return potrebni;
    }
}
