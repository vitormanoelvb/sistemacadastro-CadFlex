/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.model;

/**
 *
 * @author Vitor
 */
public class ProdutoFisico extends Produto {
    private double peso;

    public ProdutoFisico(int id, String nome, double preco, double peso) {
        super(id, nome, preco);
        this.peso = peso;
    }

    @Override
    public String getTipo() {
        return "Físico";
    }

    @Override
    public String getExtra() {
        return String.valueOf(peso);
}

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
}