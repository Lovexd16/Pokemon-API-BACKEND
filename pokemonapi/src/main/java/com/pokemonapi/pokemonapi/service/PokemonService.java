package com.pokemonapi.pokemonapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pokemonapi.pokemonapi.api.model.Pokemon;

@Service
public class PokemonService {

    //Hämta från databas istället för hårdkodad lista
    private List<Pokemon> pokemonList;

    public PokemonService() {
        pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon(1, "Charmander", "Fire"));
        pokemonList.add(new Pokemon(2, "Squirtle", "Water"));
        pokemonList.add(new Pokemon(3, "Bulbasaur", "Grass"));
    }
    
    //Metod för att hämta individuell pokemon
    public Pokemon getPokemon(Integer id) {
        return pokemonList.stream()
        .filter(pokemon -> id.equals(pokemon.getId()))
        .findFirst()
        .orElse(null);
    }

}
