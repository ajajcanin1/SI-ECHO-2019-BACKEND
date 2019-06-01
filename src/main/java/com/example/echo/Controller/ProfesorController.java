package com.example.echo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.echo.Entity.Korisnik;
import com.example.echo.Repository.ProfesorRepository;
@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class ProfesorController {
  @Autowired
  private ProfesorRepository profesorRepository;

  public ProfesorController(ProfesorRepository profesorRepository){
      this.profesorRepository=profesorRepository;
  }
 
  @GetMapping(value="/korisnici")
  public List<Korisnik> getAllUsers() {
    return (List<Korisnik>)profesorRepository.findAll();
  }
  @GetMapping("/korisnici/{id}")
  public ResponseEntity<Korisnik> getUsersById(@PathVariable(value = "id") Integer userId)
      throws Exception {
    Korisnik kor =
        profesorRepository
            .findById(userId)
            .orElseThrow(() -> new Exception("Korisnik nije pronadjen :: " + userId));
    return ResponseEntity.ok().body(kor);
  }
}