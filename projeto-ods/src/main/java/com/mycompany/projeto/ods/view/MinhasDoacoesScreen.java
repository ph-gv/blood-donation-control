package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoacaoDAO;
import com.mycompany.projeto.ods.dao.HemocentroDAO;
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.model.Hemocentro;
import com.mycompany.projeto.ods.model.Doador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class MinhasDoacoesScreen extends javax.swing.JFrame {

    private final Doador usuario;
    private List<Doacao> listaDoacoes;

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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMinhasDoacoes = new javax.swing.JPanel();
        lblTituloMinhasDoacoes = new javax.swing.JLabel();
        scrollDoacoes = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoacoes = new javax.swing.JTable();
        btnVoltarMinhasDoacoes = new javax.swing.JButton();
        btnCancelarDoacao = new javax.swing.JButton();
        btnEditarDoacao = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panMinhasDoacoes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTituloMinhasDoacoes.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblTituloMinhasDoacoes.setText("MINHAS DOAÇÕES");

        tblDoacoes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { {}, {}, {}, {} },
                new String[] {}));
        jScrollPane1.setViewportView(tblDoacoes);
        scrollDoacoes.setViewportView(jScrollPane1);

        btnVoltarMinhasDoacoes.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltarMinhasDoacoes.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnVoltarMinhasDoacoes.setText("VOLTAR");
        btnVoltarMinhasDoacoes
                .setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltarMinhasDoacoes.addActionListener(evt -> btnVoltarMinhasDoacoesActionPerformed(evt));

        btnCancelarDoacao.setBackground(new java.awt.Color(192, 57, 43));
        btnCancelarDoacao.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnCancelarDoacao.setText("CANCELAR");
        btnCancelarDoacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarDoacao.addActionListener(evt -> btnCancelarDoacaoActionPerformed(evt));

        btnEditarDoacao.setBackground(new java.awt.Color(46, 139, 87));
        btnEditarDoacao.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnEditarDoacao.setText("EDITAR");
        btnEditarDoacao.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarDoacao.addActionListener(evt -> btnEditarDoacaoActionPerformed());

        javax.swing.GroupLayout panMinhasDoacoesLayout = new javax.swing.GroupLayout(panMinhasDoacoes);
        panMinhasDoacoes.setLayout(panMinhasDoacoesLayout);
        panMinhasDoacoesLayout.setHorizontalGroup(
                panMinhasDoacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                                .addGroup(panMinhasDoacoesLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(scrollDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                                                .addGap(187, 187, 187)
                                                .addComponent(lblTituloMinhasDoacoes,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 130,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(btnEditarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(btnCancelarDoacao, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(btnVoltarMinhasDoacoes,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 90,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(10, Short.MAX_VALUE)));
        panMinhasDoacoesLayout.setVerticalGroup(
                panMinhasDoacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panMinhasDoacoesLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblTituloMinhasDoacoes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 210,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panMinhasDoacoesLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnEditarDoacao)
                                        .addComponent(btnCancelarDoacao)
                                        .addComponent(btnVoltarMinhasDoacoes))
                                .addContainerGap(11, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panMinhasDoacoes, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panMinhasDoacoes, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregaTabela() {
        String[] colunas = { "ID", "Hemocentro", "Data", "Horário", "Status" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        if (usuario != null) {
            DoacaoDAO dDao = new DoacaoDAO();
            listaDoacoes = dDao.listarPorDoador(usuario.getId());

            HemocentroDAO hDao = new HemocentroDAO();
            DateTimeFormatter fmtData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter fmtHora = DateTimeFormatter.ofPattern("HH:mm");

            for (Doacao d : listaDoacoes) {
                Hemocentro h = hDao.buscarPorId(d.getIdLocalColeta());
                model.addRow(new Object[] {
                        d.getIdDoacao(),
                        (h != null ? h.getNome() : "—"),
                        d.getData().format(fmtData),
                        d.getHorario().format(fmtHora),
                        d.getStatus()
                });
            }
        }

        tblDoacoes.setModel(model);
        tblDoacoes.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblDoacoes.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDoacoes.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblDoacoes.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblDoacoes.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void btnEditarDoacaoActionPerformed() {
        int row = tblDoacoes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para editar.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String status = (String) tblDoacoes.getValueAt(row, 4);
        if (!"agendado".equals(status)) {
            JOptionPane.showMessageDialog(this, "Só é possível editar agendamentos com status 'agendado'.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Doacao selecionada = listaDoacoes.get(row);
        new EditarAgendamentoScreen(usuario, selecionada).setVisible(true);
        this.dispose();
    }

    private void btnCancelarDoacaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelarDoacaoActionPerformed
        int row = tblDoacoes.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um agendamento para cancelar.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String status = (String) tblDoacoes.getValueAt(row, 4);
        if (!"agendado".equals(status)) {
            JOptionPane.showMessageDialog(this, "Este agendamento já foi cancelado ou realizado.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar este agendamento?",
                "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            int idDoacao = (int) tblDoacoes.getValueAt(row, 0);
            new DoacaoDAO().atualizarStatus(idDoacao, "cancelado");
            JOptionPane.showMessageDialog(this, "Agendamento cancelado com sucesso.", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            carregaTabela();
        }
    }// GEN-LAST:event_btnCancelarDoacaoActionPerformed

    private void btnVoltarMinhasDoacoesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVoltarMinhasDoacoesActionPerformed
        if (usuario != null) {
            new MenuPrincipal(usuario).setVisible(true);
        } else {
            new LoginScreen().setVisible(true);
        }
        this.dispose();
    }// GEN-LAST:event_btnVoltarMinhasDoacoesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MinhasDoacoesScreen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarDoacao;
    private javax.swing.JButton btnEditarDoacao;
    private javax.swing.JButton btnVoltarMinhasDoacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTituloMinhasDoacoes;
    private javax.swing.JPanel panMinhasDoacoes;
    private javax.swing.JScrollPane scrollDoacoes;
    private javax.swing.JTable tblDoacoes;
    // End of variables declaration//GEN-END:variables
}