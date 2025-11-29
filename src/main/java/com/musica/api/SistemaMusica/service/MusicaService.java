package com.musica.api.SistemaMusica.service;

import com.musica.api.SistemaMusica.dto.MusicaMapper;
import com.musica.api.SistemaMusica.dto.MusicaRequestDto;
import com.musica.api.SistemaMusica.dto.MusicaResponseDto;
import com.musica.api.SistemaMusica.model.Musica;
import com.musica.api.SistemaMusica.repository.MusicaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MusicaService {
    private final MusicaRepository repository;
    private final MusicaMapper mapper;
    public MusicaResponseDto criar(MusicaRequestDto request) {
        if(repository.existsByNome(request)){
            throw new RuntimeException("Esta música já existe.");
        }

        Musica musica = mapper.paraEntidade(request);

        return mapper.toResponse(repository.save(musica));
    }
}
