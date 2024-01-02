package org.uv.Abarrotes.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.EstadoPago;
import org.uv.Abarrotes.repositorio.EstadoPagoRepository;

@Service
public class EstadoPagoService {
    
    @Autowired
    private EstadoPagoRepository estadopagoRepository;

    public List<EstadoPago> getEstadospagos() {
        return estadopagoRepository.findAll();
    }

}
