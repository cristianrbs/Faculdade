package gui;

import controller.AlunoController;
import tableModel.TMCadAluno;
import dao.AlunoDAOBanco;
import dao.IDao;
import classes.Aluno;
import exceptions.AlunoException;
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


public class DlgAluno extends JDialog {

    private boolean editando;
    private String matriculaAntiga;
    private AlunoController alunoController;

    private JTextField edtMatricula;
    private JTextField edtNome;
    private JTextField edtCurso;
    private JTextField edtIdade;
    private JTable grdAlunos;
    private JButton btnNovo, btnEditar, btnCancelar, btnExcluir, btnSalvar;

    public DlgAluno(JFrame parent, Connection connection) {
        super(parent, "Cadastro de Alunos", true);

        this.editando = false;
        this.matriculaAntiga = "";

        IDao<Aluno> alunoDAO = new AlunoDAOBanco(connection);
        this.alunoController = new AlunoController(alunoDAO);

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

        JLabel lblTitulo = new JLabel("Cadastro de Alunos", SwingConstants.CENTER);
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

        edtMatricula = new JTextField();
        edtNome = new JTextField();
        edtCurso = new JTextField();
        edtIdade = new JTextField();

        panCampos.add(new JLabel("Matrícula:"));
        panCampos.add(new JLabel("Nome:"));
        panCampos.add(new JLabel("Curso:"));
        panCampos.add(new JLabel("Idade:"));
        panCampos.add(edtMatricula);
        panCampos.add(edtNome);
        panCampos.add(edtCurso);
        panCampos.add(edtIdade);

        JPanel panTopo = new JPanel();
        panTopo.setLayout(new BoxLayout(panTopo, BoxLayout.Y_AXIS));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        panCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panTopo.add(lblTitulo);
        panTopo.add(panBotoes);
        panTopo.add(panCampos);

        grdAlunos = new JTable();
        grdAlunos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                grdAlunosMouseClicked();
            }
        });
        JScrollPane scroll = new JScrollPane(grdAlunos);

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
        List<Aluno> lista = alunoController.listarAlunos();
        TMCadAluno tmCadAluno = new TMCadAluno(lista);
        grdAlunos.setModel(tmCadAluno);
    }

    public void habilitarCampos(boolean flag) {
        edtMatricula.setEnabled(flag);
        edtNome.setEnabled(flag);
        edtCurso.setEnabled(flag);
        edtIdade.setEnabled(flag);
    }

    public void limparCampos() {
        edtMatricula.setText("");
        edtNome.setText("");
        edtCurso.setText("");
        edtIdade.setText("");
    }

    public void objetoParaCampos(Aluno a) {
        edtMatricula.setText(a.getMatricula());
        edtNome.setText(a.getNome());
        edtCurso.setText(a.getCurso());
        edtIdade.setText(a.getIdade() + "");
    }

    private void btnNovoActionPerformed() {
        habilitarCampos(true);
        limparCampos();
        editando = false;
        edtMatricula.requestFocus();
    }

    private void btnSalvarActionPerformed() {
        try {
            if (editando) {
                alunoController.atualizarAluno(matriculaAntiga, edtNome.getText(), edtCurso.getText(), edtIdade.getText());
            } else {
                alunoController.adicionarAluno(edtMatricula.getText(), edtNome.getText(), edtCurso.getText(), edtIdade.getText());
            }

            limparCampos();
            habilitarCampos(false);
            editando = false;
            atualizarTabela();
        } catch (AlunoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarActionPerformed() {
        limparCampos();
        habilitarCampos(false);
        editando = false;
    }

    private void btnExcluirActionPerformed() {
        Aluno alunoEscolhido = getObjetoSelecionadoNaGrid();

        if (alunoEscolhido == null) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno na tabela.");
            return;
        }

        Aluno a = alunoController.buscarAluno(alunoEscolhido.getMatricula());

        if (a == null) {
            JOptionPane.showMessageDialog(this, "Não existe este aluno.");
        } else {
            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o aluno " + a.getNome() + "?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                alunoController.removerAluno(a.getMatricula());
                JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
            }
        }

        atualizarTabela();
    }

    private void btnEditarActionPerformed() {
        Aluno alunoEscolhido = getObjetoSelecionadoNaGrid();

        if (alunoEscolhido == null) {
            JOptionPane.showMessageDialog(this, "Selecione um aluno na tabela.");
            return;
        }

        Aluno alunoEditando = alunoController.buscarAluno(alunoEscolhido.getMatricula());

        if (alunoEditando == null) {
            JOptionPane.showMessageDialog(this, "Não existe este aluno.");
            editando = false;
        } else {
            limparCampos();
            habilitarCampos(true);

            objetoParaCampos(alunoEditando);
            edtMatricula.setEnabled(false);
            editando = true;
            matriculaAntiga = alunoEditando.getMatricula();
        }
    }

    private void grdAlunosMouseClicked() {
        Aluno aluno = getObjetoSelecionadoNaGrid();
        if (aluno != null) {
            objetoParaCampos(aluno);
        }
    }

    public Aluno getObjetoSelecionadoNaGrid() {
        int linhaSelecionada = grdAlunos.getSelectedRow();

        if (linhaSelecionada >= 0) {
            return (Aluno) grdAlunos.getModel().getValueAt(linhaSelecionada, -1);
        }
        return null;
    }
}
