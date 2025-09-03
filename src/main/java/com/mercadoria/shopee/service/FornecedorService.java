package com.mercadoria.shopee.service;

import com.mercadoria.shopee.DTO.FornecedorCreateDTO;
import com.mercadoria.shopee.entity.Fornecedor;
import com.mercadoria.shopee.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorCreateDTO findById(UUID id) {
        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow();
        FornecedorCreateDTO fornecedorCreateDTO = convertToDto(fornecedor);
        return fornecedorCreateDTO;
    }
    public FornecedorCreateDTO save(FornecedorCreateDTO fornecedorDTO){
        Fornecedor fornecedor = convertToEntity(fornecedorDTO);
        fornecedor = fornecedorRepository.save(fornecedor);
        return convertToDto(fornecedor);
    }
    public FornecedorCreateDTO update(UUID id, FornecedorCreateDTO fornecedorCreateDTO){
        Fornecedor fornecedor = convertToEntity(fornecedorCreateDTO);
        fornecedor.setId(id);
        fornecedorRepository.save(fornecedor);
        return convertToDto(fornecedor);
    }
    public void deleteById (UUID id){fornecedorRepository.deleteById(id);}
    public List<FornecedorCreateDTO> findAll() {
        List<Fornecedor> fornecedors = fornecedorRepository.findAll();
        List<FornecedorCreateDTO> fornecedorCreateDTOS = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedors) {
            fornecedorCreateDTOS.add(convertToDto(fornecedor));
        }
        return fornecedorCreateDTOS;
    }
    public FornecedorCreateDTO convertToDto (Fornecedor fornecedor){
        FornecedorCreateDTO fornecedorCreateDTO = new FornecedorCreateDTO();
        fornecedorCreateDTO.setNome(fornecedor.getNome());
        fornecedorCreateDTO.setContato(fornecedor.getContato());
        fornecedorCreateDTO.setEndereco(fornecedor.getEndereco());
        return fornecedorCreateDTO;
    }
    public Fornecedor convertToEntity (FornecedorCreateDTO fornecedorCreateDTO){
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(fornecedorCreateDTO.getNome());
        fornecedor.setContato(fornecedorCreateDTO.getContato());
        fornecedor.setEndereco(fornecedorCreateDTO.getEndereco());
        return fornecedor;
    }
}
