package com.andre.portfolio.respository;

import com.andre.portfolio.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    String findByComentario(String comentario);

}
