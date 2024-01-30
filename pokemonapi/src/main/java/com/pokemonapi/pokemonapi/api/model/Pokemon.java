package com.pokemonapi.pokemonapi.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Skapar Pokemon entiteten med det som jag vill spara i databasen
@Entity
public class Pokemon {
    private String pokemonName;
    @Id
    private int pokemonId;

    public Pokemon() {
        
    }

    public Pokemon(String pokemonName, int pokemonId) {
        this.pokemonName = pokemonName;
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }
    
}
