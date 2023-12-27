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
import org.uv.Abarrotes.DTOs.DTORol;
import org.uv.Abarrotes.modelos.Rol;
import org.uv.Abarrotes.repositorio.RolRepository;
/**
 *
 * @author yacruz
 */
@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    
    public DTORol crearRol(Rol rol) {
        
        Rol rolG = rolRepository.save(rol);
        
        org.uv.Abarrotes.DTOs.DTORol dto = new DTORol(rolG);
        
        return dto;
    }
    
    public List<DTORol> obtenerRoles() {
        List<DTORol> DTOrol = new ArrayList<>();
        List<Rol> roles = rolRepository.findAll();

        // Convertir cada rol a DTOProductoInfo
        for (Rol rol : roles) {
            DTORol dto = new DTORol(rol);
            DTOrol.add(dto);
        }

        return DTOrol;
    }
    
    public DTORol obtenerRolesPorId(long idRol) {
        Rol rol = rolRepository.findById(idRol)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        DTORol dto = new DTORol(rol);

        return dto;
    }
    
    public DTORol actualizarRol(Long idRol, Rol rolActualizado) {
        Rol rolExistente = rolRepository.findById(idRol)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        // Update fields
        rolExistente.setCve(rolActualizado.getCve());
        rolExistente.setDescripcion(rolActualizado.getDescripcion());

        // Save the updated employee
        Rol rolG = rolRepository.save(rolExistente);

        // Convert to DTO and return
        DTORol dto = new DTORol(rolG);
        return dto;
    }

    public void eliminarRol(Long idRol) {
        Rol rolExistente = rolRepository.findById(idRol)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        // Delete the employee
        rolRepository.delete(rolExistente);
    }


   // @Autowired
    //private EmpleadoRepository empleadoRepository;

    public void init() {
        // Crear objetos Rol
        Rol rolEmpl = new Rol(3L, "EMPLOYEE", "Rol del Empleado");

        // Guardar los roles en la base de datos (si es necesario)
        rolRepository.save(rolEmpl);

//        // Crear objetos Empleado con roles asociados
//        Empleado empleadoEmpl = new Empleado("John Doe", rolEmpl);
//
//        // Guardar los empleados en la base de datos
//        empleadoRepository.save(empleadoEmpl);
    }
}
