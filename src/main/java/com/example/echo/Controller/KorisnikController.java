package com.example.echo.Controller;

import com.example.echo.Entity.Korisnik;
import com.example.echo.Repository.KorisnikRepository;
import com.example.echo.Specification.KorisnikSpecification;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class KorisnikController {
    private KorisnikRepository korisnikRepository;

    public KorisnikController(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @RequestMapping("/getTeachingStaff")
    public ResponseEntity getTeachingStaff(@RequestBody String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(data);

        String search = json.get("search").asText();
        Page<Korisnik> res = korisnikRepository
                .findAll( KorisnikSpecification.firstNameAndLastNameMatch(search),
                        PageRequest.of(json.get("page").asInt(), json.get("size").asInt()));


        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
