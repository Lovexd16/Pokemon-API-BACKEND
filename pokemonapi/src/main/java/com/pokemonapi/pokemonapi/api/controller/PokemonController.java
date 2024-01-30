package com.pokemonapi.pokemonapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonapi.pokemonapi.api.model.Pokemon;
import com.pokemonapi.pokemonapi.service.PokemonService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //PostMapping för att spara en pokemon i databas
    @PostMapping("/catch-pokemon")
    public ResponseEntity<String> catchPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.catchPokemon(pokemon);
        System.out.println("Du fångade " + pokemon);
        return ResponseEntity.ok("Du fångade " + pokemon.getPokemonName() + "!");
    }

    //DeleteMapping för att ta bort en pokemon från databasen
    @DeleteMapping("/release-pokemon")
    public ResponseEntity<String> releasePokemon(@RequestBody Pokemon pokemon) {
        int pokemonId = pokemon.getPokemonId();
        pokemonService.releasePokemon(pokemonId);
        System.out.println("Du släppte pokemonen med id " + pokemonId);
        return ResponseEntity.ok("Du släppte pokemon med id " + pokemonId);
    }
    

    @GetMapping("/look-for-pokemon")
    public ResponseEntity<Boolean> lookForPokemon(@RequestParam int pokemonId) {
        boolean found = pokemonService.lookForPokemon(pokemonId);
        return ResponseEntity.ok(found);
    }

}

