/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
/**
 *
 * @author loken
 */
@Entity
@Table(name = "Estado_pago")
public class EstadoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_pago_id_estado_pago_seq")
    @SequenceGenerator(name = "estado_pago_id_estado_pago_seq", sequenceName = "estado_pago_id_estado_pago_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_estado_pago")
    private Long idEstadoPago;

    @NotBlank(message = "El estado del pago no puede estar en blanco")
    @Column(name = "estado")
    private String estado;
    
    @OneToMany(mappedBy = "estadoPago")
    private List<Anticipo> anticipo;

    public EstadoPago(Long idEstadoPago, String estado, List<Anticipo> anticipo) {
        this.idEstadoPago = idEstadoPago;
        this.estado = estado;
        this.anticipo = anticipo;
    }

    public EstadoPago() {
    }

    public Long getIdEstadoPago() {
        return idEstadoPago;
    }

    public void setIdEstadoPago(Long idEstadoPago) {
        this.idEstadoPago = idEstadoPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Anticipo> getAnticipo() {
        return anticipo;
    }

    public void setAnticipo(List<Anticipo> anticipo) {
        this.anticipo = anticipo;
    }
    
   
    

}
