/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.Abarrotes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uv.Abarrotes.modelos.Empleado;
/**
 *
 * @author loken
 */
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
    Empleado findByNombre(String nombre);

    List<Empleado> findByNombreAndApellidos(String nombre, String apellidos);

    List<Empleado> findByApellidos(String apellidos);
}