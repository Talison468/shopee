package com.mercadoria.shopee.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "mercadoria")
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private int quantidade;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categorias;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedores;

    public Mercadoria() { }

    public Mercadoria(UUID id, String nome, double preco, int quantidade, Categoria categorias, Fornecedor fornecedores) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categorias = categorias;
        this.fornecedores = fornecedores;
    }

    public Categoria getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria categorias) {
        this.categorias = categorias;
    }

    public Fornecedor getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedor fornecedores) {
        this.fornecedores = fornecedores;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
