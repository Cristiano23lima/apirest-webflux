package com.apirest.webflux;

import java.util.UUID;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.repository.PlaylistRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@AllArgsConstructor
// @Component
public class DummyData implements CommandLineRunner{
    private final PlaylistRepository repository;

	@Override
	public void run(String... args) throws Exception {
        repository.deleteAll()
            .thenMany(
                Flux.just("Api rest com webflux", "Estrutura de dados com java", "Java para iniciantes", "TDD em java")
                .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
                .flatMap(repository::save)
            ).subscribe(System.out::println);
	}



}
