package com.musica.api.SistemaMusica.service;

import com.musica.api.SistemaMusica.dto.PlaylistResponseDto;
import com.musica.api.SistemaMusica.dto.PlaylistMapper;
import com.musica.api.SistemaMusica.dto.PlaylistRequestDto;
import com.musica.api.SistemaMusica.model.Musica;
import com.musica.api.SistemaMusica.model.Playlist;
import com.musica.api.SistemaMusica.repository.MusicaRepository;
import com.musica.api.SistemaMusica.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaylistService {
    private final PlaylistRepository repository;
    private final PlaylistMapper mapper;
    private final MusicaRepository musicaRepository;

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

    public PlaylistResponseDto adicionarMusica (Long playlistId, Long musicaId){
        Playlist playlist = repository.findById(playlistId)
                .orElseThrow(()-> new RuntimeException("A playlist não encontrado."));

        Musica musica = musicaRepository.findById(musicaId)
                .orElseThrow(()-> new RuntimeException("A musica não encontrado."));

        if (playlist.getMusicas().contains(musica)){
            throw new RuntimeException("Já existe esta música na playlist.");
        }

        playlist.getMusicas().add(musica);

        Playlist atualizado = repository.save(playlist);

        return mapper.toResponse(repository.save(atualizado));
    }

    public List<PlaylistResponseDto> buscarTodos (){
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
