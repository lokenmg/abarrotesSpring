/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import javax.validation.constraints.NotBlank;
import org.uv.Abarrotes.modelos.EstadosPedido;

/**
 *
 * @author loken
 */
public class DTOEstadoPedido {

    private Long idEstadoPedido;
    
    @NotBlank(message = "El estado del pedido no puede estar en blanco")
    private String estado;

    
    public DTOEstadoPedido() {
    }

    public DTOEstadoPedido(EstadosPedido estadosPedido) {
        this.idEstadoPedido = estadosPedido.getIdEstado();
        this.estado = estadosPedido.getEstado();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //get y set de idEstadoPedido
    public Long getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Long idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }
}
