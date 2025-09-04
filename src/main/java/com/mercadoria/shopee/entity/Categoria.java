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

    public Categoria(UUID id, String nome, String descricao, List<Mercadoria> mercadorias) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.mercadorias = mercadorias;
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

    public List<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    public void setMercadorias(List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }
}
