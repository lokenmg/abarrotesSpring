package org.uv.Abarrotes.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.Abarrotes.DTOs.DTODetalleReporte;
import org.uv.Abarrotes.servicio.DetalleReporteService;

@RestController
@RequestMapping("api/detallereportes")
public class DetalleReporteController {
    @Autowired
    private DetalleReporteService detalleReporteService;


    @DeleteMapping("/{id}")
    public ResponseEntity<String> borraDetalleReporte(Long id) {
        detalleReporteService.borraDetalleReporte(id);
        try {
            return ResponseEntity.ok("Detalle de reporte eliminado con éxito");
        } catch (Exception e) {
            return ResponseEntity.ok("Error al eliminar detalle de reporte");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTODetalleReporte> obtenerDetalleReportePorId(Long id) {
        DTODetalleReporte detalle= new DTODetalleReporte(detalleReporteService.obtenerDetalleReportePorId(id));
        return ResponseEntity.ok(detalle);
    }


}
