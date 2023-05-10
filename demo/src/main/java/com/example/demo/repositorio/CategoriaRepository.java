package com.example.demo.repositorio;


import com.example.demo.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    public Categoria findByNombre(String nombre);    
}
