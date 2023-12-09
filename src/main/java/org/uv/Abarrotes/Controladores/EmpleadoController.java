/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;


import java.util.List;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.DTOEmpleadoInfo;
import org.uv.Abarrotes.modelos.Empleado;
import org.uv.Abarrotes.servicio.EmpleadoService;

/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
 
    @PostMapping
    public ResponseEntity<org.uv.Abarrotes.DTOs.DTOEmpleadoInfo> crearEmpleadoConEntidades(@RequestBody Empleado nuevoEmpleado) {
        org.uv.Abarrotes.DTOs.DTOEmpleadoInfo empleadoCreado = empleadoService.crearEmpleado(nuevoEmpleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTOEmpleadoInfo>> obtenerEmpleados(){
        List<DTOEmpleadoInfo> empleados = empleadoService.obtenerEmpleados();
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOEmpleadoInfo> obtenerEmpleadoPorId(@PathVariable Long id){
        DTOEmpleadoInfo empleado = empleadoService.obtenerEmpleadoPorId(id);
        return ResponseEntity.ok(empleado);
    }
}
