package com.pokemonapi.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonapi.pokemonapi.api.model.Pokemon;
import com.pokemonapi.pokemonapi.api.repository.PokemonRepository;

@Service
public class PokemonService {

    //För att kunna använda CRUD operationer, t.ex. existsById
    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    //Sparar pokemon i databasen
    public Pokemon catchPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    //Tar bort pokemon från databasen
    public void releasePokemon(Integer pokemonId) {
       pokemonRepository.deleteById(pokemonId);
    }

    //Kolla om pokemon finns i databasen eller inte
    public boolean lookForPokemon(int pokemonId) {
        return pokemonRepository.existsById(pokemonId);
    }

}
