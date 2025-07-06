/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.controller;

/**
 *
 * @author Vitor
 */
import com.mycompany.sistema.model.*;

import java.util.List;
import java.text.Normalizer;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        produtoDAO = new ProdutoDAO();
    }

    public Produto buscarProdutoPorId(int id) {
        ProdutoDAO dao = new ProdutoDAO();
        return dao.buscarPorId(id);
    }

    public void incluirProduto(String nome, double preco, String tipo, String extra) {
        Produto produto;

        String tipoNormalizado = Normalizer.normalize(tipo, Normalizer.Form.NFD)
            .replaceAll("[^\\p{ASCII}]", "")
            .toLowerCase();

        if (tipoNormalizado.equals("fisico")) {
            produto = new ProdutoFisico(0, nome, preco, Double.parseDouble(extra));
        } else if (tipoNormalizado.equals("digital")) {
            produto = new ProdutoDigital(0, nome, preco, extra);
        } else {
            throw new IllegalArgumentException("Tipo de produto inválido.");
        }

        produtoDAO.incluir(produto);
    }

    public void alterarProduto(int id, String nome, double preco, String tipo, String extra) {
        Produto produto;

        String tipoNormalizado = Normalizer.normalize(tipo, Normalizer.Form.NFD)
            .replaceAll("[^\\p{ASCII}]", "")
            .toLowerCase();

        if (tipoNormalizado.equals("fisico")) {
            produto = new ProdutoFisico(id, nome, preco, Double.parseDouble(extra));
        } else if (tipoNormalizado.equals("digital")) {
            produto = new ProdutoDigital(id, nome, preco, extra);
        } else {
            throw new IllegalArgumentException("Tipo de produto inválido.");
        }

        produtoDAO.alterar(produto);
    }

    public void excluirProduto(int id) {
        produtoDAO.excluir(id);
    }

    public List<Produto> listarProdutos() {
        return produtoDAO.listarTodos();
    }
}