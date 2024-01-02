/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import java.sql.Date;
import java.sql.Time;
import javax.validation.constraints.NotNull;

import org.uv.Abarrotes.modelos.DetallePedido;

/**
 *
 * @author loken
 */
public class DTODetallePedido {
    
    private Long idDetallePedido;
    @NotNull(message = "La fecha de entrega no puede ser nula")
    private Date fecha;

    @NotNull(message = "La hora de entrega no puede ser nula")
    private Time horaEntrega;

    @NotNull(message = "El estado del pedido no puede ser nulo")
    private String estado;

    public DTODetallePedido(Long idDetallePedido, Date fecha, Time horaEntrega, String estado) {
        this.idDetallePedido = idDetallePedido;
        this.fecha = fecha;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
    }

    public DTODetallePedido() {
    }

    public DTODetallePedido(DetallePedido detallePedido) {
        this.idDetallePedido = detallePedido.getIdDetallePedido();
        this.fecha = detallePedido.getFechaEntrega();
        this.horaEntrega = detallePedido.getHoraEntrega();
        this.estado = detallePedido.getEstadoPedido().getEstado();
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }
}
