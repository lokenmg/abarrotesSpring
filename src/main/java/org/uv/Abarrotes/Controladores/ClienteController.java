/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.DTOCliente;
import org.uv.Abarrotes.modelos.Cliente;
import org.uv.Abarrotes.servicio.ClienteService;
/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/clientes")
@CrossOrigin(origins="*", allowCredentials="")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping
    public ResponseEntity<org.uv.Abarrotes.DTOs.DTOCliente> crearClienteConEntidades(@RequestBody Cliente nuevoCliente) {
        org.uv.Abarrotes.DTOs.DTOCliente clienteCreado = clienteService.crearCliente(nuevoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTOCliente>> obtenerClientes(){
        List<DTOCliente> clientes = clienteService.obtenerClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOCliente> obtenerClientesPorId(@PathVariable Long id){
        DTOCliente cliente = clienteService.obtenerClientePorId(id);
        return ResponseEntity.ok(cliente);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<DTOCliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteActualizado) {
        DTOCliente cliente = clienteService.actualizarCliente(id, clienteActualizado);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
