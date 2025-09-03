package com.mercadoria.shopee.service;

import com.mercadoria.shopee.DTO.MercadoriaCreateDTO;
import com.mercadoria.shopee.entity.Mercadoria;
import com.mercadoria.shopee.repository.MercadoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MercadoriaService {
    @Autowired
    private MercadoriaRepository mercadoriaRepository;

    public MercadoriaCreateDTO findById(UUID id) {
        Mercadoria mercadoria = mercadoriaRepository.findById(id).orElseThrow();
        MercadoriaCreateDTO mercadoriaCreateDTO = convertToDto(mercadoria);
        return mercadoriaCreateDTO;
    }
    public MercadoriaCreateDTO save(MercadoriaCreateDTO mercadoriaDTO){
        Mercadoria mercadoria = convertToEntity(mercadoriaDTO);
        mercadoria = mercadoriaRepository.save(mercadoria);
        return convertToDto(mercadoria);
    }
    public MercadoriaCreateDTO update(UUID id, MercadoriaCreateDTO mercadoriaCreateDTO){
        Mercadoria mercadoria = convertToEntity(mercadoriaCreateDTO);
        mercadoria.setId(id);
        mercadoriaRepository.save(mercadoria);
        return convertToDto(mercadoria);
    }
    public void deleteById (UUID id){
        mercadoriaRepository.deleteById(id);
    }
    public List<MercadoriaCreateDTO> findAll() {
        List<Mercadoria> mercadorias = mercadoriaRepository.findAll();
        List<MercadoriaCreateDTO> mercadoriaCreateDTOS = new ArrayList<>();
        for (Mercadoria mercadoria : mercadorias) {
            mercadoriaCreateDTOS.add(convertToDto(mercadoria));
        }
    return mercadoriaCreateDTOS;
    }
    public MercadoriaCreateDTO convertToDto (Mercadoria mercadoria){
        MercadoriaCreateDTO mercadoriaCreateDTO = new MercadoriaCreateDTO();
        mercadoriaCreateDTO.setNome(mercadoria.getNome());
        mercadoriaCreateDTO.setPreco(mercadoria.getPreco());
        mercadoriaCreateDTO.setQuantidade(mercadoria.getQuantidade());
        mercadoriaCreateDTO.setCategoria(mercadoria.getCategorias());

        return mercadoriaCreateDTO;
    }
    public Mercadoria convertToEntity (MercadoriaCreateDTO mercadoriaCreateDTO) {
        Mercadoria mercadoria = new Mercadoria();
        mercadoria.setNome(mercadoriaCreateDTO.getNome());
        mercadoria.setPreco(mercadoriaCreateDTO.getPreco());
        mercadoria.setQuantidade(mercadoriaCreateDTO.getQuantidade());
        mercadoria.setCategorias(mercadoriaCreateDTO.getCategoria());
        return mercadoria;
    }
}
