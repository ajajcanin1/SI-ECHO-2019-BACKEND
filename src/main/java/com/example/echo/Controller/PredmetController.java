package com.example.echo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.echo.Entity.Predmet;
import com.example.echo.Repository.PredmetRepository;
@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class PredmetController {
  @Autowired
  private PredmetRepository predmetRepository;

  public PredmetController(PredmetRepository predmetRepository){
      this.predmetRepository=predmetRepository;
  }
 
  @GetMapping(value="/predmeti")
  public List<Predmet> getAllSubjects() {
    return (List<Predmet>)predmetRepository.findAll();
  }
  @GetMapping("/predmeti/{id}")
  public ResponseEntity<Predmet> getSubjectsById(@PathVariable(value = "id") Integer idPredmet)
      throws Exception {
    Predmet predmet =
        predmetRepository
            .findById(idPredmet)
            .orElseThrow(() -> new Exception("Predmet nije pronadjen :: " + idPredmet));
    return ResponseEntity.ok().body(predmet);
  }
}