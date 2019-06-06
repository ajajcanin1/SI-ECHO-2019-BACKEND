package com.example.echo.Controller;
import com.example.echo.Entity.GrupaTermina;
import com.example.echo.Repository.GrupaTerminaRepository;
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
public class GrupaTerminaController {
    public GrupaTerminaController(GrupaTerminaRepository grupaTerminaRepository) {
        this.grupaTerminaRepository = grupaTerminaRepository;
    }
    @Autowired
    GrupaTerminaRepository grupaTerminaRepository;
    
    @GetMapping(value = "/grupetermina")
    public List<GrupaTermina> getgrupeTermina() {
        return (List<GrupaTermina>) grupaTerminaRepository.findAll();
    }
    @GetMapping("/grupetermina/{id}")
    public ResponseEntity<GrupaTermina> getGrupaTerminaById(@PathVariable(value = "id") Integer idGrupaTermina)
        throws Exception {
      GrupaTermina grupatermina =
          grupaTerminaRepository
              .findById(idGrupaTermina)
              .orElseThrow(() -> new Exception("Grupa termina nije nadjena :: " + idGrupaTermina));
      return ResponseEntity.ok().body(grupatermina);
    }
}
