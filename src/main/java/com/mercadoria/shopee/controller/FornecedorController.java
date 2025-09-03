package com.mercadoria.shopee.controller;
import com.mercadoria.shopee.DTO.FornecedorCreateDTO;
import com.mercadoria.shopee.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/fornecedor")
public class FornecedorController {
    @Autowired
    FornecedorService service;
    @GetMapping("/{id}")
    public FornecedorCreateDTO findById(@PathVariable("id") UUID id) {return service.findById(id);}

    @GetMapping
    public List<FornecedorCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public FornecedorCreateDTO save(
            @RequestBody FornecedorCreateDTO fornecedorCreateDTO ){
        return service.save(fornecedorCreateDTO);
    }
    @PutMapping("/{id}")
    public FornecedorCreateDTO update(
            @PathVariable("id") UUID id,
            @RequestBody FornecedorCreateDTO fornecedorCreateDTO){
        return service.update(id,fornecedorCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")UUID id){service.deleteById(id);}
}
