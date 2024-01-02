/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Abarrotes.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.uv.Abarrotes.modelos.DetalleReporte;

/**
 *
 * @author loken
 */
public interface DetalleReporteRepository extends JpaRepository<DetalleReporte, Long>{
    @Transactional
    void deleteByReporte_idReporte(Long reporteId);
}
