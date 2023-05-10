package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POKEMON")
    private Long id_pokemon;

    private String nombre;

    @ManyToMany
    @JoinTable(name = "pokemon_categoria", joinColumns = @JoinColumn(name = "id_pokemon"), inverseJoinColumns = @JoinColumn(name = "id_categoria") )
    @JsonIgnoreProperties("pokemones")
    private List<Categoria> categorias;

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Long getId_pokemon() {
        return id_pokemon;
    }

    public void setId_pokemon(Long id_pokemon) {
        this.id_pokemon = id_pokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
