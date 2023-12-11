/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import org.uv.Abarrotes.modelos.EstadosPedido;

/**
 *
 * @author loken
 */
public class DTOEstadoPedido {
    
    private String estado;

    public DTOEstadoPedido(String estado) {
        this.estado = estado;
    }

    public DTOEstadoPedido() {
    }

    public DTOEstadoPedido(EstadosPedido estadosPedido) {
        this.estado = estadosPedido.getEstado();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
