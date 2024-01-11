/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.DTOOpcionesRol;
import org.uv.Abarrotes.modelos.OpcionesRol;
import org.uv.Abarrotes.servicio.OpcionesRolService;

/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/opcionesrol")
@CrossOrigin(origins="*", allowCredentials="")
public class OpcionesRolController {
    @Autowired
    private OpcionesRolService opcionesRolService;
 
    @PostMapping
    public ResponseEntity<org.uv.Abarrotes.DTOs.DTOOpcionesRol> crearOpcionRolConEntidades(@Valid @RequestBody OpcionesRol nuevaopcionRol) {
        org.uv.Abarrotes.DTOs.DTOOpcionesRol opcionrolCreado = opcionesRolService.crearOpcionRol(nuevaopcionRol);
        return ResponseEntity.status(HttpStatus.CREATED).body(opcionrolCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTOOpcionesRol>> obtenerOpcionesRol(){
        List<DTOOpcionesRol> opcionesRol = opcionesRolService.obtenerOpcionesRoles();
        return ResponseEntity.ok(opcionesRol);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOOpcionesRol> obtenerOpcionRolPorId(@PathVariable Long id){
        DTOOpcionesRol opcionesRol = opcionesRolService.obtenerOpcionTolPorId(id);
        return ResponseEntity.ok(opcionesRol);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTOOpcionesRol> actualizarOpocionRol(@PathVariable Long id, @Valid @RequestBody OpcionesRol opcionRolActualizado) {
        DTOOpcionesRol opcionRol = opcionesRolService.actualizarOpcionRol(id, opcionRolActualizado);
        return ResponseEntity.ok(opcionRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOpcionRol(@PathVariable Long id) {
        opcionesRolService.eliminarOpocionRol(id);
        return ResponseEntity.noContent().build();
    }
}
