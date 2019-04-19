package com.example.echo.Repository;

import com.example.echo.Dto.KorisnikDto;
import com.example.echo.Entity.Korisnik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface KorisnikRepository extends PagingAndSortingRepository<Korisnik, Integer> {
    Page<Korisnik> findAll (Specification<Korisnik> spec, Pageable pageable);

    @Query("select new com.example.echo.Dto.KorisnikDto(k.id, k.ime, k.prezime, k.email, k.titula) " +
            "from Korisnik k " +
            "inner join k.uloga u " +
            "where (u.naziv in ('Profesor', 'Asistent')) " +
            "and (concat(k.ime, ' ', k.prezime) like ?1 " +
            "or k.email like ?1 " +
            "or k.titula like ?1) ")
    Page<KorisnikDto> findAllBySearch (String search, Pageable pageable);
}