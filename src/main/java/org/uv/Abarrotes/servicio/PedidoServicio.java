/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.Anticipo;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.modelos.EstadoPago;
import org.uv.Abarrotes.modelos.EstadosPedido;
import org.uv.Abarrotes.modelos.NotaVenta;
import org.uv.Abarrotes.modelos.Producto;
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

    private Date fecha = new Date(System.currentTimeMillis());

    public NotaVenta CrearPedido(NotaVenta pedido){ 
        Anticipo anticipo = CrearAnticipo(pedido);
        DetallePedido detallePedido = CrearDetallePedido(pedido);
        NotaVenta notaVenta = CrearNotaVenta(pedido, anticipo, detallePedido);
        crearDetalleVenta(pedido, notaVenta);

        return notaVenta;
    }

    private Anticipo CrearAnticipo(NotaVenta nota){
        Anticipo nuevoAnticipo = new Anticipo();
        nuevoAnticipo.setFecha(this.fecha);
        nuevoAnticipo.setMonto(nota.getAnticipo().getMonto());
        
        BigDecimal resto = nota.getAnticipo().getMonto().subtract(nota.getTotal());
        nuevoAnticipo.setResto(resto);
        
        Long estadoPagoId= resto.compareTo(BigDecimal.ZERO) == 0 ? 1L : 2L;
        EstadoPago estadoPago = estadopagoRepository.findById(estadoPagoId).orElseThrow(() -> new EntityNotFoundException("Estado de pago no encontrado"));
        nuevoAnticipo.setEstadoPago(estadoPago);
        return anticipoRepository.save(nuevoAnticipo);
    }

    private DetallePedido CrearDetallePedido(NotaVenta nota){
        DetallePedido nuevoDetallePedido = new DetallePedido();
        nuevoDetallePedido.setFechaEntrega(nota.getDetallePedido().getFechaEntrega());
        nuevoDetallePedido.setHoraEntrega(nota.getDetallePedido().getHoraEntrega());
        EstadosPedido estadoPedido = estadosPedidoRepository.findById(2L).orElseThrow(() -> new EntityNotFoundException("Estado de pedido no encontrado"));
        nuevoDetallePedido.setEstadoPedido(estadoPedido);
        return detallepedidoRepository.save(nuevoDetallePedido);
    }

    private NotaVenta CrearNotaVenta(NotaVenta notaventa, Anticipo anticipo, DetallePedido detallePedido){
        NotaVenta nuevaNotaVenta = new NotaVenta();
        nuevaNotaVenta.setFecha(this.fecha);
        nuevaNotaVenta.setTotal(notaventa.getTotal());
        nuevaNotaVenta.setAnticipo(anticipo);
        nuevaNotaVenta.setCliente(clienteRepository.findById(notaventa.getCliente().getIdCliente()).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado")));
        nuevaNotaVenta.setEmpleado(empleadoRepository.findById(notaventa.getEmpleado().getIdEmpleado()).orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado")));
        nuevaNotaVenta.setDepartamento(departamentoRepository.findById(notaventa.getDepartamento().getIdDepartamento()).orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado")));
        nuevaNotaVenta.setDetallePedido(CrearDetallePedido(notaventa));
        return notaventaRepository.save(nuevaNotaVenta);
    }

    private void crearDetalleVenta(NotaVenta pedido, NotaVenta notaVenta){
        for (DetalleVenta detalle : pedido.getDetalleVenta()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getCodigo()).orElseThrow();
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setCantidad(detalle.getCantidad());
            detalleVenta.setSubtotal(detalle.getSubtotal());
            detalleVenta.setFecha(fecha);
            detalleVenta.setProducto(producto);
            detalleVenta.setVenta(notaVenta);
            detalleVentaRepository.save(detalleVenta);
            //actualizar stock
            
            producto.setExistencia(producto.getExistencia() - detalle.getCantidad());
            productoRepository.save(producto);
        }
    }
}
