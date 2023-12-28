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
import org.uv.Abarrotes.DTOs.DTONotaVenta;
import org.uv.Abarrotes.DTOs.DTOPago;
import org.uv.Abarrotes.DTOs.DTOVenta;
import org.uv.Abarrotes.modelos.NotaVenta;
import org.uv.Abarrotes.servicio.NotaVentaService;
/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/notasventas")
@CrossOrigin(origins="*", allowCredentials="")
public class NotaVentaController {
    @Autowired
    private NotaVentaService notaventaService;
 

    //postmapping para crear una nota de venta con metdo limpio
    @PostMapping("/crearlimpio")
    public ResponseEntity<String> crearNota(@RequestBody NotaVenta notaVenta) {
        try {
            NotaVenta nuevaNotaVenta = notaventaService.crandoVenta(notaVenta);
            return new ResponseEntity<>("Nota de venta creada con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
    
    @GetMapping
    public ResponseEntity<List<DTOVenta>> obtenerNotasVentas(){
        List<DTOVenta> notasventas = notaventaService.obtenerNotasVentas();
        return ResponseEntity.ok(notasventas);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DTOVenta> obtenerNotasVentasPorId(@PathVariable Long id){
        DTOVenta notasventas = notaventaService.obtenerNotaVentaPorId(id);
        return ResponseEntity.ok(notasventas);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTONotaVenta> actualizarNotaVenta(@PathVariable Long id, @RequestBody NotaVenta notaventaActualizado) {
        DTONotaVenta notaventa = notaventaService.actualizarNotaVenta(id, notaventaActualizado);
        return ResponseEntity.ok(notaventa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNotaVenta(@PathVariable Long id) {
        notaventaService.eliminarNotaVenta(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/pagarnota")
    public ResponseEntity<String> pagarNota(@RequestBody DTOPago pago) {
        try {
            return new ResponseEntity<>(notaventaService.PagarNotaVenta(pago), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } 
    }
}
