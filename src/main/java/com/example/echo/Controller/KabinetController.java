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
    @GetMapping("/kabineti/{id}")
    public ResponseEntity<Kabinet> getKabinetById(@PathVariable(value = "id") Integer idKabineta)
        throws Exception {
      Kabinet kabinet =
          kabinetRepository
              .findById(idKabineta)
              .orElseThrow(() -> new Exception("Kabinet nije pronadjen :: " + idKabineta));
      return ResponseEntity.ok().body(kabinet);
    }
}
