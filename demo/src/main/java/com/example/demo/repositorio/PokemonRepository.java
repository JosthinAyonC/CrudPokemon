package com.example.demo.repositorio;


import com.example.demo.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    @Modifying
    @Query(value = "UPDATE Pokemon SET nombre = ?1 WHERE id_pokemon = ?2")
    public Pokemon updateNombrePokemon(String nombre, Long id_pokemon);
}
