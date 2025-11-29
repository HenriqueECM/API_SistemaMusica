package com.musica.api.SistemaMusica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String artista;

    @ManyToMany (mappedBy = "musicas")
    private List<Playlist> playlist = new ArrayList<>();

    public Musica(String nome, String artista) {
        this.nome = nome;
        this.artista = artista;
    }
}
