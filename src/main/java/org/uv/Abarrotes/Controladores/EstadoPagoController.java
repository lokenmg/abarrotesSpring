package org.uv.Abarrotes.Controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Abarrotes.DTOs.DTOEstadoPagos;
import org.uv.Abarrotes.modelos.EstadoPago;
import org.uv.Abarrotes.servicio.EstadoPagoService;

@RequestMapping("/api/estadopago")
@RestController
public class EstadoPagoController {
    @Autowired
    private EstadoPagoService estadopagoService;


    @GetMapping
    public ResponseEntity<List<DTOEstadoPagos>> getAllEstadoPago() {
        List<EstadoPago> estadosPago = estadopagoService.getEstadospagos();
        List<DTOEstadoPagos> dto= new ArrayList<>();
        for (EstadoPago estadoPago : estadosPago) {
            dto.add(new DTOEstadoPagos(estadoPago));
        }

        return ResponseEntity.ok(dto);
    }
}
