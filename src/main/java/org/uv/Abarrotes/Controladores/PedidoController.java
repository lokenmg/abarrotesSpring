package org.uv.Abarrotes.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.modelos.NotaVenta;
import org.uv.Abarrotes.servicio.PedidoServicio;

@Controller
@RequestMapping("api/pedido")
@CrossOrigin(origins="*", allowCredentials="")
public class PedidoController {

    @Autowired
    private PedidoServicio pedidoServicio;

    @PostMapping
    public ResponseEntity<String> crearPedido(@RequestBody NotaVenta notaVenta) {
        try {
            pedidoServicio.CrearPedido(notaVenta);
            return new ResponseEntity<>("Pedido creado con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}