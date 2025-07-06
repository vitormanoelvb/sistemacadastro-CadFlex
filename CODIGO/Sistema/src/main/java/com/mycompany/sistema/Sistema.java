/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistema;
import com.mycompany.sistema.view.TelaRecomendacoesView;

/**
 *
 * @author Vitor
 */
import javax.swing.SwingUtilities;

public class Sistema {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            TelaRecomendacoesView recomendacoes = new TelaRecomendacoesView();
            recomendacoes.setVisible(true);
        });
    }
}