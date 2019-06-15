package com.example.echo.Repository;

import com.example.echo.Entity.Kabinet;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import javax.transaction.Transactional;


public interface UnosSaleRepository extends CrudRepository<Kabinet, Integer> {
    @Query("select new map(idKabinet as id, naziv as naziv) from Kabinet k")
    List<Kabinet> sviKabineti ();

    @Modifying
    @Transactional
    @Query("delete from Kabinet k where idKabinet=?1")
    public void obrisiSalu(Integer id);
}