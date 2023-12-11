/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Abarrotes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.Abarrotes.modelos.Departamento;

/**
 *
 * @author loken
 */
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    
    List<Departamento> findByNombreContainingIgnoreCase(String nombre);
}
