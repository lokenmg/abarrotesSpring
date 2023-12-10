/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.sql.Date;
import java.sql.Time;

import org.uv.Abarrotes.modelos.DetallePedido;

/**
 *
 * @author loken
 */
public class DTODetallePedido {
    private Date fecha;
    private Time horaEntrega;
    private String estado;

    public DTODetallePedido(Date fecha, Time horaEntrega, String estado) {
        this.fecha = fecha;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
    }

    public DTODetallePedido() {
    }

    public DTODetallePedido(DetallePedido detallePedido) {
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
}
