package com.mercadoria.shopee.DTO;

import com.mercadoria.shopee.entity.Categoria;

public class MercadoriaCreateDTO {
    private String nome;
    private double preco;
    private int quantidade;
    private Categoria categoria;

    public MercadoriaCreateDTO() {}

    public MercadoriaCreateDTO(String nome, double preco, int quantidade, Categoria categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
