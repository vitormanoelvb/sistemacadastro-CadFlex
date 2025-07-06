/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.model;

/**
 *
 * @author Vitor
 */
public class ProdutoDigital extends Produto {
    private String formato;

    public ProdutoDigital(int id, String nome, double preco, String formato) {
        super(id, nome, preco);
        this.formato = formato;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }

    @Override
    public String getExtra() {
        return formato;
    }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
}