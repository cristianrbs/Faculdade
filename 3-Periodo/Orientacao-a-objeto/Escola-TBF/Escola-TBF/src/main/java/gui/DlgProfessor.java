package gui;

import controller.ProfessorController;
import tableModel.TMCadProfessor;
import dao.IDao;
import dao.ProfessorDAOBanco;
import classes.Professor;
import exceptions.ProfessorException;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class DlgProfessor extends JDialog {

    private boolean editando;
    private String codigoAntigo;
    private ProfessorController professorController;

    private JTextField edtCodigo;
    private JTextField edtNome;
    private JTextField edtEspecializacao;
    private JTextField edtCargaHoraria;
    private JTable grdProfessores;
    private JButton btnNovo, btnEditar, btnCancelar, btnExcluir, btnSalvar;

    public DlgProfessor(JFrame parent, Connection connection) {
        super(parent, "Cadastro de Professores", true);

        this.editando = false;
        this.codigoAntigo = "";

        IDao<Professor> professorDAO = new ProfessorDAOBanco(connection);
        this.professorController = new ProfessorController(professorDAO);

        initComponents();
        habilitarCampos(false);
        limparCampos();
        atualizarTabela();
    }

    private void initComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(720, 560);
        setLocationRelativeTo(getParent());
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Cadastro de Professores", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 4));
        btnNovo = criarBotao("Novo", "/images/novo_32x32.png");
        btnEditar = criarBotao("Editar", "/images/edit3_32x32.png");
        btnCancelar = criarBotao("Cancelar", "/images/cancel_32x32.png");
        btnExcluir = criarBotao("Excluir", "/images/del_32x32.png");
        btnSalvar = criarBotao("Salvar", "/images/save_32x32.png");
        panBotoes.add(btnNovo);
        panBotoes.add(btnEditar);
        panBotoes.add(btnCancelar);
        panBotoes.add(btnExcluir);
        panBotoes.add(btnSalvar);

        JPanel panCampos = new JPanel(new GridLayout(2, 4, 8, 8));
        panCampos.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        edtCodigo = new JTextField();
        edtNome = new JTextField();
        edtEspecializacao = new JTextField();
        edtCargaHoraria = new JTextField();

        panCampos.add(new JLabel("Código:"));
        panCampos.add(new JLabel("Nome:"));
        panCampos.add(new JLabel("Especialização:"));
        panCampos.add(new JLabel("Carga Horária:"));
        panCampos.add(edtCodigo);
        panCampos.add(edtNome);
        panCampos.add(edtEspecializacao);
        panCampos.add(edtCargaHoraria);

        JPanel panTopo = new JPanel();
        panTopo.setLayout(new BoxLayout(panTopo, BoxLayout.Y_AXIS));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        panCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panTopo.add(lblTitulo);
        panTopo.add(panBotoes);
        panTopo.add(panCampos);

        grdProfessores = new JTable();
        grdProfessores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                grdProfessoresMouseClicked();
            }
        });
        JScrollPane scroll = new JScrollPane(grdProfessores);

        add(panTopo, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnNovo.addActionListener(e -> btnNovoActionPerformed());
        btnEditar.addActionListener(e -> btnEditarActionPerformed());
        btnCancelar.addActionListener(e -> btnCancelarActionPerformed());
        btnExcluir.addActionListener(e -> btnExcluirActionPerformed());
        btnSalvar.addActionListener(e -> btnSalvarActionPerformed());
    }

    private JButton criarBotao(String texto, String caminhoIcone) {
        JButton botao = new JButton(texto);
        try {
            botao.setIcon(new ImageIcon(getClass().getResource(caminhoIcone)));
        } catch (Exception ex) {
            
        }
        return botao;
    }

    public void atualizarTabela() {
        List<Professor> lista = professorController.listarProfessores();
        TMCadProfessor tmCadProfessor = new TMCadProfessor(lista);
        grdProfessores.setModel(tmCadProfessor);
    }

    public void habilitarCampos(boolean flag) {
        edtCodigo.setEnabled(flag);
        edtNome.setEnabled(flag);
        edtEspecializacao.setEnabled(flag);
        edtCargaHoraria.setEnabled(flag);
    }

    public void limparCampos() {
        edtCodigo.setText("");
        edtNome.setText("");
        edtEspecializacao.setText("");
        edtCargaHoraria.setText("");
    }

    public void objetoParaCampos(Professor p) {
        edtCodigo.setText(p.getCodigo());
        edtNome.setText(p.getNome());
        edtEspecializacao.setText(p.getEspecializacao());
        edtCargaHoraria.setText(p.getCargaHoraria() + "");
    }

    private void btnNovoActionPerformed() {
        habilitarCampos(true);
        limparCampos();
        editando = false;
        edtCodigo.requestFocus();
    }

    private void btnSalvarActionPerformed() {
        try {
            if (editando) {
                professorController.atualizarProfessor(codigoAntigo, edtNome.getText(), edtEspecializacao.getText(), edtCargaHoraria.getText());
            } else {
                professorController.adicionarProfessor(edtCodigo.getText(), edtNome.getText(), edtEspecializacao.getText(), edtCargaHoraria.getText());
            }

            limparCampos();
            habilitarCampos(false);
            editando = false;
            atualizarTabela();
        } catch (ProfessorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarActionPerformed() {
        limparCampos();
        habilitarCampos(false);
        editando = false;
    }

    private void btnExcluirActionPerformed() {
        Professor professorEscolhido = getObjetoSelecionadoNaGrid();

        if (professorEscolhido == null) {
            JOptionPane.showMessageDialog(this, "Selecione um professor na tabela.");
            return;
        }

        Professor p = professorController.buscarProfessor(professorEscolhido.getCodigo());

        if (p == null) {
            JOptionPane.showMessageDialog(this, "Não existe este professor.");
        } else {
            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o professor " + p.getNome() + "?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                professorController.removerProfessor(p.getCodigo());
                JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
            }
        }

        atualizarTabela();
    }

    private void btnEditarActionPerformed() {
        Professor professorEscolhido = getObjetoSelecionadoNaGrid();

        if (professorEscolhido == null) {
            JOptionPane.showMessageDialog(this, "Selecione um professor na tabela.");
            return;
        }

        Professor professorEditando = professorController.buscarProfessor(professorEscolhido.getCodigo());

        if (professorEditando == null) {
            JOptionPane.showMessageDialog(this, "Não existe este professor.");
            editando = false;
        } else {
            limparCampos();
            habilitarCampos(true);

            objetoParaCampos(professorEditando);
            edtCodigo.setEnabled(false);
            editando = true;
            codigoAntigo = professorEditando.getCodigo();
        }
    }

    private void grdProfessoresMouseClicked() {
        Professor professor = getObjetoSelecionadoNaGrid();
        if (professor != null) {
            objetoParaCampos(professor);
        }
    }

    public Professor getObjetoSelecionadoNaGrid() {
        int linhaSelecionada = grdProfessores.getSelectedRow();

        if (linhaSelecionada >= 0) {
            return (Professor) grdProfessores.getModel().getValueAt(linhaSelecionada, -1);
        }
        return null;
    }
}
