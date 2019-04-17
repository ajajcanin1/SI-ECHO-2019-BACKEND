package com.example.echo.Specification;

import com.example.echo.Entity.Korisnik;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class KorisnikSpecification {
    public static Specification<Korisnik> firstNameAndLastNameMatch(String search){

        return (Specification<Korisnik>) (root, criteriaQuery, criteriaBuilder) -> {
            String match = "%" + search + "%";

            Expression<String> expressionFirstLast = criteriaBuilder.concat(root.get("ime"), " ");
            expressionFirstLast = criteriaBuilder.concat(expressionFirstLast, root.get("prezime"));
            Expression<String> expressionLastFirst = criteriaBuilder.concat(root.get("prezime"), " ");
            expressionLastFirst = criteriaBuilder.concat(expressionLastFirst, root.get("ime"));

            return criteriaBuilder.or(
                    criteriaBuilder.like(expressionFirstLast, match),
                    criteriaBuilder.like(expressionLastFirst, match),
                    criteriaBuilder.like(root.get("email"), match),
                    criteriaBuilder.like(root.get("titula"), match)
            );
        };
    }
}
