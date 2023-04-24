package com.fatec.sig1.model.Build;

import jakarta.persistence.Id;

import com.fatec.sig1.model.Produto.Produto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class ItemBuild {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Preço é requerido")
    private int Quantidade;
    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "build_id", nullable = false)
    private Build build;
    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    public ItemBuild(@NotNull(message = "Preço é requerido") int quantidade, Build build, Produto produto) {
        Quantidade = quantidade;
        this.build = build;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
