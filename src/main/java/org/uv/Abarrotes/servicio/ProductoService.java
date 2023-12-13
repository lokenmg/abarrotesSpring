/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import org.uv.Abarrotes.DTOs.DTOProductoInfo;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.Categoria;
import org.uv.Abarrotes.modelos.Marca;
import org.uv.Abarrotes.modelos.Producto;
import org.uv.Abarrotes.modelos.UnidadMedida;
import org.uv.Abarrotes.repositorio.CategoriaRepository;
import org.uv.Abarrotes.repositorio.MarcaRepository;
import org.uv.Abarrotes.repositorio.ProductoRepository;
import org.uv.Abarrotes.repositorio.UnidadMedidaRepository;

/**
 *
 * @author loken
 */
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public DTOProductoInfo crearProducto(Producto producto) {

        if (productoRepository.existsById(producto.getCodigo())) {
            throw new EntityNotFoundException("Producto ya existe");
        }
        // Verificar si la categoría existe
        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));

        // Verificar si la marca existe
        Marca marca = marcaRepository.findById(producto.getMarca().getIdMarca())
                .orElseThrow(() -> new EntityNotFoundException("Marca no encontrada"));

        // Verificar si la unidad de medida existe
        UnidadMedida unidadMedida = unidadMedidaRepository.findById(producto.getUnidadMedida().getIdUnidadMed())
                .orElseThrow(() -> new EntityNotFoundException("Unidad de medida no encontrada"));

        producto.setCategoria(categoria);
        producto.setMarca(marca);
        producto.setUnidadMedida(unidadMedida);
        
        Producto productoG=productoRepository.save(producto);
        org.uv.Abarrotes.DTOs.DTOProductoInfo dto = new DTOProductoInfo(productoG);
        
        return dto;
    }

    public List<DTOProductoInfo> obtenerProductos() {
        List<DTOProductoInfo> DTOproductos = new ArrayList<>();
        List<Producto> productos = productoRepository.findAll();

        // Convertir cada producto a DTOProductoInfo
        for (Producto producto : productos) {
            DTOProductoInfo dto = new DTOProductoInfo(producto);
            DTOproductos.add(dto);
        }

        return DTOproductos;
    }

    public DTOProductoInfo obtenerProductoPorId(long codigo) {
        Producto producto = productoRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        DTOProductoInfo dto = new DTOProductoInfo(producto);

        return dto;
    }

    //modificar producto
    public DTOProductoInfo modificarProducto(Producto producto, long codigo){
        Producto productoExistente=productoRepository.findById(producto.getCodigo())
                .orElseThrow(()-> new EntityNotFoundException("Producto no encontrado"));
        
        // Verificar si la categoría existe
        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada"));
        
        // Verificar si la marca existe
        Marca marca = marcaRepository.findById(producto.getMarca().getIdMarca())
                .orElseThrow(() -> new EntityNotFoundException("Marca no encontrada"));
        
        // Verificar si la unidad de medida existe
        UnidadMedida unidadMedida = unidadMedidaRepository.findById(producto.getUnidadMedida().getIdUnidadMed())
                .orElseThrow(() -> new EntityNotFoundException("Unidad de medida no encontrada"));
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setExistencia(producto.getExistencia());
        productoExistente.setCategoria(categoria);
        productoExistente.setMarca(marca);
        productoExistente.setUnidadMedida(unidadMedida);

        DTOProductoInfo dto = new DTOProductoInfo(productoRepository.save(productoExistente));
        return dto;
    }

    public List<DTOProductoInfo> buscarProductoPorNombre(String nombre) {
        List<DTOProductoInfo> DTOproductos = new ArrayList<>();
        List<Producto> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);

        // Convertir cada producto a DTOProductoInfo
        for (Producto producto : productos) {
            DTOProductoInfo dto = new DTOProductoInfo(producto);
            DTOproductos.add(dto);
        }

        return DTOproductos;
    }
}
