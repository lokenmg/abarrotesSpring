/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.Abarrotes.servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.uv.Abarrotes.modelos.VistaNotaVentaPedidoEnProceso;
import org.uv.Abarrotes.repositorio.VistaNotaVentaPedidoEnProcesoRepository;
/**
 *
 * @author yacruz
 */
@Service
public class VistaNotaVentaPedidoEnProcesoService {
    @Autowired
    private VistaNotaVentaPedidoEnProcesoRepository vistaNotaVentaPedidoEnProcesoRepository;

    public List<VistaNotaVentaPedidoEnProceso> getAllVistaNotaVentaPedidoEnProceso() {
        return vistaNotaVentaPedidoEnProcesoRepository.findAll();
    }
}
