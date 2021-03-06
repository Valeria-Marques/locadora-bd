/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Alterar;

import DAO.CategoriaDAO;
import DAO.ClassificacaoDAO;
import DAO.Conexao;
import DAO.FilmeDAO;
import Modelo.Categoria;
import Modelo.Classificacao;
import Modelo.Filme;
import Principal.Menu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AlterarFilme extends javax.swing.JFrame {

    /**
     * Creates new form AlterarFilme
     */
    public AlterarFilme() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Video Locadora");
        
        AtualizaComboCategoria();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTF_DCodigo = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btLimpar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbCapa = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTF_Cod = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTF_Titulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTF_Ano = new javax.swing.JFormattedTextField();
        jTF_Duracao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCB_Categoria = new javax.swing.JComboBox<>();
        jTF_CodCategoria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTF_CodClassificacao = new javax.swing.JTextField();
        jCB_Classificacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Alterar Filme");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Digite o Código:");

        btOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.jpg"))); // NOI18N
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTF_DCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btOK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTF_DCodigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btLimpar.setText("Limpar");
        btLimpar.setBorder(null);
        btLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.setBorder(null);
        btAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.setBorder(null);
        btCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DVD_VIDEO_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbCapa)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel12.setText("Codigo:");

        jTF_Cod.setEditable(false);

        jLabel5.setText("Titulo:");

        jLabel6.setText("Ano:");

        try {
            jTF_Ano.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Duração:");

        jCB_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caso queira alterar selecione um item..." }));
        jCB_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_CategoriaActionPerformed(evt);
            }
        });

        jTF_CodCategoria.setEditable(false);

        jLabel8.setText("Categoria:");

        jLabel9.setText("Classificação");

        jTF_CodClassificacao.setEditable(false);

        jCB_Classificacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Caso queira alterar selecione um item..." }));
        jCB_Classificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_ClassificacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTF_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTF_CodClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jCB_Classificacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTF_CodCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jCB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTF_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTF_Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_Cod)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTF_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTF_Ano)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTF_Duracao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_CodCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCB_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTF_CodClassificacao)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCB_Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        
        String codigo = jTF_Cod.getText();
        String titulo = jTF_Titulo.getText();
        String ano = jTF_Ano.getText();
        String duracao = jTF_Duracao.getText();
        String codCategoria = jTF_CodCategoria.getText();
        String codClassificacao = jTF_CodClassificacao.getText();
        
        if (codigo.equals("") || titulo.equals("") || ano.equals("") || duracao.equals("") || codCategoria.equals("")
            || codClassificacao.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Nenhum campo pode estar vazio", "Video Locadora", JOptionPane.WARNING_MESSAGE);
            
        } else {
            
            Connection con = (Connection) Conexao.AbrirConexao();
            FilmeDAO sql = new FilmeDAO(con);
            int cod = Integer.parseInt(codigo);
            Filme a = new Filme();
            
            a.setCodigo(cod);
            a.setTitulo(titulo);
            a.setAno(Integer.parseInt(ano));
            a.setDuracao(duracao);
            a.setCodigoCategoria(Integer.parseInt(codCategoria));
            a.setCodigoClassificacao(Integer.parseInt(codClassificacao));
            
            sql.Alterar_Filme(a);
            Conexao.FecharConexao(con);
            
            Limpar();
            
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Video Locadora", JOptionPane.INFORMATION_MESSAGE);
            new Menu().setVisible(true);
            dispose();
            
        }
        
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
  new Menu().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jCB_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_CategoriaActionPerformed

        Connection con = (Connection) Conexao.AbrirConexao();
        CategoriaDAO sql = new CategoriaDAO(con);
        List<Categoria> lista = new ArrayList<>();
        String nome = jCB_Categoria.getSelectedItem().toString();

        lista = sql.ConsultaCodigoCategoria(nome);

        for (Categoria categoria : lista) {

            int a = categoria.getCodigo();
            jTF_CodCategoria.setText(""+a);

        }

    }//GEN-LAST:event_jCB_CategoriaActionPerformed

    private void jCB_ClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_ClassificacaoActionPerformed

        Connection con = (Connection) Conexao.AbrirConexao();
        ClassificacaoDAO sql = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        String nome = jCB_Classificacao.getSelectedItem().toString();

        lista = sql.ConsultaCodigoClassificacao(nome);

        for (Classificacao classificacao : lista) {

            int a = classificacao.getCodigo();
            jTF_CodClassificacao.setText(""+a);

        }

    }//GEN-LAST:event_jCB_ClassificacaoActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        
        String codigo = jTF_DCodigo.getText();
        Connection con = (Connection) Conexao.AbrirConexao();
        FilmeDAO sql = new FilmeDAO(con);
        
        int cod = Integer.parseInt(codigo);
        
        if (sql.Testar_Filme(cod) == false) {
            
            JOptionPane.showMessageDialog(null, "Codigo não Encontrado no Banco", "Video Locadora", JOptionPane.ERROR_MESSAGE);
            Conexao.FecharConexao(con);
            
        }
        
        if (codigo.equals("")) {
            
            JOptionPane.showMessageDialog(null, "Digite um Codigo para Atualizar", "Video Locadora", JOptionPane.ERROR_MESSAGE);
        
        }
        
        Limpar();
        
        InserirDados(cod);
        jTF_DCodigo.setText("");
        
    }//GEN-LAST:event_btOKActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
     
        Limpar();
        
    }//GEN-LAST:event_btLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btOK;
    private javax.swing.JComboBox<String> jCB_Categoria;
    private javax.swing.JComboBox<String> jCB_Classificacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JFormattedTextField jTF_Ano;
    private javax.swing.JTextField jTF_Cod;
    private javax.swing.JTextField jTF_CodCategoria;
    private javax.swing.JTextField jTF_CodClassificacao;
    private javax.swing.JTextField jTF_DCodigo;
    private javax.swing.JTextField jTF_Duracao;
    private javax.swing.JTextField jTF_Titulo;
    private javax.swing.JLabel lbCapa;
    // End of variables declaration//GEN-END:variables

    private void InserirDados(int cod){
        
        //Home
        String home = System.getProperty("user.home");
        
        Connection con = (Connection) Conexao.AbrirConexao();
        FilmeDAO sql = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = sql.CapturarFilme(cod);
        
        for (Filme a : lista) {
            
            jTF_CodCategoria.setText("" + a.getCodigoCategoria());
            jTF_Ano.setText(""+a.getAno());
            jTF_CodClassificacao.setText(""+a.getCodigoClassificacao());
            jTF_Duracao.setText("" + a.getDuracao());
            jTF_Titulo.setText(a.getTitulo());
            jTF_Cod.setText(""+a.getCodigo());
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    public void Limpar(){
        
        jTF_CodCategoria.setText("");
        jTF_Ano.setText("");
        jTF_CodClassificacao.setText("");
        jTF_Duracao.setText("");
        jTF_Titulo.setText("");
        jTF_Cod.setText("");
        jCB_Categoria.setSelectedIndex(0);
        jCB_Classificacao.setSelectedIndex(0);
        
    }
    
    private void AtualizaComboCategoria() {
        
        Connection con = Conexao.AbrirConexao();
        CategoriaDAO sql = new CategoriaDAO(con);
        List<Categoria> lista = new ArrayList<>();
        lista = sql.ListarComboCategoria();
        
        for (Categoria categoria : lista) {
            
            jCB_Categoria.addItem(categoria.getNome());
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
    private void AtualizaComboClassificacao() {
        
        Connection con = Conexao.AbrirConexao();
        ClassificacaoDAO sql = new ClassificacaoDAO(con);
        List<Classificacao> lista = new ArrayList<>();
        lista = sql.ListarComboClassificacao();
        
        for (Classificacao classificacao : lista) {
            
            jCB_Classificacao.addItem(classificacao.getNome());
            
        }
        
        Conexao.FecharConexao(con);
        
    }
}
