package org.uv.Abarrotes.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uv.Abarrotes.modelos.EstadosPedido;
import org.uv.Abarrotes.servicio.EstadoPedidoService;
import java.util.List;
import java.util.Optional;

import DTOs.DTOEstadoPedido;
@Controller
@RequestMapping("api/estadopedido")
public class EstadoPedidoController {
    @Autowired
    private EstadoPedidoService estadoPedidoService;


    @GetMapping
    public ResponseEntity<List <DTOEstadoPedido>> obtenerEstadosPedido(){
        List<DTOEstadoPedido> estadosPedido = estadoPedidoService.obtenerEstadosPedido();
        return ResponseEntity.ok(estadosPedido);
    }

    @GetMapping("/id")
    public ResponseEntity<DTOEstadoPedido> obtenerEstadoPedidoPorId(@PathVariable Long id){
        DTOEstadoPedido estadoPedido = estadoPedidoService.obtenerEstadoPedidoPorId(id);
        return ResponseEntity.ok(estadoPedido);
    }

    @GetMapping("/estado")
    public ResponseEntity<DTOEstadoPedido> obtenerEstadoPedidoPorNombre(@RequestParam String estado){
        DTOEstadoPedido estadoPedido = estadoPedidoService.obtenerEstadoPedidoPorNombre(estado);
        return ResponseEntity.ok(estadoPedido);
    }

    @PostMapping
    public ResponseEntity<DTOEstadoPedido> nuevoEstadoPedido(@RequestBody EstadosPedido estado){
        DTOEstadoPedido nuevoEstadoPedido = estadoPedidoService.crearEstadoPedido(estado);
        return ResponseEntity.ok(nuevoEstadoPedido);
    }

    @PutMapping("/id")
    public ResponseEntity<DTOEstadoPedido> actualizarEstadoPedido(@PathVariable Long id, @RequestBody EstadosPedido estado){
        Optional<DTOEstadoPedido> estadoPedidoActualizado = estadoPedidoService.actualizarEstadoPedido(id, estado);
        if (estadoPedidoActualizado.isPresent()) {
            return ResponseEntity.ok(estadoPedidoActualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
