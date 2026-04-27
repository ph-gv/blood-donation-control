package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoacaoDAO;
import com.mycompany.projeto.ods.dao.HemocentroDAO;
import com.mycompany.projeto.ods.model.Doacao;
import com.mycompany.projeto.ods.model.Doador;
import com.mycompany.projeto.ods.model.Hemocentro;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

public class EditarAgendamentoScreen extends javax.swing.JFrame {

    private final Doador usuario;
    private final Doacao doacao;
    private final DoacaoDAO doacaoDAO = new DoacaoDAO();
    private final HemocentroDAO hemocentroDAO = new HemocentroDAO();

    public EditarAgendamentoScreen(Doador usuario, Doacao doacao) {
        this.usuario = Objects.requireNonNull(usuario);
        this.doacao = Objects.requireNonNull(doacao);
        initComponents();
        setLocationRelativeTo(null);
        configuraFormatters();
        carregaHemocentros();
        populaCampos();
    }

    private void initComponents() {
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        lblLocal = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        cmbHemocentros = new javax.swing.JComboBox<>();
        fmtData = new javax.swing.JFormattedTextField();
        fmtHora = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelarAgendamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editar Agendamento");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 3, 14));
        lblTitulo.setText("Editar Agendamento");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 0, 12));
        lblSubtitulo.setText("Altere os dados do seu agendamento abaixo:");

        lblLocal.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblLocal.setText("Local:");

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblData.setText("Data:");

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblHora.setText("Horário:");

        cmbHemocentros.setBackground(new java.awt.Color(232, 160, 154));

        fmtData.setBackground(new java.awt.Color(232, 160, 154));
        fmtHora.setBackground(new java.awt.Color(232, 160, 154));

        btnVoltar.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltar.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnVoltar.setText("VOLTAR");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(e -> btnVoltarActionPerformed());

        btnSalvar.setBackground(new java.awt.Color(46, 139, 87));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnSalvar.setText("SALVAR");
        btnSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.addActionListener(e -> btnSalvarActionPerformed());

        btnCancelarAgendamento.setBackground(new java.awt.Color(180, 50, 50));
        btnCancelarAgendamento.setFont(new java.awt.Font("Segoe UI", 3, 12));
        btnCancelarAgendamento.setForeground(java.awt.Color.WHITE);
        btnCancelarAgendamento.setText("CANCELAR AGENDAMENTO");
        btnCancelarAgendamento
                .setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarAgendamento.addActionListener(e -> btnCancelarAgendamentoActionPerformed());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblTitulo)
                                        .addComponent(lblSubtitulo)
                                        .addComponent(lblLocal)
                                        .addComponent(cmbHemocentros, 0, 280, Short.MAX_VALUE)
                                        .addComponent(lblData)
                                        .addComponent(fmtData)
                                        .addComponent(lblHora)
                                        .addComponent(fmtHora)
                                        .addComponent(btnCancelarAgendamento, javax.swing.GroupLayout.DEFAULT_SIZE, 280,
                                                Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(80, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSubtitulo)
                                .addGap(18, 18, 18)
                                .addComponent(lblLocal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbHemocentros, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lblData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fmtData, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lblHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fmtHora, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnVoltar)
                                        .addComponent(btnSalvar))
                                .addGap(12, 12, 12)
                                .addComponent(btnCancelarAgendamento)
                                .addContainerGap(20, Short.MAX_VALUE)));

        pack();
    }

    private void populaCampos() {
        Hemocentro hAtual = hemocentroDAO.buscarPorId(doacao.getIdLocalColeta());
        if (hAtual != null) {
            cmbHemocentros.setSelectedItem(hAtual.getNome());
        }
        DateTimeFormatter fmtBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fmtData.setText(doacao.getData().format(fmtBR));
        fmtHora.setText(doacao.getHorario().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    private void configuraFormatters() {
        try {
            MaskFormatter mfData = new MaskFormatter("##/##/####");
            mfData.setPlaceholderCharacter('_');
            fmtData.setFormatterFactory(new DefaultFormatterFactory(mfData));

            MaskFormatter mfHora = new MaskFormatter("##:##");
            mfHora.setPlaceholderCharacter('0');
            fmtHora.setFormatterFactory(new DefaultFormatterFactory(mfHora));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void carregaHemocentros() {
        cmbHemocentros.removeAllItems();
        List<Hemocentro> lista = hemocentroDAO.listarTodos();
        for (Hemocentro h : lista) {
            cmbHemocentros.addItem(h.getNome());
        }
    }

    private void btnSalvarActionPerformed() {
        String nomeSelecionado = (String) cmbHemocentros.getSelectedItem();
        Hemocentro selecionado = hemocentroDAO.buscarPorNome(nomeSelecionado);
        if (selecionado == null) {
            JOptionPane.showMessageDialog(this, "Selecione um hemocentro.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate data;
        LocalTime hora;

        try {
            data = LocalDate.parse(fmtData.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Data inválida. Use DD/MM/AAAA.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            fmtData.requestFocusInWindow();
            return;
        }

        try {
            hora = LocalTime.parse(fmtHora.getText(), DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Horário inválido. Use HH:mm.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            fmtHora.requestFocusInWindow();
            return;
        }

        if (LocalDateTime.of(data, hora).isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(this, "Não é possível agendar em horário passado.", "Erro de Validação",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean mudou = selecionado.getId() != doacao.getIdLocalColeta()
                || !data.equals(doacao.getData())
                || !hora.equals(doacao.getHorario());

        if (mudou && !doacaoDAO.verificarDisponibilidade(selecionado.getId(), data, hora)) {
            JOptionPane.showMessageDialog(this, "Horário indisponível neste hemocentro.", "Erro de Disponibilidade",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        doacao.setIdLocalColeta(selecionado.getId());
        doacao.setData(data);
        doacao.setHorario(hora);

        try {
            doacaoDAO.atualizar(doacao);
            JOptionPane.showMessageDialog(this, "Agendamento atualizado com sucesso!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            new MinhasDoacoesScreen(usuario).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar: " + e.getMessage(), "Erro no Sistema",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarAgendamentoActionPerformed() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja cancelar este agendamento?",
                "Confirmar Cancelamento",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                doacaoDAO.cancelar(doacao.getIdDoacao());
                JOptionPane.showMessageDialog(this, "Agendamento cancelado.", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                new MinhasDoacoesScreen(usuario).setVisible(true);
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao cancelar: " + e.getMessage(), "Erro no Sistema",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void btnVoltarActionPerformed() {
        new MinhasDoacoesScreen(usuario).setVisible(true);
        this.dispose();
    }

    // Variables declaration
    private javax.swing.JButton btnCancelarAgendamento;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cmbHemocentros;
    private javax.swing.JFormattedTextField fmtData;
    private javax.swing.JFormattedTextField fmtHora;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblLocal;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
}