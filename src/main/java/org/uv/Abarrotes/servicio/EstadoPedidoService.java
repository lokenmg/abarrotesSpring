package org.uv.Abarrotes.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.EstadosPedido;
import org.uv.Abarrotes.repositorio.EstadosPedidoRepository;

import DTOs.DTOEstadoPedido;

@Service
public class EstadoPedidoService {
    @Autowired
    private EstadosPedidoRepository estadoPedidoRepository;

    public List<DTOEstadoPedido> obtenerEstadosPedido(){
        List<EstadosPedido> estadosPedido = estadoPedidoRepository.findAll();
        List<DTOEstadoPedido> dtoEstadosPedido = new ArrayList<>();
        for(EstadosPedido estadoPedido : estadosPedido){
            dtoEstadosPedido.add(new DTOEstadoPedido(estadoPedido));
        }
        return dtoEstadosPedido;
    }

    public DTOEstadoPedido obtenerEstadoPedidoPorNombre(String estado){
        EstadosPedido estadoPedido = estadoPedidoRepository.findByEstado(estado);
        return new DTOEstadoPedido(estadoPedido);
    }

    public DTOEstadoPedido crearEstadoPedido(EstadosPedido estadoPedido){
        EstadosPedido nuevoEstadoPedido = estadoPedidoRepository.save(estadoPedido);
        return new DTOEstadoPedido(nuevoEstadoPedido);
    }

    public Optional<DTOEstadoPedido> actualizarEstadoPedido(Long id, EstadosPedido estadoPedido){
        if(!estadoPedidoRepository.existsById(id)){
            return Optional.empty();
        }
        estadoPedido.setIdEstado(id);
        return Optional.of(new DTOEstadoPedido(estadoPedidoRepository.save(estadoPedido)));
    }
}
