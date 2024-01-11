/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.DTOs;

import org.uv.Abarrotes.modelos.DetalleReporte;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import org.uv.Abarrotes.modelos.Reporte;

/**
 *
 * @author yacruz
 */
public class DTOReporte {
    private Long idReporte;

    private String cve;

    private String descripcion;

    private List<DTODetalleReporte> DTOdetalleReporte;

    public DTOReporte() {
        
    }
    
    public DTOReporte(Long idReporte, String cve, String descripcion , List<DTODetalleReporte> DTOdetalleReporte) {
        this.idReporte = idReporte;
        this.cve = cve;
        this.descripcion = descripcion;
        this.DTOdetalleReporte = DTOdetalleReporte;
    }
    
    public DTOReporte(Reporte reporte) {
        this.idReporte = reporte.getIdReporte();
        this.cve = reporte.getCve();
        this.descripcion = reporte.getDescripcion();
        this.DTOdetalleReporte = obtenerDetalleReporte(reporte.getDetalleReporte());
    }
    

    public Long getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
    }

    @NotBlank(message = "La cve del reporte no puede estar en blanco")
    @Size(max = 30, message = "La cve del reporte no puede tener más de 30 caracteres")
    public String getCve() {
        return cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @NotBlank(message = "La descripcion del reporte no puede estar en blanco")
    @Size(max = 150, message = "La descripcion del reporte no puede tener más de 150 caracteres")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DTODetalleReporte> getDTODetalleReporte() {
        return DTOdetalleReporte;
    }

    public void setDTODetalleReporte(List<DTODetalleReporte> DTOdetalleReporte) {
        this.DTOdetalleReporte = DTOdetalleReporte;
    }
    
    private List<DTODetalleReporte> obtenerDetalleReporte(List<DetalleReporte> detalleReporte){
        List<DTODetalleReporte> DTOdetalleReporte = new ArrayList<>();
        for (DetalleReporte detalleReporte1 : detalleReporte) {
            DTODetalleReporte dto = new DTODetalleReporte(detalleReporte1);
            DTOdetalleReporte.add(dto);
        }
        return DTOdetalleReporte;
    };
}
