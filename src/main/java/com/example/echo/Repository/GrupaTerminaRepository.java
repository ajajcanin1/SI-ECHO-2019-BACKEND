package com.example.echo.Repository;
import com.example.echo.Entity.GrupaTermina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface GrupaTerminaRepository extends CrudRepository<GrupaTermina, Integer> {
}