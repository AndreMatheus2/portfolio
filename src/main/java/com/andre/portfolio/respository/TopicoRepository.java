package com.andre.portfolio.respository;

import com.andre.portfolio.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
     List<Topico> findByVisitanteNome(String visitanteNome);
}
