/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTODetalleReporte;
import org.uv.Abarrotes.modelos.DetalleReporte;
import org.uv.Abarrotes.modelos.DetalleVenta;
import org.uv.Abarrotes.modelos.Reporte;
import org.uv.Abarrotes.repositorio.DetalleReporteRepository;

/**
 *
 * @author yacruz
 */
@Service
public class DetalleReporteService {
    @Autowired
    private DetalleReporteRepository detalleReporteRepository;

    @Autowired
    private ReporteService reporteService;

    @Autowired
    private DetalleVentaService detalleVentaService;

//    public DetalleReporte guardarDetalleReporte(DTODetalleReporte detalleReporteDTO) {
//        Reporte reporte = reporteService.obtenerReportePorId(detalleReporteDTO.getIdReporte());
//        DetalleVenta detalleVenta = detalleVentaService.obtenerDetalleVentaPorId(detalleReporteDTO.getIdDetalleVenta());
//
//        DetalleReporte detalleReporte = new DetalleReporte();
//        detalleReporte.setTotal(detalleReporteDTO.getTotal());
//        detalleReporte.setReporte(reporte);
//        detalleReporte.setDetalleVenta(detalleVenta);
//
//        return detalleReporteRepository.save(detalleReporte);
//    }
}
