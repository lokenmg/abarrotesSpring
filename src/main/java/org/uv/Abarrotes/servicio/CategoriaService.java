package org.uv.Abarrotes.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.Categoria;
import org.uv.Abarrotes.repositorio.CategoriaRepository;

import DTOs.DTOCategoria;

/**
 *
 * @author loken
 */
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerCategorias(){
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoriaPorId(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public boolean eliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
        return true;
    }

    public Optional<Categoria> actualizarCategoria(Long id, Categoria categoria){
        if(!categoriaRepository.existsById(id)){
            return null;
        }
        categoria.setIdCategoria(id);
        return Optional.of(categoriaRepository.save(categoria));
    }

    public List<DTOCategoria> buscarCategoriaPorNombre(String nombre){
        List<Categoria> categorias = categoriaRepository.findByNombre(nombre);
        List<DTOCategoria> dtoCategoria = new ArrayList<>();
        for(Categoria cat : categorias){
            dtoCategoria.add(new DTOCategoria(cat));
        }

        return dtoCategoria;
    }
}
