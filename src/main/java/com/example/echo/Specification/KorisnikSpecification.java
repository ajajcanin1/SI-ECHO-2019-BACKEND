package com.example.echo.Specification;

import com.example.echo.Entity.Korisnik;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class KorisnikSpecification {
    public static Specification<Korisnik> firstNameAndLastNameMatch(String s){

        return (Specification<Korisnik>) (root, criteriaQuery, criteriaBuilder) -> {
            String search = "%" + s + "%";

            Expression<String> expressionFirstLast = criteriaBuilder.concat(root.get("ime"), " ");
            expressionFirstLast = criteriaBuilder.concat(expressionFirstLast, root.get("prezime"));
            Expression<String> expressionLastFirst = criteriaBuilder.concat(root.get("prezime"), " ");
            expressionLastFirst = criteriaBuilder.concat(expressionLastFirst, root.get("ime"));

            Predicate match = criteriaBuilder.or(
                    criteriaBuilder.like(expressionFirstLast, search),
                    criteriaBuilder.like(expressionLastFirst, search),
                    criteriaBuilder.like(root.get("email"), search),
                    criteriaBuilder.like(root.get("titula"), search)
            );

            Predicate title = criteriaBuilder.or(
                    criteriaBuilder.like(root.get("uloga").get("naziv"), "Profesor"),
                    criteriaBuilder.like(root.get("uloga").get("naziv"), "Asistent")
            );
            return criteriaBuilder.and(match, title);
        };
    }
}
