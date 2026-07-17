package gui;

import connection.SQLiteConnector;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class FrMenuPrincipal extends JFrame {

    private Connection connection;

    public FrMenuPrincipal() throws SQLException {
        SQLiteConnector conector = new SQLiteConnector("banco_escola.sqlite");
        this.connection = conector.getConnection();

        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Escolar - Menu Principal");
        setSize(480, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel lblTitulo = new JLabel("Sistema Escolar", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));

        JPanel panBotoes = new JPanel(new GridLayout(4, 1, 12, 12));
        panBotoes.setBorder(BorderFactory.createEmptyBorder(10, 60, 30, 60));

        JButton btnAlunos = new JButton("Cadastro de Alunos");
        JButton btnProfessores = new JButton("Cadastro de Professores");
        JButton btnDisciplinas = new JButton("Cadastro de Disciplinas");
        JButton btnSair = new JButton("Sair");

        btnAlunos.setPreferredSize(new Dimension(200, 45));
        btnProfessores.setPreferredSize(new Dimension(200, 45));
        btnDisciplinas.setPreferredSize(new Dimension(200, 45));
        btnSair.setPreferredSize(new Dimension(200, 45));

        panBotoes.add(btnAlunos);
        panBotoes.add(btnProfessores);
        panBotoes.add(btnDisciplinas);
        panBotoes.add(btnSair);

        getContentPane().setLayout(new java.awt.BorderLayout());
        add(lblTitulo, java.awt.BorderLayout.NORTH);
        add(panBotoes, java.awt.BorderLayout.CENTER);

        btnAlunos.addActionListener(e -> abrirCadastroAlunos());
        btnProfessores.addActionListener(e -> abrirCadastroProfessores());
        btnDisciplinas.addActionListener(e -> abrirCadastroDisciplinas());
        btnSair.addActionListener(e -> confirmarSaida());
    }

    private void abrirCadastroAlunos() {
        DlgAluno dlg = new DlgAluno(this, connection);
        dlg.setVisible(true);
    }

    private void abrirCadastroProfessores() {
        DlgProfessor dlg = new DlgProfessor(this, connection);
        dlg.setVisible(true);
    }

    private void abrirCadastroDisciplinas() {
        DlgDisciplina dlg = new DlgDisciplina(this, connection);
        dlg.setVisible(true);
    }

    private void confirmarSaida() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente sair do sistema?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
