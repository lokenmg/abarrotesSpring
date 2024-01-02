/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Abarrotes.DTOs.DTODetalleVenta;
import org.uv.Abarrotes.DTOs.DTODetallesVentas;
import org.uv.Abarrotes.DTOs.DTOReporte;
import org.uv.Abarrotes.DTOs.Entradas.DTOCrearReporte;
import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.modelos.Reporte;
import org.uv.Abarrotes.servicio.DetalleVentaService;
/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("api/detallesventas")
@CrossOrigin(origins="*", allowCredentials="")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleventaService;
 
    @PostMapping
    public ResponseEntity<org.uv.Abarrotes.DTOs.DTODetalleVenta> crearDetalleVentaConEntidades(@Valid @RequestBody DetalleVenta nuevoDetalleVenta) {
        org.uv.Abarrotes.DTOs.DTODetalleVenta detalleventaCreado = detalleventaService.crearDetalleVenta(nuevoDetalleVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleventaCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTODetalleVenta>> obtenerDetallesVentas(){
        List<DTODetalleVenta> detalleventas = detalleventaService.obtenerDetallesVenta();
        return ResponseEntity.ok(detalleventas);
    }
    
@GetMapping("/byNumeroNota/{numeroNota}")
    public List<DTODetallesVentas> getDetalleVentaByNumeroNota(@PathVariable Long numeroNota) {
        List<DetalleVenta> detallesEncontrados = detalleventaService.getDetalleVentaByNumeroNota(numeroNota);
        List<DTODetallesVentas> detallesVentas = new ArrayList<>();
        for (DetalleVenta detalle : detallesEncontrados) {
            DTODetallesVentas detalleVenta = new DTODetallesVentas();
            detalleVenta.setCantidad(detalle.getCantidad());
            detalleVenta.setSubtotal(detalle.getSubtotal().doubleValue());
            detalleVenta.setCodigo(detalle.getProducto().getCodigo());
            detalleVenta.setNombre(detalle.getProducto().getNombre());
            detalleVenta.setExistencia(detalle.getProducto().getExistencia());
            detallesVentas.add(detalleVenta);
        }
        return detallesVentas;
    }
    
    @PostMapping("/crearReporte")
    public ResponseEntity<DTOReporte> CrearReporte(@Valid @RequestBody DTOCrearReporte reporte) {

        Reporte nuevoReporte = detalleventaService.crearReporte(reporte);
        DTOReporte dtoReporte = new DTOReporte(nuevoReporte);
        return ResponseEntity.ok(dtoReporte);
    }
}
