package com.example.echo.Repository;


import com.example.echo.Entity.Kabinet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UnosSaleRepository extends CrudRepository<Kabinet, Integer> {
   
}