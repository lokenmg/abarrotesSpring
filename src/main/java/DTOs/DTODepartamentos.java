/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import org.uv.Abarrotes.modelos.Departamento;

/**
 *
 * @author loken
 */
public class DTODepartamentos {
    private String nombre;

    public DTODepartamentos(String nombre) {
        this.nombre = nombre;
    }

    public DTODepartamentos() {
    }
    
    public DTODepartamentos(Departamento departamento){
        this.nombre = departamento.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
