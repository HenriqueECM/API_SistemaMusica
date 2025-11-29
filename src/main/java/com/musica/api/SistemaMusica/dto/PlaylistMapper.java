package com.musica.api.SistemaMusica.dto;

import com.musica.api.SistemaMusica.model.Playlist;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class PlaylistMapper {
    public Playlist toEntity (PlaylistRequestDto request){
        return new Playlist(
                request.nome()
        );
    }

    public PlaylistResponseDto toResponse (Playlist playlist){
        return new PlaylistResponseDto(
                playlist.getId(),
                playlist.getNome(),
                playlist.getMusicas()
                        .stream()
                        .map(m -> new MusicaResponseDto(m.getId(), m.getNome(), m.getArtista()))
                        .toList()
        );
    }
}
