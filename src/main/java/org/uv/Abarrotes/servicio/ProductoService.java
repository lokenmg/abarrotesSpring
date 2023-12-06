/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package org.uv.Abarrotes.servicio;

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

    public Producto crearProducto(Producto producto){
        
        Categoria categoria = categoriaRepository.findById(producto.getCategoria().getIdCategoria())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        Marca marca = marcaRepository.findById(producto.getMarca().getIdMarca())
                .orElseThrow(()-> new RuntimeException("Marca no encontrada"));

        UnidadMedida unidadMedida = unidadMedidaRepository.findById(producto.getUnidadMedida().getIdUnidadMed())
                .orElseThrow(() -> new RuntimeException("Unidad de medida no encontrada"));

        producto.setCategoria(categoria);
        producto.setMarca(marca);
        producto.setUnidadMedida(unidadMedida);

        return productoRepository.save(producto);
    }
}
