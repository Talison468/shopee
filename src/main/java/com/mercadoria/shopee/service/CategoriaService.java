package com.mercadoria.shopee.service;

import com.mercadoria.shopee.DTO.CategoriaCreateDTO;
import com.mercadoria.shopee.entity.Categoria;
import com.mercadoria.shopee.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaCreateDTO findById(UUID id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        CategoriaCreateDTO categoriaCreateDTO = convertToDto(categoria);
        return categoriaCreateDTO;
    }
    public CategoriaCreateDTO save(CategoriaCreateDTO categoriaDTO){
        Categoria categoria = convertToEntity(categoriaDTO);
        categoria = categoriaRepository.save(categoria);
        return convertToDto(categoria);
    }
    public CategoriaCreateDTO update(UUID id, CategoriaCreateDTO categoriaCreateDTO){
        Categoria categoria = convertToEntity(categoriaCreateDTO);
        categoria.setId(id);
        categoriaRepository.save(categoria);
        return convertToDto(categoria);
    }
    public void deleteById (UUID id) {categoriaRepository.deleteById(id);}
    public List<CategoriaCreateDTO> findAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaCreateDTO> categoriaCreateDTOS = new ArrayList<>();
        for (Categoria categoria : categorias) {
            categoriaCreateDTOS.add(convertToDto(categoria));
        }
        return categoriaCreateDTOS;
    }
    public CategoriaCreateDTO convertToDto (Categoria categoria){
        CategoriaCreateDTO categoriaCreateDTO = new CategoriaCreateDTO();
        categoriaCreateDTO.setNome(categoria.getNome());
        categoriaCreateDTO.setDescricao(categoria.getDescricao());
        return categoriaCreateDTO;
    }
    public Categoria convertToEntity (CategoriaCreateDTO mercadoriaCreateDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoria.getNome());
        categoria.setDescricao(categoria.getDescricao());
        return categoria;
    }
}
