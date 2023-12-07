/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.modelos.Producto;
import org.uv.Abarrotes.servicio.ProductoService;

/**
 *
 * @author loken
 */
@Controller
@RequestMapping("api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
 
    @PostMapping
    public ResponseEntity<Producto> crearProductoConEntidades(@RequestBody Producto nuevoProducto) {
        System.out.println(nuevoProducto.getNombre());
        Producto productoCreado = productoService.crearProducto(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerProductos(){
        List<Producto> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

}
