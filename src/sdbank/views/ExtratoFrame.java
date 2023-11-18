/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sdbank.views;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import sdbank.controllers.ClienteController;
import sdbank.models.Cliente;


public class ExtratoFrame extends javax.swing.JFrame {

    
    public ExtratoFrame(ClienteController controller, Cliente cliente) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.controller = controller;
        lbCPF.setText(String.valueOf( cliente.getCpf()));        
        lbNome.setText(cliente.getNome());
    }

  

    public JLabel getLbCPF() {
        return lbCPF;
    }

    public void setLbCPF(JLabel lbCPF) {
        this.lbCPF = lbCPF;
    }

    public JLabel getLbNome() {
        return lbNome;
    }

    public void setLbNome(JLabel lbNome) {
        this.lbNome = lbNome;
    }

    public JTable getTableExtrato() {
        return tableExtrato;
    }

    public void setTableExtrato(JTable tableExtrato) {
        this.tableExtrato = tableExtrato;
    }

    public JComboBox<String> getComboTipo() {
        return comboTipo;
    }

    public void setComboTipo(JComboBox<String> comboTipo) {
        this.comboTipo = comboTipo;
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableExtrato = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbCPF1 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lbCPF2 = new javax.swing.JLabel();
        lbCPF3 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbCPF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbLogo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogo.setText("S&D Bank");
        lbLogo.setToolTipText("");

        tableExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Transação", "Valor", "Tarifa", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tableExtrato);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONTAS");

        lbCPF1.setText("Conta");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conta Corrente", "Conta Poupança", "Conta Salário" }));
        comboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoActionPerformed(evt);
            }
        });

        jButton1.setText("EXIBIR EXTRATO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbCPF2.setText("CPF:");

        lbCPF3.setText("Nome:");

        lbNome.setText("x");

        lbCPF.setText("x");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(lbLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbCPF1)
                            .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbCPF2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCPF))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lbCPF3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbNome))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPF3)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCPF2)
                    .addComponent(lbCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCPF1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbLogo)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.extrato();
    }//GEN-LAST:event_jButton1ActionPerformed

  
  
    private final ClienteController controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCPF1;
    private javax.swing.JLabel lbCPF2;
    private javax.swing.JLabel lbCPF3;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbNome;
    private javax.swing.JTable tableExtrato;
    // End of variables declaration//GEN-END:variables
}
