package com.example.echo.Repository;


import com.example.echo.Entity.ZeljeniTermin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ZeljeniTerminRepository extends CrudRepository<ZeljeniTermin, Integer> {
    //Hardkodirani id, jer nemamo podatke u prijavljenom profesoru
    @Query("select zt from ZeljeniTermin zt where zt.predavac.id=null")
    List<ZeljeniTermin> findZeljeniTerminByPredavacId (Integer predavacId);
}
