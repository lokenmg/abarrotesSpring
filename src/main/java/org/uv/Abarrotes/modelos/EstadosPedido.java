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

@Entity
@Table(name = "Estados_pedidos")
public class EstadosPedido{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estados_pedidos_id_estado_seq")
    @SequenceGenerator(name = "estados_pedidos_id_estado_seq", sequenceName = "estados_pedidos_id_estado_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "estadoPedido")
    private List<DetallePedido> detallePedido;

    public EstadosPedido() {
    }

    public EstadosPedido(Long idEstado, String estado, List<DetallePedido> detallePedido) {
        this.idEstado = idEstado;
        this.estado = estado;
        this.detallePedido = detallePedido;
    }

    public Long getIdEstado() {
        return this.idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado= estado;
    }

    public List<DetallePedido> getDetallePedido() {
        return this.detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido= detallePedido;
    }
}