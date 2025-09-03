package com.mercadoria.shopee.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categorias")
    private List<Mercadoria> mercadorias;

    public Categoria() {  }

    public Categoria(String descricao, String nome, UUID id) {
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
