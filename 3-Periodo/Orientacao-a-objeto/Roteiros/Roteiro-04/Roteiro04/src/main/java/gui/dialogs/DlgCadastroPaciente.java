package gui.dialogs;

import gerentes.*;
import classes.*;
import javax.swing.*;
import java.awt.*;

public class DlgCadastroPaciente extends JDialog {

    private GerenciadorPaciente gerenciador;
    private JTextField txtNome, txtCpf, txtDataNascimento;
    private JTextArea txtHistorico;

    public DlgCadastroPaciente(JFrame parent, GerenciadorPaciente gerenciador) {
        super(parent, "Cadastro de Pacientes", true);
        this.gerenciador = gerenciador;

        setSize(400, 350);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        add(txtCpf);

        add(new JLabel("Data de Nascimento:"));
        txtDataNascimento = new JTextField();
        add(txtDataNascimento);

        add(new JLabel("Histórico Médico:"));
        txtHistorico = new JTextArea(3, 20);
        add(new JScrollPane(txtHistorico));

        JButton btnSalvar = new JButton("Salvar");
        JButton btnSalvarArquivo = new JButton("Salvar em Arquivo");

        btnSalvar.addActionListener(e -> {
            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }
            Paciente p = new Paciente(
                txtNome.getText(),
                txtCpf.getText(),
                txtDataNascimento.getText(),
                txtHistorico.getText()
            );
            gerenciador.adicionarPaciente(p);
            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");
            limparCampos();
        });

        btnSalvarArquivo.addActionListener(e -> {
            gerenciador.saveToFile("pacientes.csv");
            JOptionPane.showMessageDialog(this, "Pacientes salvos no arquivo!");
        });

        add(btnSalvar);
        add(btnSalvarArquivo);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtDataNascimento.setText("");
        txtHistorico.setText("");
    }
}