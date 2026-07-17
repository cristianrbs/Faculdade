package gui.dialogs;

import classes.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DlgSelecionarMedico extends JDialog {

    private Medico medicoSelecionado;
    private JList<Medico> listaMedicos;

    public DlgSelecionarMedico(JFrame parent, List<Medico> medicos) {
        super(parent, "Selecionar Médico", true);
        setSize(350, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        DefaultListModel<Medico> model = new DefaultListModel<>();
        for (Medico m : medicos) {
            model.addElement(m);
        }

        listaMedicos = new JList<>(model);
        listaMedicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(listaMedicos), BorderLayout.CENTER);

        JButton btnSelecionar = new JButton("Selecionar");
        btnSelecionar.addActionListener(e -> {
            medicoSelecionado = listaMedicos.getSelectedValue();
            if (medicoSelecionado == null) {
                JOptionPane.showMessageDialog(this, "Selecione um médico!");
            } else {
                dispose();
            }
        });
        add(btnSelecionar, BorderLayout.SOUTH);
    }

    public Medico getMedicoSelecionado() {
        return medicoSelecionado;
    }
}