package com.example.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    private Long id_categoria;

    private String nombre;
    
    @ManyToMany(mappedBy = "categorias")
    @JsonIgnoreProperties("categorias")
    private List<Pokemon> pokemones;


    public List<Pokemon> getPokemones() {
        return pokemones;
    }
    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }
    // Constructor vacío requerido por JPA
    public Categoria() {
    }
    public Categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}