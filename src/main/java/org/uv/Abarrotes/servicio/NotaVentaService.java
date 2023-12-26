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
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTONotaVenta;
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
    
    public DTONotaVenta crearNotaVenta(NotaVenta notaventa) {
        
        Anticipo anticipo = anticipoRepository.findById(notaventa.getAnticipo().getIdAnticipo())
                .orElseThrow(() -> new EntityNotFoundException("Anticipo no encontrado"));
        Cliente cliente = clienteRepository.findById(notaventa.getCliente().getIdCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
        Empleado empleado = empleadoRepository.findById(notaventa.getEmpleado().getIdEmpleado())
                .orElseThrow(() -> new EntityNotFoundException("Empleado no encontrado"));
        Departamento departamento = departamentoRepository.findById(notaventa.getDepartamento().getIdDepartamento())
                .orElseThrow(() -> new EntityNotFoundException("Departamento no encontrado"));
        DetallePedido detallepedido = detallepedidoRepository.findById(notaventa.getDetallePedido().getIdDetallePedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado"));

        notaventa.setAnticipo(anticipo);
        notaventa.setCliente(cliente);
        notaventa.setEmpleado(empleado);
        notaventa.setDepartamento(departamento);
        notaventa.setDetallePedido(detallepedido);
        
        NotaVenta notaventaG = notaventaRepository.save(notaventa);
        
        org.uv.Abarrotes.DTOs.DTONotaVenta dto = new DTONotaVenta(notaventaG);
        
        return dto;
    }
    
    public NotaVenta crearNota(NotaVenta notaventa){
        //obtener fecha con java.sql.Date
        Date fecha = new Date(System.currentTimeMillis());
        //obtener hora actual con java.sql.Time
        Time hora = new Time(System.currentTimeMillis());
        Optional<EstadoPago> estadoPago;
        
        //crear anticipo
        Anticipo anticipo = new Anticipo();
        anticipo.setFecha(fecha);
        anticipo.setMonto(notaventa.getAnticipo().getMonto());
        BigDecimal resto = notaventa.getAnticipo().getMonto().subtract(notaventa.getTotal());
        anticipo.setResto(resto);
        if (resto.compareTo(BigDecimal.ZERO) == 0) {
        
            estadoPago = estadopagoRepository.findById(1L);
                
        }else{
            estadoPago = estadopagoRepository.findById(2L);
        }
        anticipo.setEstadoPago(estadoPago.get());
        Anticipo nuevoAnticipo= anticipoRepository.save(anticipo);
        //obteniendo el anticipo creado
        Optional<Anticipo> anticipoExistente = anticipoRepository.findById(nuevoAnticipo.getIdAnticipo());

        //obteniendo el cliente
        Optional<Cliente> clienteExistente = clienteRepository.findById(notaventa.getCliente().getIdCliente());
        
        //obteniendo el empleado
        Optional<Empleado> empleadoExistente = empleadoRepository.findById(notaventa.getEmpleado().getIdEmpleado());

        //obteniendo el departamento
        Optional<Departamento> departamentoExistente = departamentoRepository.findById(notaventa.getDepartamento().getIdDepartamento());

        //crear detalle pedido
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setFechaEntrega(fecha);
        detallePedido.setHoraEntrega(hora);
        EstadosPedido estadoPedido = estadosPedidoRepository.findById(2L).get();
        detallePedido.setEstadoPedido(estadoPedido);
        DetallePedido nuevodetallepedido = detallepedidoRepository.save(detallePedido);

        //creando la nota de venta
        NotaVenta notaVenta = new NotaVenta();
        notaVenta.setFecha(fecha);
        notaVenta.setTotal(notaventa.getTotal());
        notaVenta.setAnticipo(anticipoExistente.get());
        notaVenta.setCliente(clienteExistente.get());
        notaVenta.setEmpleado(empleadoExistente.get());
        notaVenta.setDepartamento(departamentoExistente.get());
        notaVenta.setDetallePedido(nuevodetallepedido);
        NotaVenta notaguardada=notaventaRepository.save(notaVenta);

        //creando detalle venta
        List<DetalleVenta> detallesVenta = new ArrayList<>();
        detallesVenta = notaventa.getDetalleVenta();
        for (DetalleVenta detalle : detallesVenta) {
            
            //obteniendo el producto
            Optional<Producto> productoExistente = productoRepository.findById(detalle.getProducto().getCodigo());
            
            //creando detalle venta
            DetalleVenta detalleVentaG = new DetalleVenta();
            detalleVentaG.setCantidad(detalle.getCantidad());
            detalleVentaG.setSubtotal(detalle.getSubtotal());
            detalleVentaG.setFecha(fecha);
            detalleVentaG.setProducto(productoExistente.get());
            detalleVentaG.setVenta(notaguardada);
            detalleVentaRepository.save(detalleVentaG);
        }
        Optional<NotaVenta> notaventaG = notaventaRepository.findById(notaguardada.getNumeroNota());
        NotaVenta verNota = notaventaG.get();
        return notaventaG.get(); 
    }
    
    public List<DTONotaVenta> obtenerNotasVentas() {
        List<DTONotaVenta> DTOnotaventa = new ArrayList<>();
        List<NotaVenta> notasventas = notaventaRepository.findAll();

        
        for (NotaVenta notaventa : notasventas) {
            DTONotaVenta dto = new DTONotaVenta(notaventa);
            DTOnotaventa.add(dto);
        }

        return DTOnotaventa;
    }
    
    public DTONotaVenta obtenerNotaVentaPorId(long idNotaVenta) {
        NotaVenta notaventa = notaventaRepository.findById(idNotaVenta)
                .orElseThrow(() -> new EntityNotFoundException("Nota venta no encontrado"));

        DTONotaVenta dto = new DTONotaVenta(notaventa);

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
        BigDecimal resto = notaventa.getAnticipo().getMonto().subtract(notaventa.getTotal());
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
        notaVenta.setFecha(fecha);
        notaVenta.setTotal(notaventa.getTotal());
        notaVenta.setAnticipo(anticipo);
        notaVenta.setCliente(notaventa.getCliente());
        notaVenta.setEmpleado(notaventa.getEmpleado());
        notaVenta.setDepartamento(notaventa.getDepartamento());
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
            //actualizar stock
            
            producto.setExistencia(producto.getExistencia() - detalle.getCantidad());
            productoRepository.save(producto);
        }
    }
}
