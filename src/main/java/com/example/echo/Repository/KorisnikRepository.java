package com.example.echo.Repository;

import com.example.echo.DTO.KorisnikDTO;
import com.example.echo.Entity.Korisnik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.criteria.*;


public interface KorisnikRepository extends PagingAndSortingRepository<Korisnik, Integer> {
    Page<Korisnik> findAll (Specification<Korisnik> spec, Pageable pageable);

    @Query("select new com.example.echo.DTO.KorisnikDTO(k.id, k.ime, k.prezime, k.email, k.titula) " +
            "from Korisnik k " +
            "inner join k.uloga u " +
            "where (u.naziv in ('Profesor', 'Asistent')) " +
            "and (concat(k.ime, ' ', k.prezime) like ?1 " +
            "or k.email like ?1 " +
            "or k.titula like ?1) ")
    Page<KorisnikDTO> findAllBySearch (String search, Pageable pageable);
}