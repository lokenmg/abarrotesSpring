/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;
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
import org.uv.Abarrotes.DTOs.DTOOpcionesSistema;
import org.uv.Abarrotes.modelos.OpcionesSistema;
import org.uv.Abarrotes.servicio.OpcionesSistemaService;
/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/opcionessistema")
@CrossOrigin(origins="*", allowCredentials="")
public class OpcionesSistemaController {
    @Autowired
    private OpcionesSistemaService opcionesSistemaService;
    
    @PostMapping
    public ResponseEntity<org.uv.Abarrotes.DTOs.DTOOpcionesSistema> crearOpcionesSistemaConEntidades(@RequestBody OpcionesSistema nuevaOpcionSistema) {
        org.uv.Abarrotes.DTOs.DTOOpcionesSistema opcionSistemaCreada = opcionesSistemaService.crearOpcionesSistema(nuevaOpcionSistema);
        return ResponseEntity.status(HttpStatus.CREATED).body(opcionSistemaCreada);
    }

    @GetMapping
    public ResponseEntity<List<DTOOpcionesSistema>> obtenerOpcionesSistema(){
        List<DTOOpcionesSistema> opcionesSistema = opcionesSistemaService.obtenerOpcionesSistema();
        return ResponseEntity.ok(opcionesSistema);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOOpcionesSistema> obtenerOpcionesSistemaPorId(@PathVariable Long id){
        DTOOpcionesSistema opcionesSistema = opcionesSistemaService.obtenerOpcionesSistemaPorId(id);
        return ResponseEntity.ok(opcionesSistema);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTOOpcionesSistema> actualizarOpcionesSistema(@PathVariable Long id, @RequestBody OpcionesSistema OpcionSistemaActualizada) {
        DTOOpcionesSistema opcionesSistema = opcionesSistemaService.actualizarOpcionesSistema(id, OpcionSistemaActualizada);
        return ResponseEntity.ok(opcionesSistema);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Long id) {
        opcionesSistemaService.eliminarOpcionesSistema(id);
        return ResponseEntity.noContent().build();
    }
}
