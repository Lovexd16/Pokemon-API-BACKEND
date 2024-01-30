package com.pokemonapi.pokemonapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonapi.pokemonapi.api.model.Pokemon;
import com.pokemonapi.pokemonapi.api.repository.PokemonRepository;

@Service
public class PokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon catchPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public void releasePokemon(Integer pokemonId) {
       pokemonRepository.deleteById(pokemonId);
    }

    public boolean lookForPokemon(int pokemonId) {
        return pokemonRepository.existsById(pokemonId);
    }

}
