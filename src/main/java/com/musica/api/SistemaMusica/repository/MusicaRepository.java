package com.musica.api.SistemaMusica.repository;

import com.musica.api.SistemaMusica.dto.MusicaRequestDto;
import com.musica.api.SistemaMusica.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long> {
    boolean existsByNome(String nome);
}
