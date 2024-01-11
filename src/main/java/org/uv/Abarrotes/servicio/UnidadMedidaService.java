/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.UnidadMedida;
import org.uv.Abarrotes.repositorio.UnidadMedidaRepository;

/**
 *
 * @author loken
 */
@Service
public class UnidadMedidaService {
    
    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedida crearUnidadMedida(@Valid UnidadMedida unidadMedida){
        return unidadMedidaRepository.save(unidadMedida);
    }

    public List<UnidadMedida> obtenerUnidadesMedida(){
        return unidadMedidaRepository.findAll();
    }

    public UnidadMedida obtenerUnidadMedidaPorId(Long id){
        return unidadMedidaRepository.findById(id).orElse(null);
    }

    public boolean eliminarUnidadMedida(Long id){
        if(!unidadMedidaRepository.existsById(id)){
            return false;
        }
        unidadMedidaRepository.deleteById(id);
        return true;
    }

    public Optional<UnidadMedida> actualizarUnidadMedida(Long id, @Valid UnidadMedida unidadMedida){
        if(!unidadMedidaRepository.existsById(id)){
            return Optional.empty();
        }
        unidadMedida.setIdUnidadMed(id);
        return Optional.of(unidadMedidaRepository.save(unidadMedida));
    }
}
