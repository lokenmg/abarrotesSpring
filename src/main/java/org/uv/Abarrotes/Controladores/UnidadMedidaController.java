/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.servicio.UnidadMedidaService;
import org.uv.Abarrotes.modelos.UnidadMedida;

/**
 *
 * @author loken
 */
@Controller
@RequestMapping("/api/unidadesMedida")
public class UnidadMedidaController {
    @Autowired
    private UnidadMedidaService unidadMedidaService;

    @GetMapping
    public ResponseEntity<List<UnidadMedida>> obtenerUnidadesMedida(){
        List<UnidadMedida> unidadesMedida = unidadMedidaService.obtenerUnidadesMedida();
        return ResponseEntity.ok(unidadesMedida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnidadMedida> obtenerUnidadMedidaPorId(@PathVariable Long id){
        UnidadMedida unidadMedida = unidadMedidaService.obtenerUnidadMedidaPorId(id);
        return ResponseEntity.ok(unidadMedida);
    }
    
    @PostMapping
    public ResponseEntity<UnidadMedida> crearUnidadMedida(@RequestBody UnidadMedida unidadMedida){
        UnidadMedida nuevaUnidadMedida = unidadMedidaService.crearUnidadMedida(unidadMedida);
        return ResponseEntity.ok(nuevaUnidadMedida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadMedida> actualizarUnidadMedida(@PathVariable Long id, @RequestBody UnidadMedida unidadMedida){
        Optional<UnidadMedida> unidadMedidaActualizada = unidadMedidaService.actualizarUnidadMedida(id, unidadMedida);
        if(unidadMedidaActualizada.isPresent()){
            return ResponseEntity.ok(unidadMedidaActualizada.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UnidadMedida> eliminarUnidadMedida(@PathVariable Long id){
        boolean eliminado = unidadMedidaService.eliminarUnidadMedida(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
