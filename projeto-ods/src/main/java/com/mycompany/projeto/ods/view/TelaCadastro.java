package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaCadastro extends JFrame {
    private JTextField campoNome;
    private JFormattedTextField campoCpf;
    private JComboBox<String> comboTipoSanguineo;
    private JFormattedTextField campoDataNascimento;
    private JPasswordField campoSenha;
    private JPasswordField campoConfirmarSenha;
    private JButton botaoCadastrar;
    private JButton botaoVoltar;
    
    private final DoadorDAO doadorDAO;
    
    public TelaCadastro() {
        doadorDAO = new DoadorDAO();
        configurarJanela();
        criarComponentes();
        configurarEventos();
    }
    
    private void configurarJanela() {
        setTitle("Cadastro de Doador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void criarComponentes() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Título
        JLabel titulo = new JLabel("Cadastro de Doador");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 20, 5);
        painelPrincipal.add(titulo, gbc);
        
        // Campos
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Nome
        gbc.gridy = 1;
        painelPrincipal.add(new JLabel("Nome:"), gbc);
        
        campoNome = new JTextField(20);
        gbc.gridx = 1;
        painelPrincipal.add(campoNome, gbc);
        
        // CPF
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(new JLabel("CPF:"), gbc);
        
        campoCpf = new JFormattedTextField(createFormatter("###.###.###-##"));
        campoCpf.setColumns(20);
        gbc.gridx = 1;
        painelPrincipal.add(campoCpf, gbc);
        
        // Tipo Sanguíneo
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelPrincipal.add(new JLabel("Tipo Sanguíneo:"), gbc);
        
        String[] tiposSanguineos = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        comboTipoSanguineo = new JComboBox<>(tiposSanguineos);
        gbc.gridx = 1;
        painelPrincipal.add(comboTipoSanguineo, gbc);
        
        // Data de Nascimento
        gbc.gridx = 0;
        gbc.gridy = 4;
        painelPrincipal.add(new JLabel("Data de Nascimento:"), gbc);
        
        campoDataNascimento = new JFormattedTextField(createFormatter("##/##/####"));
        campoDataNascimento.setColumns(20);
        campoDataNascimento.setToolTipText("Formato: dd/mm/aaaa");
        gbc.gridx = 1;
        painelPrincipal.add(campoDataNascimento, gbc);
        
        // Senha
        gbc.gridx = 0;
        gbc.gridy = 5;
        painelPrincipal.add(new JLabel("Senha:"), gbc);
        
        campoSenha = new JPasswordField(20);
        gbc.gridx = 1;
        painelPrincipal.add(campoSenha, gbc);
        
        // Confirmar Senha
        gbc.gridx = 0;
        gbc.gridy = 6;
        painelPrincipal.add(new JLabel("Confirmar Senha:"), gbc);
        
        campoConfirmarSenha = new JPasswordField(20);
        gbc.gridx = 1;
        painelPrincipal.add(campoConfirmarSenha, gbc);
        
        // Botões
        JPanel painelBotoes = new JPanel();
        botaoCadastrar = new JButton("Cadastrar");
        botaoVoltar = new JButton("Voltar");
        
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoVoltar);
        
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 20, 5);
        painelPrincipal.add(painelBotoes, gbc);
        
        add(painelPrincipal);
    }
    
    private MaskFormatter createFormatter(String mask) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }
    
    private void configurarEventos() {
        botaoCadastrar.addActionListener(e -> realizarCadastro());
        botaoVoltar.addActionListener(e -> dispose());
    }
    
    private void realizarCadastro() {
        // Validação dos campos
        if (campoNome.getText().isEmpty() || campoCpf.getText().replaceAll("[^0-9]", "").isEmpty() || 
            campoDataNascimento.getText().replaceAll("[^0-9]", "").isEmpty() || 
            campoSenha.getPassword().length == 0 || campoConfirmarSenha.getPassword().length == 0) {
            
            JOptionPane.showMessageDialog(this,
                "Por favor, preencha todos os campos.",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validação do CPF
        String cpf = campoCpf.getText().replaceAll("[^0-9]", "");
        if (doadorDAO.verificarCpfExistente(cpf)) {
            JOptionPane.showMessageDialog(this,
                "CPF já cadastrado no sistema.",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validação da senha
        String senha = new String(campoSenha.getPassword());
        String confirmarSenha = new String(campoConfirmarSenha.getPassword());
        
        if (!senha.equals(confirmarSenha)) {
            JOptionPane.showMessageDialog(this,
                "As senhas não coincidem.",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Validação da data
        LocalDate dataNascimento;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataNascimento = LocalDate.parse(campoDataNascimento.getText(), formatter);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Data de nascimento inválida. Use o formato dd/mm/aaaa.",
                "Erro de Validação",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Cria o objeto doador
        Doador doador = new Doador();
        doador.setNome(campoNome.getText());
        doador.setCpf(cpf);
        doador.setTipoSanguineo((String) comboTipoSanguineo.getSelectedItem());
        doador.setDataNascimento(dataNascimento);
        doador.setSenha(senha);
        
        try {
            if (doadorDAO.cadastrar(doador)) {
                JOptionPane.showMessageDialog(this,
                    "Cadastro realizado com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "Erro ao realizar cadastro.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao realizar cadastro: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
} 