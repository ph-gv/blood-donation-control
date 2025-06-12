package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoacaoDAO;
import com.mycompany.projeto.ods.dao.HemocentroDAO;
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.model.Hemocentro;
import com.mycompany.projeto.ods.model.Doador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class MinhasDoacoesScreen extends javax.swing.JFrame {

    private final Doador usuario;
    
    public MinhasDoacoesScreen() {
        this.usuario = null;
        initComponents();
        setLocationRelativeTo(null);
        carregaTabela();
    }
    
    public MinhasDoacoesScreen(Doador usuario) {
        this.usuario = Objects.requireNonNull(usuario);
        initComponents();
        setLocationRelativeTo(null);
        carregaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMinhasDoacoes = new javax.swing.JPanel();
        lblTituloMinhasDoacoes = new javax.swing.JLabel();
        scrollDoacoes = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoacoes = new javax.swing.JTable();
        btnVoltarMinhasDoacoes = new javax.swing.JButton();
        btnCancelarDoacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloMinhasDoacoes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTituloMinhasDoacoes.setText("MINHAS DOAÇÕES");

        tblDoacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDoacoes);

        scrollDoacoes.setViewportView(jScrollPane1);

        btnVoltarMinhasDoacoes.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltarMinhasDoacoes.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnVoltarMinhasDoacoes.setText("VOLTAR");
        btnVoltarMinhasDoacoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltarMinhasDoacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarMinhasDoacoesActionPerformed(evt);
            }
        });

        btnCancelarDoacao.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelarDoacao.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnCancelarDoacao.setText("CANCELAR");
        btnCancelarDoacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarDoacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDoacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMinhasDoacoesLayout = new javax.swing.GroupLayout(panMinhasDoacoes);
        panMinhasDoacoes.setLayout(panMinhasDoacoesLayout);
        panMinhasDoacoesLayout.setHorizontalGroup(
            panMinhasDoacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                .addGroup(panMinhasDoacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(scrollDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(lblTituloMinhasDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(btnCancelarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnVoltarMinhasDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panMinhasDoacoesLayout.setVerticalGroup(
            panMinhasDoacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTituloMinhasDoacoes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panMinhasDoacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarDoacao)
                    .addComponent(btnVoltarMinhasDoacoes))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMinhasDoacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMinhasDoacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Carrega os agendamentos do doador logado na tabela tblDoacoes.
     */
    private void carregaTabela() {
        // Configura colunas
        String[] colunas = {"ID", "Hemocentro", "Data", "Horário", "Status"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // impede edição direta
            }
        };

        if (usuario != null) {
            DoacaoDAO dDao = new DoacaoDAO();
            List<Doacao> lista = dDao.listarPorDoador(usuario.getId());

            HemocentroDAO hDao = new HemocentroDAO();
            DateTimeFormatter fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("HH:mm");

            for (Doacao d : lista) {
                Hemocentro h = hDao.buscarPorId(d.getIdLocalColeta());
                Object[] linha = new Object[]{
                    d.getIdDoacao(),
                    (h != null ? h.getNome() : "—"),
                    d.getData().format(fmtData),
                    d.getHorario().format(fmtHora),
                    d.getStatus()
                };
                model.addRow(linha);
            }
        }

        tblDoacoes.setModel(model);
        // Ajusta larguras das colunas
        tblDoacoes.getColumnModel().getColumn(0).setPreferredWidth(50);   // ID
        tblDoacoes.getColumnModel().getColumn(1).setPreferredWidth(200);  // Hemocentro
        tblDoacoes.getColumnModel().getColumn(2).setPreferredWidth(100);  // Data
        tblDoacoes.getColumnModel().getColumn(3).setPreferredWidth(100);  // Horário
        tblDoacoes.getColumnModel().getColumn(4).setPreferredWidth(100);  // Status
    }
    
    private void btnCancelarDoacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDoacaoActionPerformed
        int row = tblDoacoes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(
                this,
                "Selecione um agendamento para cancelar.",
                "Aviso",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }
        int idDoacao = (int) tblDoacoes.getValueAt(row, 0);
        new DoacaoDAO().atualizarStatus(idDoacao, "cancelado");
        JOptionPane.showMessageDialog(
            this,
            "Agendamento cancelado com sucesso.",
            "Sucesso",
            JOptionPane.INFORMATION_MESSAGE
        );
        carregaTabela();
    }//GEN-LAST:event_btnCancelarDoacaoActionPerformed

    private void btnVoltarMinhasDoacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarMinhasDoacoesActionPerformed
        if (usuario != null) {
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            new LoginScreen().setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_btnVoltarMinhasDoacoesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinhasDoacoesScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarDoacao;
    private javax.swing.JButton btnVoltarMinhasDoacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMinhasDoacoes;
    private javax.swing.JPanel panMinhasDoacoes;
    private javax.swing.JScrollPane scrollDoacoes;
    private javax.swing.JTable tblDoacoes;
    // End of variables declaration//GEN-END:variables
}
