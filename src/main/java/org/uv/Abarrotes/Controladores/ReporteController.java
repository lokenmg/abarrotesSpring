/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.Controladores;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.DTOs.DTOReporte;
import org.uv.Abarrotes.modelos.Reporte;
import org.uv.Abarrotes.servicio.ReporteService;
/**
 *
 * @author yacruz
 */
@Controller
@RequestMapping("api/reportes")
@CrossOrigin(origins="*", allowCredentials="")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;
    
//    @PostMapping
//    public ResponseEntity<org.uv.Abarrotes.DTOs.DTOReporte> crearReporteConEntidades(@Valid @RequestBody Reporte nuevoReporte) {
//        org.uv.Abarrotes.DTOs.DTOReporte reporteCreado = reporteService.crearReporte(nuevoReporte);
//        return ResponseEntity.status(HttpStatus.CREATED).body(reporteCreado);
//    }

    @GetMapping
    public ResponseEntity<List<DTOReporte>> obtenerReporte(){
        List<DTOReporte> reporte = reporteService.obtenerReporte();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTOReporte> obtenerReportePorId(@PathVariable Long id){
        DTOReporte reporte = reporteService.obtenerReportePorId(id);
        return ResponseEntity.ok(reporte);
    }
    
//    @PutMapping("/{id}")
//    public ResponseEntity<DTOReporte> actualizarReporte(@PathVariable Long id, @Valid @RequestBody Reporte reporteActualizado) {
//        DTOReporte reporte = reporteService.modificarReporte(reporteActualizado, id);
//        return ResponseEntity.ok(reporte);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReporte(@PathVariable Long id) {
        reporteService.eliminarReporte(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byCve/{cve}")
    public ResponseEntity<List<DTOReporte>> getReporteByCve(@PathVariable String cve) {
        List<Reporte> reportes = reporteService.obtenerReportePorCve(cve);
        List<DTOReporte> reportesDTO = new ArrayList<>();
        for (Reporte reporte : reportes) {
            reportesDTO.add(new DTOReporte(reporte));
        }
        return ResponseEntity.ok(reportesDTO);
    }
}
