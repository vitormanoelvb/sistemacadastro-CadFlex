/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.model;
import com.mycompany.sistema.Mysql;

/**
 *
 * @author Vitor
 */

import com.mycompany.sistema.Mysql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;

public class ProdutoDAO {

    private String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                         .replaceAll("[^\\p{ASCII}]", "")
                         .toLowerCase();
    }

    public void incluir(Produto produto) {
        String sqlProduto = "INSERT INTO produto (nome, preco, tipo, categoria, observacao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Mysql.conectar();
             PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto, Statement.RETURN_GENERATED_KEYS)) {

            stmtProduto.setString(1, produto.getNome());
            stmtProduto.setDouble(2, produto.getPreco());
            stmtProduto.setString(3, produto.getTipo());
            stmtProduto.setString(4, "");
            stmtProduto.setString(5, "");
            stmtProduto.executeUpdate();

            ResultSet rs = stmtProduto.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                produto.setId(idGerado);

                boolean sucessoSubtabela = true;

                if (produto instanceof ProdutoFisico) {
                    String sqlFisico = "INSERT INTO produto_fisico (id, peso, dimensoes) VALUES (?, ?, ?)";
                    try (PreparedStatement stmtFisico = conn.prepareStatement(sqlFisico)) {
                        stmtFisico.setInt(1, idGerado);
                        stmtFisico.setDouble(2, ((ProdutoFisico) produto).getPeso());
                        stmtFisico.setString(3, "");
                        stmtFisico.executeUpdate();
                    } catch (SQLException e) {
                        sucessoSubtabela = false;
                        System.out.println("❌ Falha ao inserir em produto_fisico: " + e.getMessage());
                    }
                } else if (produto instanceof ProdutoDigital) {
                    String sqlDigital = "INSERT INTO produto_digital (id, tamanho_arquivo_mb, formato) VALUES (?, ?, ?)";
                    try (PreparedStatement stmtDigital = conn.prepareStatement(sqlDigital)) {
                        stmtDigital.setInt(1, idGerado);
                        stmtDigital.setDouble(2, 0.0);
                        stmtDigital.setString(3, ((ProdutoDigital) produto).getFormato());
                        stmtDigital.executeUpdate();
                    } catch (SQLException e) {
                        sucessoSubtabela = false;
                        System.out.println("❌ Falha ao inserir em produto_digital: " + e.getMessage());
                    }
                }

                if (sucessoSubtabela) {
                    System.out.println("✅ Produto inserido com sucesso!");
                } else {
                    System.out.println("⚠ Produto principal inserido, mas sub-tabela falhou.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void alterar(Produto produto) {
        String sqlProduto = "UPDATE produto SET nome = ?, preco = ?, tipo = ? WHERE id = ?";

        try (Connection conn = Mysql.conectar();
             PreparedStatement stmtProduto = conn.prepareStatement(sqlProduto)) {

            stmtProduto.setString(1, produto.getNome());
            stmtProduto.setDouble(2, produto.getPreco());
            stmtProduto.setString(3, produto.getTipo());
            stmtProduto.setInt(4, produto.getId());
            stmtProduto.executeUpdate();

            if (produto instanceof ProdutoFisico) {
                String sql = "UPDATE produto_fisico SET peso = ? WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setDouble(1, ((ProdutoFisico) produto).getPeso());
                    stmt.setInt(2, produto.getId());
                    stmt.executeUpdate();
                }
            } else if (produto instanceof ProdutoDigital) {
                String sql = "UPDATE produto_digital SET formato = ? WHERE id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, ((ProdutoDigital) produto).getFormato());
                    stmt.setInt(2, produto.getId());
                    stmt.executeUpdate();
                }
            }

            System.out.println("Produto alterado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = Mysql.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produto excluído com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conn = Mysql.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String tipo = rs.getString("tipo");

                String tipoNormalizado = normalizar(tipo);

                if (tipoNormalizado.contains("fisic")) {
                    Produto produtoFisico = buscarProdutoFisico(id, nome, preco);
                    return (produtoFisico != null) ? produtoFisico : new ProdutoFisico(id, nome, preco, 0.0);
                } else if (tipoNormalizado.contains("digit")) {
                    Produto produtoDigital = buscarProdutoDigital(id, nome, preco);
                    return (produtoDigital != null) ? produtoDigital : new ProdutoDigital(id, nome, preco, "");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Produto buscarProdutoFisico(int id, String nome, double preco) {
        String sql = "SELECT peso FROM produto_fisico WHERE id = ?";
        try (Connection conn = Mysql.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double peso = rs.getDouble("peso");
                return new ProdutoFisico(id, nome, preco, peso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Produto buscarProdutoDigital(int id, String nome, double preco) {
        String sql = "SELECT formato FROM produto_digital WHERE id = ?";
        try (Connection conn = Mysql.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String formato = rs.getString("formato");
                return new ProdutoDigital(id, nome, preco, formato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection conn = Mysql.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                String tipo = rs.getString("tipo");

                String tipoNormalizado = normalizar(tipo);
                Produto produto = null;

                if (tipoNormalizado.contains("fisic")) {
                    produto = buscarProdutoFisico(id, nome, preco);
                } else if (tipoNormalizado.contains("digit")) {
                    produto = buscarProdutoDigital(id, nome, preco);
                }

                if (produto != null) {
                    lista.add(produto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}