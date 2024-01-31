package com.pokemonapi.pokemonapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "*")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //PostMapping för att spara en pokemon i databas
    @PostMapping("/catch-pokemon")
    public String catchPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.catchPokemon(pokemon);
        System.out.println("Du fångade " + pokemon);
        return "Du fångade " + pokemon.getPokemonName() + "!";
    }

    //DeleteMapping för att ta bort en pokemon från databasen
    @DeleteMapping("/release-pokemon")
    public String releasePokemon(@RequestBody Pokemon pokemon) {
        int pokemonId = pokemon.getPokemonId();
        pokemonService.releasePokemon(pokemonId);
        System.out.println("Du släppte pokemonen med id " + pokemonId);
        return "Du släppte pokemonen med id " + pokemonId;
    }
    
    //GetMapping för att kolla om specifik pokemon finns i databasen eller inte
    @GetMapping("/look-for-pokemon")
    public boolean lookForPokemon(@RequestParam int pokemonId) {
        return pokemonService.lookForPokemon(pokemonId);
    }

    //Getmapping för att få ut alla pokemon som finns i databasen
    @GetMapping("get-caught-pokemon")
    public List<Pokemon> getCaughtPokemon() {
        return pokemonService.getCaughtPokemon();
    }

}

