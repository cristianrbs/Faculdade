package gui.dialogs;

import classes.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DlgSelecionarPaciente extends JDialog {

    private Paciente pacienteSelecionado;
    private JList<Paciente> listaPacientes;

    public DlgSelecionarPaciente(JFrame parent, List<Paciente> pacientes) {
        super(parent, "Selecionar Paciente", true);
        setSize(350, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        DefaultListModel<Paciente> model = new DefaultListModel<>();
        for (Paciente p : pacientes) {
            model.addElement(p);
        }

        listaPacientes = new JList<>(model);
        listaPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaPacientes), BorderLayout.CENTER);

        JButton btnSelecionar = new JButton("Selecionar");
        btnSelecionar.addActionListener(e -> {
            pacienteSelecionado = listaPacientes.getSelectedValue();
            if (pacienteSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione um paciente!");
            } else {
                dispose();
            }
        });
        add(btnSelecionar, BorderLayout.SOUTH);
    }

    public Paciente getPacienteSelecionado() {
        return pacienteSelecionado;
    }
}