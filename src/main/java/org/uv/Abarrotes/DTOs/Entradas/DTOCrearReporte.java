package org.uv.Abarrotes.DTOs.Entradas;

import java.sql.Date;

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

    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve = cve;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
