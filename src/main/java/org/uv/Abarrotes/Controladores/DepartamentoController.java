package org.uv.Abarrotes.Controladores;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.uv.Abarrotes.DTOs.DTODepartamentos;
import org.uv.Abarrotes.modelos.Departamento;
import org.uv.Abarrotes.servicio.DepartamentoService;

@Repository
@RequestMapping("api/departamento")
@CrossOrigin(origins="*", allowCredentials="")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DTODepartamentos>> obtenerDepartamentos(){
        List<DTODepartamentos> departamentos = departamentoService.obtenerDepartamentos();
        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTODepartamentos> obtenerDepartamentoPorId(@PathVariable Long id){
        DTODepartamentos departamento = departamentoService.obtenerDepartamentoPorId(id);
        return ResponseEntity.ok(departamento);
    }
    
    @GetMapping("/nombre")
    public ResponseEntity<List<DTODepartamentos>> obtenerDepartamentoPorNombre(@RequestParam String nombre){
        List<DTODepartamentos> departamentos = departamentoService.obtenerDepartamentoPorNombre(nombre);
        return ResponseEntity.ok(departamentos);
    }

    @PostMapping
    public ResponseEntity<DTODepartamentos> nuevoDepartamento(@Valid @RequestBody Departamento departamento){
        DTODepartamentos nuevoDepartamento = departamentoService.crearDepartamento(departamento);
        return ResponseEntity.ok(nuevoDepartamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTODepartamentos> actualizarDepartamento(@PathVariable Long id,@Valid @RequestBody Departamento departamento){
        Optional<DTODepartamentos> departamentoActualizado = departamentoService.actualizarDepartamento(id, departamento);
        if (departamentoActualizado.isPresent()) {
            return ResponseEntity.ok(departamentoActualizado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
}
