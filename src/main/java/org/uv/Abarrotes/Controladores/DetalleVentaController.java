/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;
import java.util.List;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.DTODetalleVenta;
import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.servicio.DetalleVentaService;
/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/detallesventas")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleventaService;
 
    @PostMapping
    public ResponseEntity<org.uv.Abarrotes.DTOs.DTODetalleVenta> crearDetalleVentaConEntidades(@RequestBody DetalleVenta nuevoDetalleVenta) {
        org.uv.Abarrotes.DTOs.DTODetalleVenta detalleventaCreado = detalleventaService.crearDetalleVenta(nuevoDetalleVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleventaCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTODetalleVenta>> obtenerDetallesVentas(){
        List<DTODetalleVenta> detalleventas = detalleventaService.obtenerDetallesVenta();
        return ResponseEntity.ok(detalleventas);
    }
    
}
