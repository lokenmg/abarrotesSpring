/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.DetalleReporte;
import org.uv.Abarrotes.repositorio.DetalleReporteRepository;

/**
 *
 * @author yacruz
 */
@Service
public class DetalleReporteService {
    @Autowired
    private DetalleReporteRepository detalleReporteRepository;

    public void borraDetalleReporte(Long id) {
        DetalleReporte detalleReporte = detalleReporteRepository.findById(id).orElse(null);
        if (detalleReporte == null) {
            detalleReporteRepository.deleteById(id);
        }
        
    }

    public DetalleReporte obtenerDetalleReportePorId(Long id) {
        return detalleReporteRepository.findById(id).orElse(null);
    }

    public void borrarDetalleReportePorReporteId(Long reporteId) {
        detalleReporteRepository.deleteByReporte_idReporte(reporteId);
    }
}
