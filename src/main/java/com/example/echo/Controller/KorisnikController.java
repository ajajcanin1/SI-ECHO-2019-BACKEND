package com.example.echo.Controller;

import com.example.echo.Entity.Korisnik;
import com.example.echo.Repository.KorisnikRepository;
import com.example.echo.Specification.KorisnikSpecification;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
@RequestMapping(value="api/si2019/echo")
public class KorisnikController {
    private KorisnikRepository korisnikRepository;

    public KorisnikController(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @ApiOperation(value = "Get a list of professors and assistents")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message="Successfully retrieved list"),
            @ApiResponse(code = 400, message="The request was invalid or cannot be otherwise served."),
    })
    @RequestMapping(value = "/getTeachingStaff",  method = RequestMethod.GET)
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
