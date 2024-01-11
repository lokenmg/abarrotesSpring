/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uv.Abarrotes.DTOs.DTOCategoria;
import org.uv.Abarrotes.modelos.Categoria;
import org.uv.Abarrotes.servicio.CategoriaService;


@Controller
@RequestMapping("/api/categorias")
@CrossOrigin(origins="*", allowCredentials="")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<DTOCategoria>> obtenerCategorias(){
        List<Categoria> categorias = categoriaService.obtenerCategorias();
        List<DTOCategoria> dtoCategorias = new ArrayList<>();
        for(Categoria categoria : categorias){
            dtoCategorias.add(new DTOCategoria(categoria));
        }
        return ResponseEntity.ok(dtoCategorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOCategoria> obtenerCategoriaPorId(@PathVariable Long id){
        DTOCategoria categoria = new DTOCategoria(categoriaService.obtenerCategoriaPorId(id));
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<DTOCategoria> crearCategoria(@Valid @RequestBody Categoria categoria){
        Categoria nuevaCategoria = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DTOCategoria(nuevaCategoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOCategoria> actualizarCategoria(@PathVariable Long id,@Valid @RequestBody Categoria categoria){
        Optional<Categoria> categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        if(categoriaActualizada.isPresent()){
            return ResponseEntity.ok(new DTOCategoria(categoriaActualizada.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DTOCategoria> eliminarCategoria(@PathVariable Long id){
        boolean eliminada= categoriaService.eliminarCategoria(id);
        return eliminada ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DTOCategoria>> buscarCategoriaPorNombre(@RequestParam String nombre){
        List<DTOCategoria> categorias = categoriaService.buscarCategoriaPorNombre(nombre);
        return ResponseEntity.ok(categorias);
    }
}
