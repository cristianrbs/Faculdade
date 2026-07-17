package gui;

import controller.DisciplinaController;
import tableModel.TMCadDisciplina;
import dao.DisciplinaDAOBanco;
import dao.IDao;
import classes.Disciplina;
import exceptions.DisciplinaException;
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


public class DlgDisciplina extends JDialog {

    private boolean editando;
    private String codigoAntigo;
    private DisciplinaController disciplinaController;

    private JTextField edtCodigo;
    private JTextField edtNome;
    private JTextField edtCargaHoraria;
    private JTextField edtProfessorResponsavel;
    private JTable grdDisciplinas;
    private JButton btnNovo, btnEditar, btnCancelar, btnExcluir, btnSalvar;

    public DlgDisciplina(JFrame parent, Connection connection) {
        super(parent, "Cadastro de Disciplinas", true);

        this.editando = false;
        this.codigoAntigo = "";

        IDao<Disciplina> disciplinaDAO = new DisciplinaDAOBanco(connection);
        this.disciplinaController = new DisciplinaController(disciplinaDAO);

        initComponents();
        habilitarCampos(false);
        limparCampos();
        atualizarTabela();
    }

    private void initComponents() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(760, 560);
        setLocationRelativeTo(getParent());
        setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Cadastro de Disciplinas", SwingConstants.CENTER);
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
        edtCargaHoraria = new JTextField();
        edtProfessorResponsavel = new JTextField();

        panCampos.add(new JLabel("Código:"));
        panCampos.add(new JLabel("Nome:"));
        panCampos.add(new JLabel("Carga Horária:"));
        panCampos.add(new JLabel("Professor Responsável:"));
        panCampos.add(edtCodigo);
        panCampos.add(edtNome);
        panCampos.add(edtCargaHoraria);
        panCampos.add(edtProfessorResponsavel);

        JPanel panTopo = new JPanel();
        panTopo.setLayout(new BoxLayout(panTopo, BoxLayout.Y_AXIS));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panBotoes.setAlignmentX(Component.CENTER_ALIGNMENT);
        panCampos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panTopo.add(lblTitulo);
        panTopo.add(panBotoes);
        panTopo.add(panCampos);

        grdDisciplinas = new JTable();
        grdDisciplinas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                grdDisciplinasMouseClicked();
            }
        });
        JScrollPane scroll = new JScrollPane(grdDisciplinas);

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
        List<Disciplina> lista = disciplinaController.listarDisciplinas();
        TMCadDisciplina tmCadDisciplina = new TMCadDisciplina(lista);
        grdDisciplinas.setModel(tmCadDisciplina);
    }

    public void habilitarCampos(boolean flag) {
        edtCodigo.setEnabled(flag);
        edtNome.setEnabled(flag);
        edtCargaHoraria.setEnabled(flag);
        edtProfessorResponsavel.setEnabled(flag);
    }

    public void limparCampos() {
        edtCodigo.setText("");
        edtNome.setText("");
        edtCargaHoraria.setText("");
        edtProfessorResponsavel.setText("");
    }

    public void objetoParaCampos(Disciplina d) {
        edtCodigo.setText(d.getCodigo());
        edtNome.setText(d.getNome());
        edtCargaHoraria.setText(d.getCargaHoraria() + "");
        edtProfessorResponsavel.setText(d.getProfessorResponsavel());
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
                disciplinaController.atualizarDisciplina(codigoAntigo, edtNome.getText(), edtCargaHoraria.getText(), edtProfessorResponsavel.getText());
            } else {
                disciplinaController.adicionarDisciplina(edtCodigo.getText(), edtNome.getText(), edtCargaHoraria.getText(), edtProfessorResponsavel.getText());
            }

            limparCampos();
            habilitarCampos(false);
            editando = false;
            atualizarTabela();
        } catch (DisciplinaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro de validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnCancelarActionPerformed() {
        limparCampos();
        habilitarCampos(false);
        editando = false;
    }

    private void btnExcluirActionPerformed() {
        Disciplina disciplinaEscolhida = getObjetoSelecionadoNaGrid();

        if (disciplinaEscolhida == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma disciplina na tabela.");
            return;
        }

        Disciplina d = disciplinaController.buscarDisciplina(disciplinaEscolhida.getCodigo());

        if (d == null) {
            JOptionPane.showMessageDialog(this, "Não existe esta disciplina.");
        } else {
            int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir a disciplina " + d.getNome() + "?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                disciplinaController.removerDisciplina(d.getCodigo());
                JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
            }
        }

        atualizarTabela();
    }

    private void btnEditarActionPerformed() {
        Disciplina disciplinaEscolhida = getObjetoSelecionadoNaGrid();

        if (disciplinaEscolhida == null) {
            JOptionPane.showMessageDialog(this, "Selecione uma disciplina na tabela.");
            return;
        }

        Disciplina disciplinaEditando = disciplinaController.buscarDisciplina(disciplinaEscolhida.getCodigo());

        if (disciplinaEditando == null) {
            JOptionPane.showMessageDialog(this, "Não existe esta disciplina.");
            editando = false;
        } else {
            limparCampos();
            habilitarCampos(true);

            objetoParaCampos(disciplinaEditando);
            edtCodigo.setEnabled(false);
            editando = true;
            codigoAntigo = disciplinaEditando.getCodigo();
        }
    }

    private void grdDisciplinasMouseClicked() {
        Disciplina disciplina = getObjetoSelecionadoNaGrid();
        if (disciplina != null) {
            objetoParaCampos(disciplina);
        }
    }

    public Disciplina getObjetoSelecionadoNaGrid() {
        int linhaSelecionada = grdDisciplinas.getSelectedRow();

        if (linhaSelecionada >= 0) {
            return (Disciplina) grdDisciplinas.getModel().getValueAt(linhaSelecionada, -1);
        }
        return null;
    }
}
