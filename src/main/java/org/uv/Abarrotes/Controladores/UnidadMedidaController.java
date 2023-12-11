/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.servicio.UnidadMedidaService;

import DTOs.DTOUnidadMedida;

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
    public ResponseEntity<List<DTOUnidadMedida>> obtenerUnidadesMedida(){
        List<UnidadMedida> unidadesMedida = unidadMedidaService.obtenerUnidadesMedida();
        List<DTOUnidadMedida> dtoUnidadMedidas = new ArrayList<>();

        for(UnidadMedida unidadMedida : unidadesMedida){
            dtoUnidadMedidas.add(new DTOUnidadMedida(unidadMedida));
        }
        return ResponseEntity.ok(dtoUnidadMedidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOUnidadMedida> obtenerUnidadMedidaPorId(@PathVariable Long id){
        UnidadMedida unidadMedida = unidadMedidaService.obtenerUnidadMedidaPorId(id);
        DTOUnidadMedida dtoUnidadMedida = new DTOUnidadMedida(unidadMedida);
        return ResponseEntity.ok(dtoUnidadMedida);
    }
    
    @PostMapping
    public ResponseEntity<DTOUnidadMedida> crearUnidadMedida(@RequestBody UnidadMedida unidadMedida){
        UnidadMedida nuevaUnidadMedida = unidadMedidaService.crearUnidadMedida(unidadMedida);
        DTOUnidadMedida dtoUnidadMedida = new DTOUnidadMedida(nuevaUnidadMedida);
        return ResponseEntity.ok(dtoUnidadMedida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOUnidadMedida> actualizarUnidadMedida(@PathVariable Long id, @RequestBody UnidadMedida unidadMedida){
        Optional<UnidadMedida> unidadMedidaActualizada = unidadMedidaService.actualizarUnidadMedida(id, unidadMedida);
        if(unidadMedidaActualizada.isPresent()){
            return ResponseEntity.ok(new DTOUnidadMedida(unidadMedidaActualizada.get()));
        }
        return ResponseEntity.notFound().build();
    }
/*
    @DeleteMapping("/{id}")
    public ResponseEntity<UnidadMedida> eliminarUnidadMedida(@PathVariable Long id){
        boolean eliminado = unidadMedidaService.eliminarUnidadMedida(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
*/
}
