package com.musica.api.SistemaMusica.dto;

import com.musica.api.SistemaMusica.model.Musica;
import org.springframework.stereotype.Component;

@Component
public class MusicaMapper {
    public Musica paraEntidade (MusicaRequestDto request){
        return new Musica(
                request.nome(),
                request.artista()
        );
    }
    public MusicaResponseDto toResponse (Musica musica){
        return new MusicaResponseDto(
                musica.getId(),
                musica.getNome(),
                musica.getArtista()
        );
    }
}
