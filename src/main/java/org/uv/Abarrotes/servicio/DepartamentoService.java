package org.uv.Abarrotes.servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.repositorio.DepartamentoRepository;
import org.uv.Abarrotes.DTOs.DTODepartamentos;
import org.uv.Abarrotes.modelos.Departamento;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    //obtener todos los departamentos
    public List<DTODepartamentos> obtenerDepartamentos(){
        List<Departamento> departamentos = departamentoRepository.findAll();
        List<DTODepartamentos> dtoDepartamentos = new ArrayList<>();
        for(Departamento departamento : departamentos){
            dtoDepartamentos.add(new DTODepartamentos(departamento));
        }
        return dtoDepartamentos;
    }

    public DTODepartamentos obtenerDepartamentoPorId(Long id){
        Departamento departamento = departamentoRepository.findById(id).orElse(null);
        return new DTODepartamentos(departamento);
    }

    //obtener departamento por nombre
    public List<DTODepartamentos> obtenerDepartamentoPorNombre(String nombre){

        List<Departamento> departamentos = departamentoRepository.findByNombreContainingIgnoreCase(nombre);
        List<DTODepartamentos> dtoDepartamentos = new ArrayList<>();
        for(Departamento departamento : departamentos){
            dtoDepartamentos.add(new DTODepartamentos(departamento));
        }
        return dtoDepartamentos;
    }

    //crear departamento
    public DTODepartamentos crearDepartamento(Departamento departamento){
        Departamento nuevoDepartamento = departamentoRepository.save(departamento);
        return new DTODepartamentos(nuevoDepartamento);
    }

    //actualizar departamento
    public Optional<DTODepartamentos>actualizarDepartamento(Long id, Departamento departamento){
        if(!departamentoRepository.existsById(id)){
            return Optional.empty();
        }
        departamento.setIdDepartamento(id);
        return Optional.of(new DTODepartamentos(departamentoRepository.save(departamento)));
    }

    /*
    public Optional<Marca> actualizarMarca(Long id, Marca marca){
        if(!marcaRepository.existsById(id)){
            return Optional.empty();
        }
        marca.setIdMarca(id);
        return Optional.of(marcaRepository.save(marca));
    }
     */
    
}
