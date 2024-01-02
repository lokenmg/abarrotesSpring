/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.uv.Abarrotes.modelos.VistaNotaVentaPendiente;
import org.uv.Abarrotes.servicio.VistaNotaVentaPendienteService;
/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/vista-nota-venta-pendiente")
@CrossOrigin(origins="*", allowCredentials="")
public class VistaNotaVentaPendienteController {
    @Autowired
    private VistaNotaVentaPendienteService vistaNotaVentaPendienteService;

    @GetMapping
    public ResponseEntity<List<VistaNotaVentaPendiente>> getAllVistaNotaVentaPendiente() {
        return ResponseEntity.ok(vistaNotaVentaPendienteService.getAllVistaNotaVentaPendiente());
    }
}
