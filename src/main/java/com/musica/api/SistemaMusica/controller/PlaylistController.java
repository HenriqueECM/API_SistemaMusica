package com.musica.api.SistemaMusica.controller;

import com.musica.api.SistemaMusica.dto.PlaylistResponseDto;
import com.musica.api.SistemaMusica.dto.PlaylistRequestDto;
import com.musica.api.SistemaMusica.service.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
@AllArgsConstructor
public class PlaylistController {
    private final PlaylistService service;

    @PostMapping
    public ResponseEntity<PlaylistResponseDto> criar (@RequestBody PlaylistRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PlaylistResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }

    @PostMapping("/{playlistId}/adicionar/{musicaId}")
    public ResponseEntity<PlaylistResponseDto> adicionarMusica (@PathVariable Long playlistId, @PathVariable Long musicaId){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarMusica(playlistId, musicaId));
    }

    @GetMapping
    public ResponseEntity<List<PlaylistResponseDto>> buscarTodos (){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTodos());
    }
}
