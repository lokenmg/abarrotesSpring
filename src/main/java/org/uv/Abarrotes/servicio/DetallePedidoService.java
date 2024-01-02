package org.uv.Abarrotes.servicio;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTODetallePedido;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.modelos.EstadosPedido;
import org.uv.Abarrotes.repositorio.DetallePedidoRepository;
import org.uv.Abarrotes.repositorio.EstadosPedidoRepository;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private EstadosPedidoRepository estadosPedidoRepository;

    public DTODetallePedido crearDetallePedido(@Valid DetallePedido detallePedido){
        EstadosPedido estado = estadosPedidoRepository.findById(detallePedido.getEstadoPedido().getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        detallePedido.setEstadoPedido(estado);
        return new DTODetallePedido(detallePedidoRepository.save(detallePedido));
    }

    public DTODetallePedido actualizarDetallePedido(Long id, @Valid DetallePedido detallePedido){
        DetallePedido detallePedidoEncontrado = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        EstadosPedido estado = estadosPedidoRepository.findById(detallePedido.getEstadoPedido().getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        detallePedidoEncontrado.setFechaEntrega(detallePedido.getFechaEntrega());
        detallePedidoEncontrado.setHoraEntrega(detallePedido.getHoraEntrega());
        detallePedidoEncontrado.setEstadoPedido(estado);

        return new DTODetallePedido(detallePedidoRepository.save(detallePedidoEncontrado));
    }

    public DTODetallePedido obtenerDetallePedido(Long id){
        DetallePedido detallePedido = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle pedido no encontrado"));
        return new DTODetallePedido(detallePedido);
    }

    

    
}
