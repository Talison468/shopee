package com.mercadoria.shopee.controller;

import com.mercadoria.shopee.DTO.CategoriaCreateDTO;
import com.mercadoria.shopee.DTO.FornecedorCreateDTO;
import com.mercadoria.shopee.entity.Categoria;
import com.mercadoria.shopee.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService service;
    @GetMapping("/{id}")
    public CategoriaCreateDTO findById(@PathVariable("id") UUID id) {return service.findById(id);}

    @GetMapping
    public List<CategoriaCreateDTO> findAll(){return service.findAll();}

    @PostMapping
    public CategoriaCreateDTO save(
            @RequestBody CategoriaCreateDTO categoriaCreateDTO){
        return service.save(categoriaCreateDTO);
    }
    @PutMapping("/{id}")
    public CategoriaCreateDTO update(
            @PathVariable("id")UUID id,
            @RequestBody CategoriaCreateDTO categoriaCreateDTO){
        return service.update(id, categoriaCreateDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") UUID id){service.deleteById(id);}
}
