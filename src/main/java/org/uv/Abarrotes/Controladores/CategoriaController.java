/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.modelos.Categoria;
import org.uv.Abarrotes.servicio.CategoriaService;

/**
 *
 * @author loken
 */
@Controller
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerCategorias(){
        List<Categoria> categorias = categoriaService.obtenerCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id){
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Categoria nuevaCategoria = categoriaService.crearCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id,@RequestBody Categoria categoria){
        Optional<Categoria> categoriaActualizada = categoriaService.actualizarCategoria(id, categoria);
        if(categoriaActualizada.isPresent()){
            return ResponseEntity.ok(categoriaActualizada.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> eliminarCategoria(@PathVariable Long id){
        boolean eliminada= categoriaService.eliminarCategoria(id);
        return eliminada ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
