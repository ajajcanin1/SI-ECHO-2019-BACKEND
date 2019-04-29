package com.example.echo.Controller;

import com.example.echo.Entity.ZeljeniTermin;
import com.example.echo.Repository.ZeljeniTerminRepository;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value="/si2019/echo")
public class ZeljeniTerminKontroler {
    private ZeljeniTerminRepository zeljeniTerminRepository;

    public ZeljeniTerminKontroler(ZeljeniTerminRepository zeljeniTerminRepository) {
        this.zeljeniTerminRepository = zeljeniTerminRepository;
    }

    @PostMapping("/unesiTermine")
    public void unesiTermine(@RequestBody ZeljeniTermin data) {
        zeljeniTerminRepository.save(data);
    }
}
