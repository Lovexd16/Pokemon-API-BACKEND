package com.pokemonapi.pokemonapi.service;

import java.util.List;

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

    //Sparar hela pokemon objektet i databasen (namn & id)
    public Pokemon catchPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    //Tar bort pokemon från databasen med hjälp av id
    public void releasePokemon(Integer pokemonId) {
       pokemonRepository.deleteById(pokemonId);
    }

    //Kolla om en pokemon finns i databasen eller inte genom id
    public boolean lookForPokemon(int pokemonId) {
        return pokemonRepository.existsById(pokemonId);
    }

    //Lista av alla pokemon som är sparade i databasen med findAll
    public List<Pokemon> getCaughtPokemon() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

}
