package org.uv.Abarrotes.Controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
// @RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowCredentials = "")

public class inicioSessionController {
    @Autowired
    private InicioSessionService inicioSessionService;
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> credentials) {
        String usuario = credentials.get("usuario");
        String contrasenia = credentials.get("contrasenia");

        // Realizar la autenticación del usuario
        if (inicioSessionService.autenticarUsuario(usuario, contrasenia)) {
            // Si la autenticación es exitosa, obtener detalles del empleado
            Empleado empleado = empleadoService.obtenerEmpleadoPorUsuario(usuario);

            if (empleado != null) {
                // Construir la respuesta con el rol, id_empleado y nombre
                Map<String, Object> response = new HashMap<>();
                response.put("success", true);
                response.put("rol", empleado.getRoles().getNombre());
                response.put("id_empleado", empleado.getIdEmpleado());
                response.put("nombre", empleado.getNombre());
                return ResponseEntity.ok(response);
            }
        }

        // Si la autenticación falla, devuelve una respuesta de error
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Credenciales incorrectas");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
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