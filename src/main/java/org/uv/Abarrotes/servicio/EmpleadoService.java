/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.uv.Abarrotes.DTOs.DTOEmpleadoInfo;
import org.uv.Abarrotes.DTOs.Entradas.DTOCrearEmpleado;
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
    
    //public DTOEmpleadoInfo crearEmpleado(Empleado empleado) {
        // Verificar si el rol existe
      //  Rol rol = rolRepository.findById(empleado.getRoles().getIdRol())
        //        .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        //empleado.setRoles(rol);
        
        //Empleado empleadoG = empleadoRepository.save(empleado);
        
        //org.uv.Abarrotes.DTOs.DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleadoG);
        
        //return dto;
    //}
    public DTOEmpleadoInfo crearEmpleado(Empleado empleado) {
        // Verificar si el rol "EMPLOYEE" existe
        Rol rolEmpleado = rolRepository.findFirstByCve("EMPLOYEE")
             .orElseThrow(() -> new EntityNotFoundException("Rol 'EMPLOYEE' no encontrado"));

        // Asignar automáticamente el rol "EMPLOYEE" al nuevo empleado
        empleado.setRoles(rolEmpleado);

        Empleado empleadoG = empleadoRepository.save(empleado);

        org.uv.Abarrotes.DTOs.DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleadoG);

        return dto;
    }
    
    //public List<DTOEmpleadoInfo> obtenerEmpleados() {
      //  List<DTOEmpleadoInfo> DTOempleados = new ArrayList<>();
        //List<Empleado> empleados = empleadoRepository.findAll();

        // Convertir cada producto a DTOProductoInfo
        //for (Empleado empleado : empleados) {
          //  DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleado);
            //DTOempleados.add(dto);
        //}

        //return DTOempleados;
    //}

    //Metodo LIst Modificado
    public List<DTOEmpleadoInfo> obtenerEmpleados() {
        // Supongamos que tienes un método en tu repositorio llamado findAll() que devuelve empleados
        List<Empleado> empleados = empleadoRepository.findAll();

        // Convierte la lista de empleados a una lista de DTOEmpleadoInfo
        List<DTOEmpleadoInfo> dtoEmpleados = empleados.stream()
             .map(empleado -> convertirAEmpleadoInfo(empleado))
             .collect(Collectors.toList());

        return dtoEmpleados;
    }

    private DTOEmpleadoInfo convertirAEmpleadoInfo(Empleado empleado) {
        DTOEmpleadoInfo dtoEmpleado = new DTOEmpleadoInfo();
        // Copia los campos necesarios desde el empleado al DTO
        dtoEmpleado.setIdEmpleado(empleado.getIdEmpleado());
        dtoEmpleado.setNombre(empleado.getNombre());
        dtoEmpleado.setApellidos(empleado.getApellidos());

        // Asegúrate de que empleado.getRoles() devuelva el objeto de roles y luego obtén el idRol
        dtoEmpleado.setIdRol(empleado.getRoles().getIdRol());

        return dtoEmpleado;
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

    ///Meodos para el inicio de sesion

    public Empleado obtenerEmpleadoPorUsuario(String usuario) {
        return empleadoRepository.findByNombre(usuario);
    }

    public List<String> obtenerRolesDisponibles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream().map(Rol::getNombre).collect(Collectors.toList());
    }

    //__________________________

    public void init() {
        // Verificar si ya existen empleados en la base de datos
//        if (empleadoRepository.count() == 0) {
        // Si no hay empleados, crea dos empleados por defecto (jefe y gerente)

        // Crear el rol "Jefe"
        Rol rolJefe = new Rol();
        rolJefe.setCve("ENCARGADO");
        rolJefe.setDescripcion("Encargado");
        rolRepository.save(rolJefe);

        // Crear el empleado "Jefe" con contraseña "jefe123"
        Empleado empleadoJefe = new Empleado();
        empleadoJefe.setNombre("Encargado");
        empleadoJefe.setApellidos("ApellidoJefe");
        empleadoJefe.setContrasenia("jefe123"); // ¡Recuerda hashear la contraseña en un entorno de producción!
        empleadoJefe.setRoles(rolJefe);
        empleadoRepository.save(empleadoJefe);

        // Crear el rol "Gerente"
        Rol rolGerente = new Rol();
        rolGerente.setCve("GERENTE");
        rolGerente.setDescripcion("Gerente");
        rolRepository.save(rolGerente);

        // Crear el empleado "Gerente" con contraseña "gerente123"
        Empleado empleadoGerente = new Empleado();
        empleadoGerente.setNombre("Gerente");
        empleadoGerente.setApellidos("ApellidoGerente");
        empleadoGerente.setContrasenia("gerente123"); // ¡Recuerda hashear la contraseña en un entorno de producción!
        empleadoGerente.setRoles(rolGerente);
        empleadoRepository.save(empleadoGerente);
//        }
    }

    //Metodo  para buscar Empleados por No,bre y apellidos
    public List<DTOEmpleadoInfo> buscarEmpleadosPorNombreYApellidos(String nombre, String apellidos) {
        List<Empleado> empleados;

        if (nombre != null && apellidos != null) {
            // Buscar por nombre y apellidos
            empleados = empleadoRepository.findByNombreAndApellidos(nombre, apellidos);
        } else if (nombre != null) {
            // Buscar solo por nombre
            empleados = (List<Empleado>) empleadoRepository.findByNombre(nombre);
        } else if (apellidos != null) {
            // Buscar solo por apellidos
            empleados = empleadoRepository.findByApellidos(apellidos);
        } else {
            // Si ambos son nulos, devolver todos los empleados
            empleados = empleadoRepository.findAll();
        }

        return empleados.stream()
             .map(empleado -> convertirAEmpleadoInfo(empleado))
             .collect(Collectors.toList());
    }


    public DTOEmpleadoInfo crearEmpleadoConDTO(DTOCrearEmpleado empleado){
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellidos(empleado.getApellidos());
        nuevoEmpleado.setContrasenia(empleado.getContrasenia());
        Rol rol = rolRepository.findById(empleado.getIdRol())
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
        nuevoEmpleado.setRoles(rol);
        Empleado empleadoG = empleadoRepository.save(nuevoEmpleado);
        return new DTOEmpleadoInfo(empleadoG);
    }
}