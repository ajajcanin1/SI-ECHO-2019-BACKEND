package com.example.echo.Repository;

import com.example.echo.Entity.Korisnik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface KorisnikRepository extends PagingAndSortingRepository<Korisnik, Integer> {
    Page<Korisnik> findAll (Specification<Korisnik> spec, Pageable pageable);
}
