package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Categoria;
import com.example.demo.repositorio.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria insertar (Categoria cat){
        return categoriaRepository.save(cat);        
    }

    public Categoria actualizar (Categoria cat){
        return categoriaRepository.save(cat);        
    }

    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }
    public Categoria getByNombre(String nombre){
        return categoriaRepository.findByNombre(nombre);
    }
    

    public void eliminar(Categoria cat){
        categoriaRepository.delete(cat);
    }
}
