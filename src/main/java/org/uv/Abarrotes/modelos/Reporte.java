/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.modelos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author loken
 */
@Entity
@Table(name = "Reportes")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportes_id_reporte_seq")
    @SequenceGenerator(name = "reportes_id_reporte_seq", sequenceName = "reportes_id_reporte_seq",
            initialValue = 1, allocationSize = 1)
    @Column(name = "id_reporte")
    private Long idReporte;

    @Column(name = "cve")
    private String cve;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "reporte")
    private List <DetalleReporte> detalleReporte;
    

    public Reporte() {
    }

    public Reporte(Long idReporte, String cve, String descripcion, List<DetalleReporte> detalleReporte) {
        this.idReporte = idReporte;
        this.cve = cve;
        this.descripcion = descripcion;
        this.detalleReporte = detalleReporte;
    }

    public Long getIdReporte() {
        return this.idReporte;
    }

    public void setIdReporte(Long idReporte) {
        this.idReporte = idReporte;
    }

    public String getCve() {
        return this.cve;
    }

    public void setCve(String cve) {
        this.cve= cve;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion= descripcion;
    }

    public List<DetalleReporte> getDetalleReporte() {
        return this.detalleReporte;
    }

    public void setDetalleReporte(List<DetalleReporte> detalleReporte) {
        this.detalleReporte= detalleReporte;
    }

}
