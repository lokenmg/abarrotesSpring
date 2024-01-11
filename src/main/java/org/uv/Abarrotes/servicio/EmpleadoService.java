/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoService.class);

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private RolRepository rolRepository;

    public DTOEmpleadoInfo crearEmpleado(@Valid Empleado empleado, String descripcionRol) {
        // Verificar si el rol especificado existe
        Rol rol = rolRepository.findByDescripcion(descripcionRol)
                .orElseThrow(() -> new EntityNotFoundException("Rol '" + descripcionRol + "' no encontrado"));

        // Asignar el rol al nuevo empleado
        empleado.setRoles(rol);

        // Guardar el nuevo empleado en la base de datos
        Empleado empleadoGuardado = empleadoRepository.save(empleado);

        // Crear y devolver un DTO con la información del empleado guardado
        DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleadoGuardado);

        return dto;
    }

    public DTOEmpleadoInfo crearEmpleadoConDTO(@Valid DTOCrearEmpleado empleado) {
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre(empleado.getNombre());
        nuevoEmpleado.setApellidos(empleado.getApellidos());
        nuevoEmpleado.setContrasenia(empleado.getContrasenia());
        nuevoEmpleado.setCorreoElectronico(empleado.getCorreoElectronico());
        Rol rol = rolRepository.findById(empleado.getIdRol())
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
        nuevoEmpleado.setRoles(rol);
        Empleado empleadoG = empleadoRepository.save(nuevoEmpleado);
        return new DTOEmpleadoInfo(empleadoG);
    }

    // Metodo LIst Modificado
    public List<DTOEmpleadoInfo> obtenerEmpleados() {
        try {
            // Supongamos que tienes un método en tu repositorio llamado findAll() que
            // devuelve empleados
            List<Empleado> empleados = empleadoRepository.findAll();

            // Convierte la lista de empleados a una lista de DTOEmpleadoInfo
            List<DTOEmpleadoInfo> dtoEmpleados = empleados.stream()
                    .map(empleado -> convertirAEmpleadoInfo(empleado))
                    .collect(Collectors.toList());

            logger.info("Se obtuvo la lista de empleados con éxito. Cantidad de empleados: {}", dtoEmpleados.size());

            return dtoEmpleados;
        } catch (Exception e) {
            logger.error("Error al obtener la lista de empleados", e);
            throw new RuntimeException("Error al obtener la lista de empleados", e);
        }
    }

    private DTOEmpleadoInfo convertirAEmpleadoInfo(@Valid Empleado empleado) {
        DTOEmpleadoInfo dtoEmpleado = new DTOEmpleadoInfo();

        dtoEmpleado.setIdEmpleado(empleado.getIdEmpleado());
        dtoEmpleado.setNombre(empleado.getNombre());
        dtoEmpleado.setApellidos(empleado.getApellidos());
        dtoEmpleado.setCorreoElectronico(empleado.getCorreoElectronico());
        dtoEmpleado.setRoles(empleado.getRoles().getDescripcion());

        dtoEmpleado.setIdRol(empleado.getRoles().getIdRol());

        return dtoEmpleado;
    }

    public DTOEmpleadoInfo obtenerEmpleadoPorId(long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        DTOEmpleadoInfo dto = new DTOEmpleadoInfo(empleado);

        return dto;
    }

    public DTOEmpleadoInfo actualizarEmpleado(Long idEmpleado,@Valid  Empleado empleadoActualizado) {
        Empleado empleadoExistente = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));

        // Update fields
        empleadoExistente.setNombre(empleadoActualizado.getNombre());
        empleadoExistente.setApellidos(empleadoActualizado.getApellidos());
        empleadoExistente.setRoles(empleadoActualizado.getRoles());
        empleadoExistente.setCorreoElectronico(empleadoActualizado.getCorreoElectronico());

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

    /// Meodos para el inicio de sesion

    public Empleado obtenerEmpleadoPorUsuario(String usuario) {
        try {
            return empleadoRepository.findByNombre(usuario);
        } catch (NoResultException | NonUniqueResultException ex) {
            // Manejar la excepción aquí o lanzarla nuevamente si es necesario
            ex.printStackTrace();
            return null; // o lanzar una excepción personalizada si prefieres
        }
    }

    public List<String> obtenerRolesDisponibles() {
        List<Rol> roles = rolRepository.findAll();
        return roles.stream().map(Rol::getNombre).collect(Collectors.toList());
    }

    // __________________________

    public void init() {
        // Verificar si ya existen empleados en la base de datos
        if (empleadoRepository.findByNombre("Maria del Carmen")==null) {
            // Si no hay empleados, crea dos empleados por defecto (jefe y gerente)
            // Crear el rol "Gerente"
            Rol rolEncDepart = new Rol();
            rolEncDepart.setCve("ENC_DEP");
            rolEncDepart.setDescripcion("Encargado_Departamento");
            rolRepository.save(rolEncDepart);

            // Crear el empleado "Gerente" con contraseña "gerente123"
            Empleado empleadoEncDepart = new Empleado();
            empleadoEncDepart.setNombre("Maria del Carmen");
            empleadoEncDepart.setApellidos("Rodriguez Gutierrez");
            empleadoEncDepart.setContrasenia("jefe123"); // ¡Recuerda hashear la contraseña en un entorno de producción!
            empleadoEncDepart.setCorreoElectronico("mariadelcarmen@gmail.com");
            empleadoEncDepart.setRoles(rolEncDepart);
            empleadoRepository.save(empleadoEncDepart);

        }
    }

    // Metodo para buscar Empleados por No,bre y apellidos
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
}