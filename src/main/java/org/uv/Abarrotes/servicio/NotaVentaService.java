/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTONotaVenta;
import org.uv.Abarrotes.DTOs.Entradas.DTOPago;
import org.uv.Abarrotes.DTOs.DTOVenta;
import org.uv.Abarrotes.modelos.Anticipo;
import org.uv.Abarrotes.modelos.Cliente;
import org.uv.Abarrotes.modelos.Departamento;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.modelos.Empleado;
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
 * @author yacruz
 */
@Service
public class NotaVentaService {
    
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
      
    
    public List<DTOVenta> obtenerNotasVentas() {
        List<NotaVenta> notaventas = notaventaRepository.findAll();
        List<DTOVenta> dtos = new ArrayList<>();
        for (NotaVenta notaventa : notaventas) {
            DTOVenta dto = new DTOVenta(notaventa);
            dtos.add(dto);
        }
        return dtos;
    }
    
    public DTOVenta obtenerNotaVentaPorId(long idNotaVenta) {
        NotaVenta notaventa = notaventaRepository.findById(idNotaVenta)
                .orElseThrow(() -> new EntityNotFoundException("Nota venta no encontrado"));

        DTOVenta dto = new DTOVenta(notaventa);

        return dto;
    }
    
    public DTONotaVenta actualizarNotaVenta(Long idNotaVenta, NotaVenta notaventaActualizada) {
        NotaVenta notaventaExistente = notaventaRepository.findById(idNotaVenta)
                .orElseThrow(() -> new EntityNotFoundException("Nota de venta no encontrado"));

        // Update fields
        notaventaExistente.setFecha(notaventaActualizada.getFecha());
        notaventaExistente.setTotal(notaventaActualizada.getTotal());
        notaventaExistente.setAnticipo(notaventaActualizada.getAnticipo());
        notaventaExistente.setCliente(notaventaActualizada.getCliente());
        notaventaExistente.setEmpleado(notaventaActualizada.getEmpleado());
        notaventaExistente.setDepartamento(notaventaActualizada.getDepartamento());
        notaventaExistente.setDetallePedido(notaventaActualizada.getDetallePedido());

        // Save the updated sale
        NotaVenta notaventaG = notaventaRepository.save(notaventaExistente);
        // Convert to DTO and return
        DTONotaVenta dto = new DTONotaVenta(notaventaG);
        return dto;
    }
    
    public void eliminarNotaVenta(Long idNotaVenta) {
        NotaVenta notaventaExistente = notaventaRepository.findById(idNotaVenta)
                .orElseThrow(() -> new EntityNotFoundException("Nota de venta no encontrado"));

        // Delete the sale
        notaventaRepository.delete(notaventaExistente);
    }


    public NotaVenta crandoVenta(NotaVenta notaventa){
        Date fecha = new Date(System.currentTimeMillis());
        Time hora = new Time(System.currentTimeMillis());
    
        Anticipo anticipo = crearAnticipo(notaventa, fecha);
        DetallePedido detallePedido = crearDetallePedido(fecha, hora);
        NotaVenta notaVenta = crearNotaDeVenta(notaventa, fecha, anticipo, detallePedido);
        crearDetalleVenta(notaventa, fecha, notaVenta);
    
        return notaVenta;
    }

    private Anticipo crearAnticipo(NotaVenta notaventa, Date fecha){
        Anticipo anticipo = new Anticipo();
        anticipo.setFecha(fecha);
        anticipo.setMonto(notaventa.getAnticipo().getMonto());
        BigDecimal resto = notaventa.getTotal().subtract(notaventa.getAnticipo().getMonto());
        anticipo.setResto(resto);
        Long estadoPagoId = resto.compareTo(BigDecimal.ZERO) == 0 ? 1L : 2L;
        anticipo.setResto(resto);
        EstadoPago estadoPago = estadopagoRepository.findById(estadoPagoId).orElseThrow(() -> new EntityNotFoundException("Estado de pago no encontrado"));
        anticipo.setEstadoPago(estadoPago);
        return anticipoRepository.save(anticipo);
    }

    private DetallePedido crearDetallePedido(Date fecha, Time hora){
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setFechaEntrega(fecha);
        detallePedido.setHoraEntrega(hora);
        EstadosPedido estadoPedido = estadosPedidoRepository.findById(2L).orElseThrow(() -> new EntityNotFoundException("Estado de pedido no encontrado"));
        detallePedido.setEstadoPedido(estadoPedido);
        return detallepedidoRepository.save(detallePedido);
    }

    private NotaVenta crearNotaDeVenta(NotaVenta notaventa, Date fecha, Anticipo anticipo, DetallePedido detallePedido){
        NotaVenta notaVenta = new NotaVenta();
        Cliente cliente = clienteRepository.findById(notaventa.getCliente().getIdCliente()).orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        Empleado empleado = empleadoRepository.findById(notaventa.getEmpleado().getIdEmpleado()).orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
        Departamento departamento = departamentoRepository.findById(notaventa.getDepartamento().getIdDepartamento()).orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado"));
        
        notaVenta.setFecha(fecha);
        notaVenta.setTotal(notaventa.getTotal());
        notaVenta.setAnticipo(anticipo);
        notaVenta.setCliente(cliente);
        notaVenta.setEmpleado(empleado);
        notaVenta.setDepartamento(departamento);
        notaVenta.setDetallePedido(detallePedido);
        return notaventaRepository.save(notaVenta);
    }

    private void crearDetalleVenta(NotaVenta notaventa, Date fecha, NotaVenta notaVenta){
        for (DetalleVenta detalle : notaventa.getDetalleVenta()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getCodigo()).orElseThrow();
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setCantidad(detalle.getCantidad());
            detalleVenta.setSubtotal(detalle.getSubtotal());
            detalleVenta.setFecha(fecha);
            detalleVenta.setProducto(producto);
            detalleVenta.setVenta(notaVenta);
            detalleVentaRepository.save(detalleVenta);
            long mExistencia = producto.getExistencia() - detalle.getCantidad();
            //actualizar stock
            if (mExistencia <= 0) {
                producto.setExistencia(0);
            }else{
                producto.setExistencia(mExistencia);
            }
            productoRepository.save(producto);
        }
    }

    public String PagarNotaVenta(DTOPago pagoInfo){
        //obtengo la nota de venta
        NotaVenta notaVenta = notaventaRepository.findById(pagoInfo.getnNota()).orElseThrow(() -> new EntityNotFoundException("Nota de venta no encontrado"));
        //obtengo el anticipo
        Anticipo anticipo = anticipoRepository.findById(notaVenta.getAnticipo().getIdAnticipo()).orElseThrow(() -> new EntityNotFoundException("Anticipo no encontrado"));
        //se suma el pago al anticipo
        BigDecimal monto = anticipo.getMonto().add(pagoInfo.getPago());
        anticipo.setMonto(monto);
        BigDecimal resto = notaVenta.getTotal().subtract(notaVenta.getAnticipo().getMonto());
        anticipo.setResto(resto);
        anticipo.setFecha(new Date(System.currentTimeMillis()));
        Long estadoPagoId = resto.compareTo(BigDecimal.ZERO) <= 0 ? 1L : 2L;
        EstadoPago estadoPago = estadopagoRepository.findById(estadoPagoId).orElseThrow(() -> new EntityNotFoundException("Estado de pago no encontrado"));
        anticipo.setEstadoPago(estadoPago);
        anticipoRepository.save(anticipo);
        return "Pago realizado con exito, la nota numero: " + notaVenta.getNumeroNota()+ " tiene un monto de: " + anticipo.getMonto() + " y un resto de: " + anticipo.getResto() + " con un estado de pago: " + anticipo.getEstadoPago().getEstado() + "";
    }
}
