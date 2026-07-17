package gui.dialogs;

import gerentes.*;
import classes.*;
import javax.swing.*;
import java.awt.*;

public class DlgAgendarConsulta extends JDialog {

    private GerenciadorPaciente gerenciadorPaciente;
    private GerenciadorMedico gerenciadorMedico;
    private GerenciadorConsulta gerenciadorConsulta;

    private JTextField txtDataHora;
    private JLabel lblPaciente, lblMedico;
    private Paciente pacienteSelecionado;
    private Medico medicoSelecionado;

    public DlgAgendarConsulta(JFrame parent, GerenciadorPaciente gp, GerenciadorMedico gm, GerenciadorConsulta gc) {
        super(parent, "Agendar Consulta", true);
        this.gerenciadorPaciente = gp;
        this.gerenciadorMedico = gm;
        this.gerenciadorConsulta = gc;

        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Paciente:"));
        lblPaciente = new JLabel("Nenhum selecionado");
        add(lblPaciente);

        JButton btnSelecionarPaciente = new JButton("Selecionar Paciente");
        btnSelecionarPaciente.addActionListener(e -> {
            DlgSelecionarPaciente dlg = new DlgSelecionarPaciente(parent, gerenciadorPaciente.getPacientes());
            dlg.setVisible(true);
            pacienteSelecionado = dlg.getPacienteSelecionado();
            if (pacienteSelecionado != null) {
                lblPaciente.setText(pacienteSelecionado.getNome());
            }
        });
        add(btnSelecionarPaciente);
        add(new JLabel());

        add(new JLabel("Médico:"));
        lblMedico = new JLabel("Nenhum selecionado");
        add(lblMedico);

        JButton btnSelecionarMedico = new JButton("Selecionar Médico");
        btnSelecionarMedico.addActionListener(e -> {
            DlgSelecionarMedico dlg = new DlgSelecionarMedico(parent, gerenciadorMedico.getMedicos());
            dlg.setVisible(true);
            medicoSelecionado = dlg.getMedicoSelecionado();
            if (medicoSelecionado != null) {
                lblMedico.setText(medicoSelecionado.getNome());
            }
        });
        add(btnSelecionarMedico);
        add(new JLabel());

        add(new JLabel("Data e Hora (DD-MM-AAAA):"));
        txtDataHora = new JTextField();
        add(txtDataHora);

        JButton btnAgendar = new JButton("Agendar");
        btnAgendar.addActionListener(e -> {
            if (pacienteSelecionado == null || medicoSelecionado == null || txtDataHora.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            }
            Consulta consulta = new Consulta(pacienteSelecionado, medicoSelecionado, txtDataHora.getText());
            gerenciadorConsulta.adicionarConsulta(consulta);
            JOptionPane.showMessageDialog(this, "Consulta agendada com sucesso!");
            dispose();
        });
        add(btnAgendar);
    }
}