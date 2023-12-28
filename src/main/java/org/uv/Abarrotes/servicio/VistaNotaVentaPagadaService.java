/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.VistaNotaVentaPagada;

import java.util.List;

import org.uv.Abarrotes.repositorio.VistaNotaVentaPagadaRepository;
/**
 *
 * @author yacruz
 */
@Service
public class VistaNotaVentaPagadaService {
    @Autowired
    private VistaNotaVentaPagadaRepository vistaNotaVentaPagadaRepository;

    public List<VistaNotaVentaPagada> getAllVistaNotaVentaPagada() {
        return vistaNotaVentaPagadaRepository.findAll();
    }
}
