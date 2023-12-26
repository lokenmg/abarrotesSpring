/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.repositorio.AnticipoRepository;
import org.uv.Abarrotes.repositorio.ClienteRepository;
import org.uv.Abarrotes.repositorio.DepartamentoRepository;
import org.uv.Abarrotes.repositorio.DetallePedidoRepository;
import org.uv.Abarrotes.repositorio.DetalleVentaRepository;
import org.uv.Abarrotes.repositorio.EmpleadoRepository;
import org.uv.Abarrotes.repositorio.EstadoPagoRepository;
import org.uv.Abarrotes.repositorio.EstadosPedidoRepository;
import org.uv.Abarrotes.repositorio.NotaVentaRepository;
import org.uv.Abarrotes.repositorio.ProductoRepository;

/**
 *
 * @author loken
 */
@Service
public class PedidoServicio {
    @Autowired
    private NotaVentaRepository notaventaRepository;
    
    @Autowired
    private EstadoPagoRepository estadopagoRepository;
    
    @Autowired
    private AnticipoRepository anticipoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EmpleadoRepository empleadoRepository;
    
    @Autowired
    private DepartamentoRepository departamentoRepository;
    
    @Autowired
    private DetallePedidoRepository detallepedidoRepository;
    
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private EstadosPedidoRepository estadosPedidoRepository;
}
