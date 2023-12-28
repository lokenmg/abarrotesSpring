package org.uv.Abarrotes.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Abarrotes.modelos.Empleado;
import org.uv.Abarrotes.servicio.EmpleadoService;
import org.uv.Abarrotes.servicio.InicioSessionService;

@RestController
//@RequestMapping("/api/auth")
// Reemplaza con la URL de tu aplicación React
@CrossOrigin(origins="*", allowCredentials="")

public class inicioSessionController {
    @Autowired
    private InicioSessionService inicioSessionService;
    @Autowired
    private EmpleadoService empleadoService; 

    @PostMapping("/api/login")
    public String login(@RequestBody LoginRequest request) {
        String usuario = request.getUsuario();
        String contrasenia = request.getContrasenia();

        if (inicioSessionService.autenticarUsuario(usuario, contrasenia)) {
            String rol = inicioSessionService.asignarPermisos(usuario);
            return "Inicio de sesión exitoso. Rol: " + rol;
        } else {
            return "Inicio de sesión fallido";
        }
    }

    @GetMapping("/api/roles-inicioSession")
    public ResponseEntity<List<String>> obtenerRoles() {
        List<String> roles = empleadoService.obtenerRolesDisponibles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/api/empleado/{usuario}")
    public ResponseEntity<String> obtenerRolPorUsuario(@PathVariable String usuario) {
        Empleado empleado = empleadoService.obtenerEmpleadoPorUsuario(usuario);

        if (empleado != null) {
            String rol = empleado.getRoles().getNombre();
            return ResponseEntity.ok("Rol del usuario " + usuario + ": " + rol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/initEmpleados")
    public String inicializarEmpleados() {
        empleadoService.init(); // Llama al método init de EmpleadoService
        return "Empleados inicializados con éxito";
    }

    // Clase auxiliar para el cuerpo de la solicitud de inicio de sesión
    private static class LoginRequest {

        private String usuario;
        private String contrasenia;

        // getters y setters
        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getContrasenia() {
            return contrasenia;
        }

        public void setContrasenia(String contrasenia) {
            this.contrasenia = contrasenia;
        }
    }
}