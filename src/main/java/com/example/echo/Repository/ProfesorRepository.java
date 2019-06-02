package com.example.echo.Repository;
import com.example.echo.Entity.Korisnik;
import org.springframework.data.repository.CrudRepository;


public interface ProfesorRepository extends CrudRepository<Korisnik, Integer> {}