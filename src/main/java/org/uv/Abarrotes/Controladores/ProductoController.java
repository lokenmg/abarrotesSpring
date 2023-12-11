/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package org.uv.Abarrotes.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uv.Abarrotes.modelos.Producto;
import org.uv.Abarrotes.servicio.ProductoService;

import DTOs.DTOProductoInfo;

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
    public ResponseEntity<DTOs.DTOProductoInfo> crearProductoConEntidades(@RequestBody Producto nuevoProducto) {
        DTOs.DTOProductoInfo productoCreado = productoService.crearProducto(nuevoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @GetMapping
    public ResponseEntity<List<DTOProductoInfo>> obtenerProductos(){
        List<DTOProductoInfo> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOProductoInfo> obtenerProductoPorId(@PathVariable Long id){
        DTOProductoInfo producto = productoService.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOProductoInfo> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto){
        DTOProductoInfo productoActualizado = productoService.modificarProducto(producto, id);
        return ResponseEntity.ok(productoActualizado);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<DTOProductoInfo>> buscarProductoPorNombre(@RequestParam String nombre){
        List<DTOProductoInfo> productos = productoService.buscarProductoPorNombre(nombre);
        return ResponseEntity.ok(productos);
    }

}
