/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locacao;

import DAO.AluguelDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import Modelo.Aluguel;
import Modelo.Cliente;
import Modelo.Listar;
import Principal.Menu;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ConsultaDevolucao extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaDevolucao
     */
    public ConsultaDevolucao() {
        initComponents();
        setTitle("Video Locadora");
        setLocationRelativeTo(this);
        
        AtualizaCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jCB_Nome = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jTF_Codigo = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("Cliente:");

        jCB_Nome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um cliente..." }));
        jCB_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_NomeActionPerformed(evt);
            }
        });

        jTable.setBackground(new java.awt.Color(240, 240, 240));
        jTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Cliente", "DVD", "Horario", "Locação", "Devolução"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jTF_Codigo.setEditable(false);

        jButton10.setText("Cancelar");
        jButton10.setBorder(null);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jTF_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCB_Nome, 0, 403, Short.MAX_VALUE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCB_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTF_Codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCB_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_NomeActionPerformed
        
        Connection con = (Connection) Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO((com.mysql.jdbc.Connection) con);
        List<Cliente> lista = new ArrayList<Cliente>();
        String nome = jCB_Nome.getSelectedItem().toString();
        
        lista = sql.ConsultaCodigoCliente(nome);
        
        if (jCB_Nome.getSelectedIndex() ==  0) {
            jTF_Codigo.setText("");
        }
        
        for (Cliente b : lista) {
            int a = b.getCodigo();
            jTF_Codigo.setText(""+a);
        }
        
        AluguelDAO sqlAlu = new AluguelDAO((com.mysql.jdbc.Connection) con);
        List<Aluguel> listaAlu = new ArrayList<Aluguel>();
        
        if (jCB_Nome.getSelectedIndex() !=  0) {
            
            AluguelDAO bd = new AluguelDAO(con);
            List<Aluguel> listaALU = new ArrayList<>();
            listaALU = bd.Pesquisar_Cod_Cliente(Integer.parseInt(jTF_Codigo.getText()));
            DefaultTableModel tbm = (DefaultTableModel) jTable.getModel();

            while (tbm.getRowCount() > 0) {            
                tbm.removeRow(0);
            }

            int i = 0;
            for (Aluguel tab : listaALU) {
                tbm.addRow(new String[i]);
                jTable.setValueAt(tab.getCod(), i, 0);
                jTable.setValueAt(tab.getCodcliente(), i, 1);
                jTable.setValueAt(tab.getCoddvd(), i, 2);
                jTable.setValueAt(tab.getHorario(), i, 3);
                jTable.setValueAt(tab.getDataAluguel(), i, 4);
                jTable.setValueAt(tab.getDataDevolucao(), i, 5);
                i++;
            }
            
        }
        
        Conexao.FecharConexao(con);
        
    }//GEN-LAST:event_jCB_NomeActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        
        Integer linha = jTable.getSelectedRow();
        Integer idalugue = (Integer) jTable.getValueAt(linha, 0);
        Integer idcliente = (Integer) jTable.getValueAt(linha, 1);
        Integer iddvd = (Integer) jTable.getValueAt(linha, 2);
        String hora = (String) jTable.getValueAt(linha, 3);
        String dataLocacao = (String) jTable.getValueAt(linha, 4);
        String dataDevolucao = (String) jTable.getValueAt(linha, 5);
        
        Listar a = new Listar();
        
        a.setCodigo(iddvd);
        a.setCodaluguel(idalugue);
        a.setCodcliente(idcliente);
        
        a.setHora(hora);
        a.setDataLocacao(dataLocacao);
        a.setDataDevolucao(dataDevolucao);
        
        new EfetuarDevolucao().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
new Menu().setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JComboBox<String> jCB_Nome;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_Codigo;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

    private void AtualizaCombo() {
        
        Connection con = (Connection) Conexao.AbrirConexao();
        ClienteDAO sql = new ClienteDAO((com.mysql.jdbc.Connection) con);
        List<Cliente> lista = new ArrayList<Cliente>();
        lista = sql.ListarComboCliente();
        //jCB_Nome.addItem("");
        
        for (Cliente b : lista) {
            
            jCB_Nome.addItem(b.getNome());
            
        }
        
        Conexao.FecharConexao(con);
        
    }
    
}
