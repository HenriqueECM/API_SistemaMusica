package com.musica.api.SistemaMusica.repository;

import com.musica.api.SistemaMusica.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    boolean existsByNome(String nome);
}
