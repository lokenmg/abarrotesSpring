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

import org.uv.Abarrotes.DTOs.DTOEmpleadoInfo;
import org.uv.Abarrotes.modelos.Empleado;
import org.uv.Abarrotes.modelos.Rol;
import org.uv.Abarrotes.repositorio.EmpleadoRepository;
import org.uv.Abarrotes.repositorio.RolRepository;
/**
 *
 * @author yacruz
 */
@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private RolRepository rolRepository;
    
    public DTOEmpleadoInfo crearEmpleado(Empleado empleado) {
        // Verificar si el rol existe
        Rol rol = rolRepository.findById(empleado.getRoles().getIdRol())
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        empleado.setRoles(rol);
        
        Empleado empleadoG = empleadoRepository.save(empleado);
        
        org.uv.Abarrotes.DTOs.DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleadoG);
        
        return dto;
    }
    
    public List<DTOEmpleadoInfo> obtenerEmpleados() {
        List<DTOEmpleadoInfo> DTOempleados = new ArrayList<>();
        List<Empleado> empleados = empleadoRepository.findAll();

        // Convertir cada producto a DTOProductoInfo
        for (Empleado empleado : empleados) {
            DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleado);
            DTOempleados.add(dto);
        }

        return DTOempleados;
    }
    
    public DTOEmpleadoInfo obtenerEmpleadoPorId(long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleado);

        return dto;
    }
    
    public DTOEmpleadoInfo actualizarEmpleado(Long idEmpleado, Empleado empleadoActualizado) {
        Empleado empleadoExistente = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        // Update fields
        empleadoExistente.setNombre(empleadoActualizado.getNombre());
        empleadoExistente.setApellidos(empleadoActualizado.getApellidos());
        empleadoExistente.setRoles(empleadoActualizado.getRoles());

        // Save the updated employee
        Empleado empleadoG = empleadoRepository.save(empleadoExistente);

        // Convert to DTO and return
        DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleadoG);
        return dto;
    }

    public void eliminarEmpleado(Long idEmpleado) {
        Empleado empleadoExistente = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        // Delete the employee
        empleadoRepository.delete(empleadoExistente);
    }
}
