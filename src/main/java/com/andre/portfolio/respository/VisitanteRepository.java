package com.andre.portfolio.respository;

import com.andre.portfolio.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
    Optional<Visitante> findByEmail(String email);
    Optional<Visitante> findByComentario(String comentario);
}
