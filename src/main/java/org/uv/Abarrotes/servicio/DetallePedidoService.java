package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.modelos.EstadosPedido;
import org.uv.Abarrotes.repositorio.DetallePedidoRepository;
import org.uv.Abarrotes.repositorio.EstadosPedidoRepository;

import DTOs.DTODetallePedido;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Autowired
    private EstadosPedidoRepository estadosPedidoRepository;

    public DTODetallePedido crearDetallePedido(DetallePedido detallePedido){
        EstadosPedido estado = estadosPedidoRepository.findById(detallePedido.getEstadoPedido().getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        detallePedido.setEstadoPedido(estado);
        return new DTODetallePedido(detallePedidoRepository.save(detallePedido));
    }

    public DTODetallePedido actualizarDetallePedido(DetallePedido detallePedido){
        DetallePedido detallePedidoEncontrado = detallePedidoRepository.findById(detallePedido.getEstadoPedido().getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        EstadosPedido estado = estadosPedidoRepository.findById(detallePedido.getEstadoPedido().getIdEstado())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        detallePedidoEncontrado.setEstadoPedido(estado);

        return new DTODetallePedido(detallePedidoRepository.save(detallePedido));
    }

    public DTODetallePedido obtenerDetallePedido(Long id){
        DetallePedido detallePedido = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Detalle pedido no encontrado"));
        return new DTODetallePedido(detallePedido);
    }

    

    
}
