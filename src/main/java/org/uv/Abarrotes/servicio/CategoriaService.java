package org.uv.Abarrotes.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uv.Abarrotes.modelos.Categoria;
import org.uv.Abarrotes.repositorio.CategoriaRepository;

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
        if(!categoriaRepository.existsById(id)){
            return false;
        }
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
}
