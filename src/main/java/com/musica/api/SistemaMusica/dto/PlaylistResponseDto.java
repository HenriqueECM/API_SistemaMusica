package com.musica.api.SistemaMusica.dto;

import java.util.List;

public record PlaylistResponseDto(
        Long id,
        String nome,
        List<MusicaResponseDto> musicas
){
}
