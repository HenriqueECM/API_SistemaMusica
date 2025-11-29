package com.musica.api.SistemaMusica.controller;

import com.musica.api.SistemaMusica.dto.MusicaRequestDto;
import com.musica.api.SistemaMusica.dto.MusicaResponseDto;
import com.musica.api.SistemaMusica.service.MusicaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/musica")
public class MusicaController {
    private final MusicaService service;

    @PostMapping
    public ResponseEntity<MusicaResponseDto> criar (@RequestBody MusicaRequestDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }
}
