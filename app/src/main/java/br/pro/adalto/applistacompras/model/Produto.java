package br.pro.adalto.applistacompras.model;

/**
 * Created by assparremberger on 23/08/2018.
 */

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(int id, String nome, double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
