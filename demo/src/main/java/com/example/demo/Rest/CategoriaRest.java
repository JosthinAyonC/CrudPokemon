package com.example.demo.Rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Categoria;
import com.example.demo.services.CategoriaService;


@RestController
@RequestMapping("/api/categoria")
public class CategoriaRest {
    
    @Autowired
    private CategoriaService catService;

    @GetMapping
    public List<Categoria> listar(){
        return catService.listarTodos();
    }
    
    @PostMapping
    public Categoria insertar(@RequestBody Categoria emp){
        return catService.insertar(emp);
    }
    
    @PutMapping
    public Categoria actualizar(@RequestBody Categoria emp){
        return catService.actualizar(emp);
    }

    @GetMapping("/{nombre}")
    public Categoria getCategoriaByNombre(@PathVariable String nombre ){
        return catService.getByNombre(nombre);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Categoria emp){
        catService.eliminar(emp);
    }
}
