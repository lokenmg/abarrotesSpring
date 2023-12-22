/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTOOpcionesSistema;
import org.uv.Abarrotes.modelos.OpcionesSistema;
import org.uv.Abarrotes.repositorio.OpcionesSistemaRepository;
/**
 *
 * @author yacruz
 */
@Service
public class OpcionesSistemaService {
    
    @Autowired
    private OpcionesSistemaRepository opcionesSistemaRepository;
    
    public DTOOpcionesSistema crearOpcionesSistema(OpcionesSistema opcionesSistema) {
        
        OpcionesSistema opcionesSistemaG = opcionesSistemaRepository.save(opcionesSistema);
        
        org.uv.Abarrotes.DTOs.DTOOpcionesSistema dto = new DTOOpcionesSistema(opcionesSistemaG);
        
        return dto;
    }
    
    public List<DTOOpcionesSistema> obtenerOpcionesSistema() {
        List<DTOOpcionesSistema> DTOopcionesSistema = new ArrayList<>();
        List<OpcionesSistema> opcionesSistemas = opcionesSistemaRepository.findAll();

        // Convertir cada OpcionSistema a DTOOpcionSistema
        for (OpcionesSistema opcionesSistema : opcionesSistemas) {
            DTOOpcionesSistema dto = new DTOOpcionesSistema(opcionesSistema);
            DTOopcionesSistema.add(dto);
        }

        return DTOopcionesSistema;
    }
    
    public DTOOpcionesSistema obtenerOpcionesSistemaPorId(long idOpcioneSistema) {
        OpcionesSistema opcionesSistema = opcionesSistemaRepository.findById(idOpcioneSistema)
                .orElseThrow(() -> new EntityNotFoundException("Opcion de sistema no encontrado"));

        DTOOpcionesSistema dto = new DTOOpcionesSistema(opcionesSistema);

        return dto;
    }
    
    public DTOOpcionesSistema actualizarOpcionesSistema(Long idOpcioneSistema, OpcionesSistema opcionSistemaActualizado) {
        OpcionesSistema opcionSistemaExistente = opcionesSistemaRepository.findById(idOpcioneSistema)
                .orElseThrow(() -> new EntityNotFoundException("Opcion sistema no encontrado"));

        // Update fields
        opcionSistemaExistente.setNombre(opcionSistemaActualizado.getNombre());
        opcionSistemaExistente.setTipo(opcionSistemaActualizado.getTipo());

        // Save the updated employee
        OpcionesSistema opcionesSistemaG = opcionesSistemaRepository.save(opcionSistemaExistente);

        // Convert to DTO and return
        DTOOpcionesSistema dto = new DTOOpcionesSistema(opcionesSistemaG);
        return dto;
    }
    public void eliminarOpcionesSistema(Long idOpcioneSistema) {
        OpcionesSistema opcionSistemaExistente = opcionesSistemaRepository.findById(idOpcioneSistema)
                .orElseThrow(() -> new EntityNotFoundException("Opcion sistema no encontrado"));

        // Delete the employee
        opcionesSistemaRepository.delete(opcionSistemaExistente);
    }
}
