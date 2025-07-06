/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sistema;
import com.mycompany.sistema.Mysql;
import com.mycompany.sistema.DashBoardLogin; 

/**
 *
 * @author Vitor
 */
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.SQLException;

/**
 *
 * @author Vitor
 */
import javax.swing.JOptionPane;

public class Registrar extends javax.swing.JPanel {

    private final DashBoardLogin main;

    public Registrar(DashBoardLogin main) {
        initComponents();
        this.main = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblAreaRegistro = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pwdSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        pwdConfirmaSenha = new javax.swing.JPasswordField();
        lblGenero = new javax.swing.JLabel();
        jrbMasculino = new javax.swing.JRadioButton();
        jrbFeminino = new javax.swing.JRadioButton();
        btnRegistrar = new javax.swing.JButton();
        btnJaTem = new javax.swing.JButton();

        setBackground(new java.awt.Color(30, 30, 30));

        lblAreaRegistro.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblAreaRegistro.setForeground(new java.awt.Color(255, 255, 255));
        lblAreaRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAreaRegistro.setText("Area de Registro");

        lblNome.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNome.setPreferredSize(new java.awt.Dimension(0, 50));

        lblEmail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email:");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(0, 50));

        lblSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblSenha.setText("Senha:");

        pwdSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pwdSenha.setPreferredSize(new java.awt.Dimension(0, 50));

        lblConfirmarSenha.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblConfirmarSenha.setForeground(new java.awt.Color(255, 255, 255));
        lblConfirmarSenha.setText("Confirma Senha:");

        pwdConfirmaSenha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pwdConfirmaSenha.setPreferredSize(new java.awt.Dimension(0, 50));

        lblGenero.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        lblGenero.setForeground(new java.awt.Color(255, 255, 255));
        lblGenero.setText("Genero:");

        jrbMasculino.setBackground(new java.awt.Color(30, 30, 30));
        buttonGroup1.add(jrbMasculino);
        jrbMasculino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jrbMasculino.setForeground(new java.awt.Color(255, 255, 255));
        jrbMasculino.setSelected(true);
        jrbMasculino.setText("Masculino");

        jrbFeminino.setBackground(new java.awt.Color(30, 30, 30));
        buttonGroup1.add(jrbFeminino);
        jrbFeminino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jrbFeminino.setForeground(new java.awt.Color(255, 255, 255));
        jrbFeminino.setText("Feminino");

        btnRegistrar.setBackground(new java.awt.Color(204, 102, 0));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Cadastrar-se");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setPreferredSize(new java.awt.Dimension(97, 50));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnJaTem.setBackground(new java.awt.Color(41, 41, 41));
        btnJaTem.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        btnJaTem.setForeground(new java.awt.Color(255, 255, 255));
        btnJaTem.setText("Já tem uma conta? Entrar");
        btnJaTem.setBorderPainted(false);
        btnJaTem.setPreferredSize(new java.awt.Dimension(97, 50));
        btnJaTem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJaTemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(228, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblAreaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                        .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pwdSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pwdConfirmaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnJaTem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbMasculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbFeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(lblAreaRegistro)
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfirmarSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwdConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMasculino)
                    .addComponent(jrbFeminino))
                .addGap(21, 21, 21)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(btnJaTem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        btnRegistrar.setEnabled(false);
        btnRegistrar.setText("Cadastrando...");
         new Thread(() -> {
             register();
             javax.swing.SwingUtilities.invokeLater(() -> {
                 btnRegistrar.setEnabled(true);
                 btnRegistrar.setText("Cadastrar-se");
             });
         }).start();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnJaTemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJaTemActionPerformed
        main.setLogin();
    }//GEN-LAST:event_btnJaTemActionPerformed

    private void register() {
        String name  = txtNome.getText().trim();
        String email = txtEmail.getText().trim();
        String password = new String(pwdSenha.getPassword());
        String confirmPassword = new String(pwdConfirmaSenha.getPassword());
        String gender = jrbMasculino.isSelected() ? "Masculino" : "Feminino";

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nome e necessário");
        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email é necessário");
        } else if (password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Senha é necessária");
        } else if (confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Confirma Senha e necessário");
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "As Senhas não correspondem");
        } else {
            try {
                Connection conn = Mysql.conectar();
                String sql = "INSERT INTO usuarios (nome, email, senha, genero) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, password);
                stmt.setString(4, gender);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Registrado com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                resetInput();      
                main.setLogin();   

                stmt.close();
                conn.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao registrar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetInput() {
        txtNome.setText("");
        txtEmail.setText("");
        pwdSenha.setText("");
        pwdConfirmaSenha.setText("");
        jrbMasculino.setSelected(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJaTem;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jrbFeminino;
    private javax.swing.JRadioButton jrbMasculino;
    private javax.swing.JLabel lblAreaRegistro;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JPasswordField pwdConfirmaSenha;
    private javax.swing.JPasswordField pwdSenha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
