package com.example.demo.Rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Pokemon;
import com.example.demo.services.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "*")
public class PokemonRest {
    
    @Autowired
    private PokemonService pokeService;

    @GetMapping
    public List<Pokemon> listar(){
        return pokeService.listarTodos();
    }
    
    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Long id ){
        return pokeService.listarById(id);
    } 
    
    @PostMapping
    public Pokemon insertar(@RequestBody Pokemon emp){
        return pokeService.insertar(emp);
    }
    
    @PutMapping
    public Pokemon actualizar(@RequestBody Pokemon emp){
        return pokeService.actualizar(emp);
    }

    @PutMapping("/nombre")
    public Pokemon actualizarNombreCustom(@RequestBody Pokemon emp){
        return pokeService.actualizar(emp);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Pokemon emp){
        pokeService.eliminar(emp);
    }
}
