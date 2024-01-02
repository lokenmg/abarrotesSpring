/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.DTOs.DTOReporte;
import org.uv.Abarrotes.modelos.Reporte;
import org.uv.Abarrotes.repositorio.ReporteRepository;

/**
 *
 * @author yacruz
 */
@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;
    
    public DTOReporte crearReporte(@Valid Reporte reporte) {
        
        Reporte reporteG = reporteRepository.save(reporte);
        org.uv.Abarrotes.DTOs.DTOReporte dto = new DTOReporte(reporteG);
        
        return dto;
    }

    public List<DTOReporte> obtenerReporte() {
        List<Reporte> reportes = reporteRepository.findAll();
        List<DTOReporte> dto = new ArrayList<>();
        for (Reporte reporte : reportes) {
            dto.add(new DTOReporte(reporte));
        }
        return dto;
    }

    public DTOReporte obtenerReportePorId(long codigo) {
        Reporte reporte = reporteRepository.findById(codigo)
                .orElseThrow(() -> new EntityNotFoundException("Reporte no encontrado"));

        DTOReporte dto = new DTOReporte(reporte);

        return dto;
    }

    public DTOReporte modificarReporte(@Valid Reporte reporte, long codigo){
        Reporte reporteExistente=reporteRepository.findById(reporte.getIdReporte())
                .orElseThrow(()-> new EntityNotFoundException("Reporte no encontrado"));
        
        reporteExistente.setCve(reporte.getCve());
        reporteExistente.setDescripcion(reporte.getDescripcion());

        DTOReporte dto = new DTOReporte(reporteRepository.save(reporteExistente));
        return dto;
    }
    
    public void eliminarReporte(Long idReporte) {
        Reporte reporteExistente = reporteRepository.findById(idReporte)
                .orElseThrow(() -> new EntityNotFoundException("Reporte no encontrado"));

        // Delete the employee
        reporteRepository.delete(reporteExistente);
    }

    public List<Reporte> obtenerReportePorCve(String cve) {
        List<Reporte> reportes = reporteRepository.findByCve(cve);
        return reportes;
    }
}
