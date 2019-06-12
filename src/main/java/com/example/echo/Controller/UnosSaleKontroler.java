package com.example.echo.Controller;

import com.example.echo.Entity.Kabinet;
import com.example.echo.Repository.UnosSaleRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.IOException;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class UnosSaleKontroler {
 
    public UnosSaleKontroler(UnosSaleRepository unosSaleRepository) {
        this.unosSaleRepository = unosSaleRepository;
    }
    @Autowired
    UnosSaleRepository unosSaleRepository;
    @PostMapping("/unesiSalu")
    public void unesiSale(@RequestBody Kabinet data) {
        unosSaleRepository.save(data);
    }

    @GetMapping(value="/sveSale")
    public List<Kabinet> getAll() {
        return (List<Kabinet>) unosSaleRepository.sviKabineti();
    }

   @PostMapping("/obrisiSalu")
   public void obrisiSalu(@RequestBody String id) {
       ObjectMapper objectMapper = new ObjectMapper();
       try{
           JsonNode jsonNode = objectMapper.readTree(id);
           String id_kabineta = jsonNode.get("id").asText();
           
           Integer result = Integer.parseInt(id_kabineta);
           System.out.println("Obrisi" + result);
           unosSaleRepository.obrisiSalu(result);
       }

       catch(IOException io) {
           System.out.println("Nije nista uradjeno..");
       }
       
   }
}