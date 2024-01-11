package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.Empleado;

@Service
public class InicioSessionService {
    @Autowired
    private EmpleadoService empleadoService;

    public boolean autenticarUsuario(String usuario, String contrasenia) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorUsuario(usuario);

        if (empleado != null) {
            // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            // return passwordEncoder.matches(contrasenia, empleado.getContrasenia());
            // Verificar si las contraseñas coinciden sin utilizar BCrypt
            return empleado.getContrasenia().equals(contrasenia);
        }

        return false;
    }

    // Metodo
    public String asignarPermisos(String usuario) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorUsuario(usuario);

        if (empleado != null && empleado.getRoles() != null) {
            // Verifica que getRoles() y getNombre() no sean nulos antes de utilizarlos
            String rol = empleado.getRoles().getNombre();
            System.out.println("Rol asignado: " + rol);
            return rol;
        }

        return null;
    }
}