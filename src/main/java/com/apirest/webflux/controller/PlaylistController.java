package com.apirest.webflux.controller;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.services.PlaylistService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/v1/playlist")
@AllArgsConstructor
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping(value = "/")
    public ResponseEntity<Flux<Playlist>> getPlaylist(){ return ResponseEntity.ok().body(playlistService.findAll()); }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<Playlist>> getPlaylistById(@PathVariable(name = "id") String id){
        return ResponseEntity.ok().body(playlistService.findById(id));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Mono<Playlist>> postPlaylist(@RequestBody Playlist playlist){
        return ResponseEntity.ok().body(playlistService.save(playlist));
    }
}
