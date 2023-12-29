/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Abarrotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.Abarrotes.modelos.DetalleVenta;

import java.sql.Date;
import java.util.List;
/**
 *
 * @author loken
 */
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long>{
    List<DetalleVenta> findByFechaBetween(Date startDate, Date endDate);
}
