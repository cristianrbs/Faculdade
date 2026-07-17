package gui;

import gerentes.GerenciadorConsulta;
import gerentes.GerenciadorMedico;
import gerentes.GerenciadorPaciente;
import gui.dialogs.*;
import javax.swing.*;
import java.awt.*; 

public class FrHome extends javax.swing.JFrame {
    
    private GerenciadorPaciente gerenciadorPaciente;
    private GerenciadorMedico gerenciadorMedico;
    private GerenciadorConsulta gerenciadorConsulta;

    public FrHome() {
        gerenciadorPaciente = new GerenciadorPaciente();
        gerenciadorMedico = new GerenciadorMedico();
        gerenciadorConsulta = new GerenciadorConsulta();

        setTitle("Sistema de Agendamento de Consultas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnPacientes = new JButton("Cadastrar Paciente");
        JButton btnMedicos = new JButton("Cadastrar Médico");
        JButton btnConsultas = new JButton("Agendar Consulta");
        JButton btnListarConsultas = new JButton("Listar Consultas");

        btnPacientes.addActionListener(e -> {
            DlgCadastroPaciente dlg = new DlgCadastroPaciente(this, gerenciadorPaciente);
            dlg.setVisible(true);
        });

        btnMedicos.addActionListener(e -> {
            DlgCadastroMedico dlg = new DlgCadastroMedico(this, gerenciadorMedico);
            dlg.setVisible(true);
        });

        btnConsultas.addActionListener(e -> {
            DlgAgendarConsulta dlg = new DlgAgendarConsulta(this, gerenciadorPaciente, gerenciadorMedico, gerenciadorConsulta);
            dlg.setVisible(true);
        });

        btnListarConsultas.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, gerenciadorConsulta.toString(), "Consultas Agendadas", JOptionPane.INFORMATION_MESSAGE);
        });

        add(btnPacientes);
        add(btnMedicos);
        add(btnConsultas);
        add(btnListarConsultas);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
