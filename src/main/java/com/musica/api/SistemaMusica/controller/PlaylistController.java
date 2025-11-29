package com.musica.api.SistemaMusica.controller;

import com.musica.api.SistemaMusica.dto.PlaylistResponseDto;
import com.musica.api.SistemaMusica.dto.PlaylistRequestDto;
import com.musica.api.SistemaMusica.service.PlayListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlist")
@AllArgsConstructor
public class PlaylistController {
    private final PlayListService service;

    @PostMapping
    public ResponseEntity<PlaylistResponseDto> criar (@RequestBody PlaylistRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PlaylistResponseDto> buscarPorId (@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarPorId(id));
    }
}
