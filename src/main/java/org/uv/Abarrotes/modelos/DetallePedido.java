/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Time;
import java.sql.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Detalle_pedido")
public class DetallePedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalle_pedido_id_detalle_pedido_seq")
    @SequenceGenerator(name = "detalle_pedido_id_detalle_pedido_seq", sequenceName = "detalle_pedido_id_detalle_pedido_seq",
                allocationSize = 1, initialValue = 1)
    @Column(name = "id_detalle_pedido")
    private Long idDetallePedido;

    @NotNull(message = "La fecha de entrega no puede ser nula")
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @NotNull(message = "La hora de entrega no puede ser nula")
    @Column(name = "hora_entrega")
    private Time horaEntrega;

    @Column(name = "fecha_recoger")
    @JsonIgnore
    private Date fechaRecoger;

    @Column(name = "hora_recoger")
    @JsonIgnore
    private Time horaRecoger;

    @NotNull(message = "El estado del pedido no puede ser nulo")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado")
    private EstadosPedido estadoPedido;
    
    @OneToMany(mappedBy = "detallePedido")
    private List<NotaVenta> notaVentas;

    public DetallePedido(Long idDetallePedido, Date fechaEntrega, Time horaEntrega, Date fechaRecoger, Time horaRecoger, EstadosPedido estadoPedido, List<NotaVenta> notaVentas) {
        this.idDetallePedido = idDetallePedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.fechaRecoger = fechaRecoger;
        this.horaRecoger = horaRecoger;
        this.estadoPedido = estadoPedido;
        this.notaVentas = notaVentas;
    }

    public DetallePedido() {
        // Establecer valores predeterminados para fechaRecoger y horaRecoger
        this.fechaRecoger = new java.sql.Date(System.currentTimeMillis()); // Fecha actual como valor predeterminado
        this.horaRecoger = Time.valueOf("12:00:00"); // 12:00 PM como valor predeterminado
    }


    public Long getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Long idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public Date getFechaRecoger() {
        return fechaRecoger;
    }

    public void setFechaRecoger(Date fechaRecoger) {
        this.fechaRecoger = fechaRecoger;
    }
    
    public Time getHoraRecoger() {
        return horaRecoger;
    }

    public void setHoraRecoger(Time horaRecoger) {
        this.horaRecoger = horaRecoger;
    }

    public EstadosPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadosPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<NotaVenta> getNotaVentas() {
        return notaVentas;
    }

    public void setNotaVentas(List<NotaVenta> notaVentas) {
        this.notaVentas = notaVentas;
    }
}
