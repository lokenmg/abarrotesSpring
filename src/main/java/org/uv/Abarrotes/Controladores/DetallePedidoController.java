package org.uv.Abarrotes.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.DTODetallePedido;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.servicio.DetallePedidoService;

@Repository
@RequestMapping("api/detallepedido")
@CrossOrigin(origins="*", allowCredentials="")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping
    public ResponseEntity<DTODetallePedido> crearDetallePedido(@RequestBody DetallePedido detallePedido){
        DTODetallePedido nuevoDetallePedido = detallePedidoService.crearDetallePedido(detallePedido);
        return ResponseEntity.ok(nuevoDetallePedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTODetallePedido> obtenerDetallePedidoPorId(@PathVariable Long id){
        DTODetallePedido detallePedido = detallePedidoService.obtenerDetallePedido(id);
        return ResponseEntity.ok(detallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTODetallePedido> actualizarDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedido){
        DTODetallePedido detallePedidoActualizado = detallePedidoService.actualizarDetallePedido(id, detallePedido);
        return ResponseEntity.ok(detallePedidoActualizado);
    }
}
