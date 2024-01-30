package com.pokemonapi.pokemonapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonapi.pokemonapi.api.model.Pokemon;
import com.pokemonapi.pokemonapi.service.PokemonService;

@RestController
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //PostMapping för att spara en pokemon i databas
    @PostMapping("/catch-pokemon")
    public Pokemon catchPokemon(@RequestBody Pokemon pokemon) {
        System.out.println("Du fångade " + pokemon);
        return pokemonService.catchPokemon(pokemon);
    }

    //DeleteMapping för att ta bort en pokemon från databasen
    @DeleteMapping("/release-pokemon")
    public ResponseEntity<String> releasePokemon(@RequestParam Integer pokemonId) {
        System.out.println("Du släppte pokemonen med id " + pokemonId);
        pokemonService.releasePokemon(pokemonId);

        return ResponseEntity.ok("Du släppte pokemon med id " + pokemonId);
    }

}

