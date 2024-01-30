package com.pokemonapi.pokemonapi.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.pokemonapi.pokemonapi.api.model.Pokemon;

public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
    
}
