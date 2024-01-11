/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import java.math.BigDecimal;
import java.sql.Date;
import javax.validation.constraints.NotNull;
import org.uv.Abarrotes.modelos.NotaVenta;

/**
 *
 * @author yacruz
 */
public class DTONotaVenta {

    private Long numeroNota;
    @NotNull(message = "La fecha no puede ser nula")
    private Date fecha;

    @NotNull(message = "El total no puede ser nulo")
    private BigDecimal total;

    @NotNull(message = "El anticipo no puede ser nulo")
    private Long anticipo;

    @NotNull(message = "El cliente no puede ser nulo")
    private Long cliente;

    @NotNull(message = "El empleado no puede ser nulo")
    private Long empleado;

    @NotNull(message = "El departamento no puede ser nulo")
    private Long departamento;

    @NotNull(message = "El detalle de pedido no puede ser nulo")
    private Long detallepedido;
    
    public DTONotaVenta(){
        
    }
    
    public DTONotaVenta(Long numeroNota, Date fecha, BigDecimal total, Long anticipo, Long cliente, 
            Long empleado, Long departamento, Long detallepedido){
        this.numeroNota = numeroNota;
        this.fecha = fecha;
        this.total = total;
        this.anticipo = anticipo;
        this.cliente = cliente;
        this.empleado = empleado;
        this.departamento = departamento;
        this.detallepedido = detallepedido;
    }
    
    public DTONotaVenta(NotaVenta notaventa){
        this.numeroNota = notaventa.getNumeroNota();
        this.fecha = notaventa.getFecha();
        this.total = notaventa.getTotal();
        this.anticipo = notaventa.getAnticipo().getIdAnticipo();
        this.cliente = notaventa.getCliente().getIdCliente();
        this.empleado = notaventa.getEmpleado().getIdEmpleado();
        this.departamento = notaventa.getDepartamento().getIdDepartamento();
        this.detallepedido = notaventa.getDetallePedido().getIdDetallePedido();
    }

    public Long getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(Long numeroNota) {
        this.numeroNota = numeroNota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(Long anticipo) {
        this.anticipo = anticipo;
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public Long getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Long empleado) {
        this.empleado = empleado;
    }

    public Long getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Long departamento) {
        this.departamento = departamento;
    }

    public Long getDetallepedido() {
        return detallepedido;
    }

    public void setDetallepedido(Long detallepedido) {
        this.detallepedido = detallepedido;
    }
    
}
