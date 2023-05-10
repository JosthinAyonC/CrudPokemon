package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Pokemon;
import com.example.demo.repositorio.PokemonRepository;

import jakarta.persistence.Id;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokeRepository;

    public Pokemon insertar (Pokemon poke){
        return pokeRepository.save(poke);        
    }

    public Pokemon actualizar (Pokemon poke){
        Pokemon pokemonEditar = pokeRepository.findById(poke.getId_pokemon()).orElse(null);  
        if (pokemonEditar == null){
            return new Pokemon();
        }
        pokemonEditar.setNombre(poke.getNombre());

        return pokeRepository.save(pokemonEditar);        
    }

    public Pokemon actualizarNombre (Pokemon poke){
        return pokeRepository.updateNombrePokemon(poke.getNombre(), poke.getId_pokemon());        
    }

    public List<Pokemon> listarTodos(){
        return pokeRepository.findAll();
    }

    public Pokemon listarById(Long id){
        return pokeRepository.findById(id).get();
    }
    

    public void eliminar(Pokemon poke){
        pokeRepository.delete(poke);
    }
}
