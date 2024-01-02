package org.uv.Abarrotes.Controladores;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.Entradas.DTOMEstadoPedido;
import org.uv.Abarrotes.DTOs.Entradas.DTOPago;
import org.uv.Abarrotes.DTOs.Entradas.DTOPagoYpedido;
import org.uv.Abarrotes.modelos.NotaVenta;
import org.uv.Abarrotes.servicio.NotaVentaService;
import org.uv.Abarrotes.servicio.PedidoServicio;

@Controller
@RequestMapping("api/pedido")
@CrossOrigin(origins="*", allowCredentials="")
public class PedidoController {

    @Autowired
    private PedidoServicio pedidoServicio;

    @Autowired
    private NotaVentaService notaVentaService;

    @PostMapping
    public ResponseEntity<String> crearPedido(@Valid @RequestBody NotaVenta notaVenta) {
        try {
            pedidoServicio.CrearPedido(notaVenta);
            return new ResponseEntity<>("Pedido creado con éxito", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/modificarpedido")
    public ResponseEntity<String> modificarPedido(@RequestBody DTOMEstadoPedido infoPedido) {
        try {
            return new ResponseEntity<>(pedidoServicio.ModificarEstadoPedido(infoPedido), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @PostMapping("/pagarentregarpedido")
    public ResponseEntity<String> pagarEntregarPedido(@RequestBody DTOPagoYpedido infoPedido) {

        DTOPago pago = new DTOPago(infoPedido.getnNota(), infoPedido.getPago());
        DTOMEstadoPedido estado = new DTOMEstadoPedido(infoPedido.getIdPedido(), infoPedido.getnNota());

        try {
            pedidoServicio.ModificarEstadoPedido(estado);
            notaVentaService.PagarNotaVenta(pago);
            return new ResponseEntity<>("Pedido marcado como pagado y entregado con éxito", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}