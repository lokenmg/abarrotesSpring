/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Abarrotes.DTOs.DTOmarca;
import org.uv.Abarrotes.modelos.Marca;
import org.uv.Abarrotes.servicio.MarcaService;

/**
 *
 * @author loken
 */
@RestController
@RequestMapping("/api/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<DTOmarca>> obtenerMarcas(){
        List<Marca> marcas = marcaService.obtenerMarcas();
        List<DTOmarca> dtoMarcas = new ArrayList<>();
        for(Marca marca : marcas){
            dtoMarcas.add(new DTOmarca(marca));
        }
        return ResponseEntity.ok(dtoMarcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOmarca> obtenerMarcaPorId(@PathVariable Long id){
        Optional<DTOmarca> marca = marcaService.obtenerMarcaPorId(id);
        return marca.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DTOmarca> crearMarca(@RequestBody Marca marca){
        Marca nuevaMarca = marcaService.crearMarca(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(new DTOmarca(nuevaMarca));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOmarca> actualizarMarca(@PathVariable Long id,@RequestBody Marca marca){
        Optional<Marca> marcaActualizada = marcaService.actualizarMarca(id, marca);
        if(marcaActualizada.isPresent()){
            
            return ResponseEntity.ok(new DTOmarca(marcaActualizada.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(Long id){
        boolean eliminada = marcaService.eliminarMarca(id);
        return eliminada ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
