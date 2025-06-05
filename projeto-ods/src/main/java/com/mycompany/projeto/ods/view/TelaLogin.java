package com.mycompany.projeto.ods.view;

import com.mycompany.projeto.ods.dao.DoadorDAO;
import com.mycompany.projeto.ods.model.Doador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
    private JTextField campoCpf;
    private JPasswordField campoSenha;
    private JButton botaoLogin;
    private JButton botaoCadastro;
    
    private final DoadorDAO doadorDAO;
    
    public TelaLogin() {
        doadorDAO = new DoadorDAO();
        configurarJanela();
        criarComponentes();
        configurarEventos();
    }
    
    private void configurarJanela() {
        setTitle("Sistema de Doação de Sangue - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    private void criarComponentes() {
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Título
        JLabel titulo = new JLabel("Login do Doador");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 20, 5);
        painelPrincipal.add(titulo, gbc);
        
        // Campo CPF
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 5, 5, 5);
        painelPrincipal.add(new JLabel("CPF:"), gbc);
        
        campoCpf = new JTextField(20);
        gbc.gridx = 1;
        painelPrincipal.add(campoCpf, gbc);
        
        // Campo Senha
        gbc.gridx = 0;
        gbc.gridy = 2;
        painelPrincipal.add(new JLabel("Senha:"), gbc);
        
        campoSenha = new JPasswordField(20);
        gbc.gridx = 1;
        painelPrincipal.add(campoSenha, gbc);
        
        // Botões
        JPanel painelBotoes = new JPanel();
        botaoLogin = new JButton("Entrar");
        botaoCadastro = new JButton("Cadastrar");
        
        painelBotoes.add(botaoLogin);
        painelBotoes.add(botaoCadastro);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 5, 20, 5);
        painelPrincipal.add(painelBotoes, gbc);
        
        add(painelPrincipal);
    }
    
    private void configurarEventos() {
        botaoLogin.addActionListener(e -> realizarLogin());
        botaoCadastro.addActionListener(e -> abrirCadastro());
        
        // Permite login ao pressionar Enter
        campoSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    realizarLogin();
                }
            }
        });
    }
    
    private void realizarLogin() {
        String cpf = campoCpf.getText();
        String senha = new String(campoSenha.getPassword());
        
        if (cpf.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Por favor, preencha todos os campos.",
                "Erro de Login",
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Doador doador = doadorDAO.autenticar(cpf, senha);
            if (doador != null) {
                JOptionPane.showMessageDialog(this,
                    "Bem-vindo(a), " + doador.getNome() + "!",
                    "Login Realizado",
                    JOptionPane.INFORMATION_MESSAGE);
                // TODO: Abrir a tela principal do sistema
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                    "CPF ou senha inválidos.",
                    "Erro de Login",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "Erro ao realizar login: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.setVisible(true);
    }
} 