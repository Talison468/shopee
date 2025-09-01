package com.mercadoria.shopee.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mercadoria")
public class Mercadoria {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO,generator="UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false)
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categorias;

    public Mercadoria() { }

    public Mercadoria(UUID id, String nome, double preco, int quantidade, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
