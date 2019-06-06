package com.example.echo.Controller;

import com.example.echo.Entity.ZeljeniTermin;
import com.example.echo.Repository.ZeljeniTerminRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class ZeljeniTerminKontroler {
    //private ZeljeniTerminRepository zeljeniTerminRepository;

    public ZeljeniTerminKontroler(ZeljeniTerminRepository zeljeniTerminRepository) {
        this.zeljeniTerminRepository = zeljeniTerminRepository;
    }
    @Autowired
    ZeljeniTerminRepository zeljeniTerminRepository;
    @PostMapping("/unesiTermine")
    public void unesiTermine(@RequestBody ZeljeniTermin data) {
        zeljeniTerminRepository.save(data);
    }


    //Moj dio
    @GetMapping (value="/getZeljeniTerminByKorisnikId")
    public List<ZeljeniTermin> getSome() {
        return (List<ZeljeniTermin>) zeljeniTerminRepository.findZeljeniTerminByPredavacId(null);
    }


    //Svi termini koji se nalaze u bazi
   @GetMapping(value="/all")
    public List<ZeljeniTermin> getAll() {
        return (List<ZeljeniTermin>) zeljeniTerminRepository.findAll();
   }

   @GetMapping(value="/terminpodanu/{dan}")
   public List<ZeljeniTermin> getTerminByDan(@PathVariable(value = "dan") String dan){
      List<ZeljeniTermin> svi = (List<ZeljeniTermin>) zeljeniTerminRepository.findAll(); 
       List<ZeljeniTermin> potrebni = new ArrayList<ZeljeniTermin>();
       for(ZeljeniTermin element : svi){
           if(element.getDanUSedmici().equals(dan))potrebni.add(element);
       }
   return potrebni;
   }
   @GetMapping(value="/terminpokabinetu/{kabinet}")
   public List<ZeljeniTermin> getTerminByKabinet(@PathVariable(value = "kabinet") Integer kabinet){
      List<ZeljeniTermin> svi = (List<ZeljeniTermin>) zeljeniTerminRepository.findAll(); 
       List<ZeljeniTermin> potrebni = new ArrayList<ZeljeniTermin>();
       for(ZeljeniTermin element : svi){
           if(element.getIdKabinet() == kabinet)potrebni.add(element);
       }
   return potrebni;
   }
   @GetMapping(value="/terminpovremenu/{vrijeme}")
   public List<ZeljeniTermin> getTerminByVrijeme(@PathVariable(value = "vrijeme") String vrijeme){
      List<ZeljeniTermin> svi = (List<ZeljeniTermin>) zeljeniTerminRepository.findAll(); 
       List<ZeljeniTermin> potrebni = new ArrayList<ZeljeniTermin>();
       for(ZeljeniTermin element : svi){
           if(element.getVrijeme().equals(vrijeme))potrebni.add(element);
       }
   return potrebni;
   }
}
