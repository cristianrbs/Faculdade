package dao;

import classes.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaDAOBanco implements IDao<Disciplina> {

    private Connection connection;

    public DisciplinaDAOBanco(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (codigo, nome, cargaHoraria, professorResponsavel) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getCodigo());
            stmt.setString(2, disciplina.getNome());
            stmt.setInt(3, disciplina.getCargaHoraria());
            stmt.setString(4, disciplina.getProfessorResponsavel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar disciplina: " + e.getMessage());
        }
    }

    @Override
    public void update(String codigo, Disciplina disciplina) {
        String sql = "UPDATE disciplina SET nome = ?, cargaHoraria = ?, professorResponsavel = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCargaHoraria());
            stmt.setString(3, disciplina.getProfessorResponsavel());
            stmt.setString(4, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar disciplina: " + e.getMessage());
        }
    }

    @Override
    public void delete(String codigo) {
        String sql = "DELETE FROM disciplina WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar disciplina: " + e.getMessage());
        }
    }

    @Override
    public Disciplina find(String codigo) {
        String sql = "SELECT * FROM disciplina WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Disciplina(
                            rs.getString("codigo"),
                            rs.getString("nome"),
                            rs.getInt("cargaHoraria"),
                            rs.getString("professorResponsavel")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar disciplina: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Disciplina> findAll() {
        String sql = "SELECT * FROM disciplina";
        List<Disciplina> disciplinas = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                disciplinas.add(new Disciplina(
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getInt("cargaHoraria"),
                        rs.getString("professorResponsavel")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar disciplinas: " + e.getMessage());
        }
        return disciplinas;
    }
}
