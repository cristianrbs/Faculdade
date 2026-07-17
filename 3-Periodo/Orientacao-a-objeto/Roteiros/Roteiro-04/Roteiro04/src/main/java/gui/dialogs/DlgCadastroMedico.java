package gui.dialogs;

import gerentes.*;
import classes.*;
import javax.swing.*;
import java.awt.*;

public class DlgCadastroMedico extends JDialog {

    private GerenciadorMedico gerenciador;
    private JTextField txtNome, txtCrm, txtEspecialidade, txtHorarios;

    public DlgCadastroMedico(JFrame parent, GerenciadorMedico gerenciador) {
        super(parent, "Cadastro de Médicos", true);
        this.gerenciador = gerenciador;

        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        add(new JLabel("CRM:"));
        txtCrm = new JTextField();
        add(txtCrm);

        add(new JLabel("Especialidade:"));
        txtEspecialidade = new JTextField();
        add(txtEspecialidade);

        add(new JLabel("Horários Disponíveis:"));
        txtHorarios = new JTextField();
        add(txtHorarios);

        JButton btnSalvar = new JButton("Salvar");
        JButton btnSalvarArquivo = new JButton("Salvar em Arquivo");

        btnSalvar.addActionListener(e -> {
            if (txtNome.getText().isEmpty() || txtCrm.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }
            Medico m = new Medico(
                txtNome.getText(),
                txtCrm.getText(),
                txtEspecialidade.getText(),
                txtHorarios.getText()
            );
            gerenciador.adicionarMedico(m);
            JOptionPane.showMessageDialog(this, "Médico cadastrado com sucesso!");
            limparCampos();
        });

        btnSalvarArquivo.addActionListener(e -> {
            gerenciador.saveToFile("medicos.csv");
            JOptionPane.showMessageDialog(this, "Médicos salvos no arquivo!");
        });

        add(btnSalvar);
        add(btnSalvarArquivo);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCrm.setText("");
        txtEspecialidade.setText("");
        txtHorarios.setText("");
    }
}