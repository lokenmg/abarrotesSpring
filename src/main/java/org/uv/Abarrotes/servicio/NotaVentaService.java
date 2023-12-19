/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTONotaVenta;
import org.uv.Abarrotes.modelos.Anticipo;
import org.uv.Abarrotes.modelos.Cliente;
import org.uv.Abarrotes.modelos.Departamento;
import org.uv.Abarrotes.modelos.DetallePedido;
import org.uv.Abarrotes.modelos.Empleado;
import org.uv.Abarrotes.modelos.NotaVenta;
import org.uv.Abarrotes.repositorio.AnticipoRepository;
import org.uv.Abarrotes.repositorio.ClienteRepository;
import org.uv.Abarrotes.repositorio.DepartamentoRepository;
import org.uv.Abarrotes.repositorio.DetallePedidoRepository;
import org.uv.Abarrotes.repositorio.DetalleVentaRepository;
import org.uv.Abarrotes.repositorio.EmpleadoRepository;
import org.uv.Abarrotes.repositorio.NotaVentaRepository;


/**
 *
 * @author yacruz
 */
@Service
public class NotaVentaService {
    
    @Autowired
    private NotaVentaRepository notaventaRepository;
    
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
}
