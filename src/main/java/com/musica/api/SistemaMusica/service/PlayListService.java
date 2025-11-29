package com.musica.api.SistemaMusica.service;

import com.musica.api.SistemaMusica.dto.PlaylistResponseDto;
import com.musica.api.SistemaMusica.dto.PlaylistMapper;
import com.musica.api.SistemaMusica.dto.PlaylistRequestDto;
import com.musica.api.SistemaMusica.model.Playlist;
import com.musica.api.SistemaMusica.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayListService {
    private final PlaylistRepository repository;
    private final PlaylistMapper mapper;
    public PlaylistResponseDto criar(PlaylistRequestDto request) {
        if (repository.existsByNome(request.nome())){
            throw new RuntimeException("Esta playlist já existe.");
        }

        Playlist playlist = mapper.toEntity(request);

        return mapper.toResponse(repository.save(playlist));
    }

    public PlaylistResponseDto buscarPorId (Long id){
        Playlist playlist = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("A playlist não encontrado."));

        return mapper.toResponse(playlist);
    }
}
