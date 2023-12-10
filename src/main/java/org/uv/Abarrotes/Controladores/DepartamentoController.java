package org.uv.Abarrotes.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.uv.Abarrotes.servicio.DepartamentoService;

import DTOs.DTODepartamentos;

@Repository
@RequestMapping("api/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DTODepartamentos> obtenerDepartamentos(){
        return departamentoService.obtenerDepartamentos();
    }

    /*@GetMapping("/nombre")
    public DTODepartamentos obtenerDepartamentoPorNombre(@String nombre){
        return departamentoService.obtenerDepartamentoPorNombre(nombre);
    }
    */
    
    
}
