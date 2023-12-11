/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import org.uv.Abarrotes.modelos.UnidadMedida;

/**
 *
 * @author loken
 */
public class DTOUnidadMedida {
    private String nombre;

    public DTOUnidadMedida(String nombre) {
        this.nombre = nombre;
    }

    public DTOUnidadMedida(UnidadMedida unidadMedida) {
        this.nombre = unidadMedida.getNombre();
    }

    public DTOUnidadMedida() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
