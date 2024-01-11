package org.uv.Abarrotes.DTOs.Entradas;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.sql.Date;
import javax.validation.constraints.NotNull;

public class DTOCrearReporte {
    
    private String cve;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;

    public DTOCrearReporte() {
    }

    public DTOCrearReporte(String cve, String descripcion, Date fechaInicio, Date fechaFin) {
        this.cve = cve;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @NotBlank(message = "La cve del reporte no puede estar en blanco")
    @Size(max = 30, message = "La cve del reporte no puede tener más de 30 caracteres")
    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    @NotBlank(message = "La descripcion del reporte no puede estar en blanco")
    @Size(max = 150, message = "La descripcion del reporte no puede tener más de 150 caracteres")
    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @NotNull(message = "La fecha de inicio no puede ser nula")
    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @NotNull(message = "La fecha de fin no puede ser nula")
    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
