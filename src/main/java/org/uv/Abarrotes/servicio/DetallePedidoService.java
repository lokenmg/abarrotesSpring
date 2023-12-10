package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.repositorio.DetallePedidoRepository;

import DTOs.DTODetallePedido;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DTODetallePedido crearDetallePedido(DetallePedido detallePedido){
        return new DTODetallePedido(detallePedidoRepository.save(detallePedido));
    }

    
}
