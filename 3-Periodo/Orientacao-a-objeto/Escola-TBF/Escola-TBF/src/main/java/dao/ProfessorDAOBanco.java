package dao;

import classes.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProfessorDAOBanco implements IDao<Professor> {

    private Connection connection;

    public ProfessorDAOBanco(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Professor professor) {
        String sql = "INSERT INTO professor (codigo, nome, especializacao, cargaHoraria) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getCodigo());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getEspecializacao());
            stmt.setInt(4, professor.getCargaHoraria());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar professor: " + e.getMessage());
        }
    }

    @Override
    public void update(String codigo, Professor professor) {
        String sql = "UPDATE professor SET nome = ?, especializacao = ?, cargaHoraria = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEspecializacao());
            stmt.setInt(3, professor.getCargaHoraria());
            stmt.setString(4, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar professor: " + e.getMessage());
        }
    }

    @Override
    public void delete(String codigo) {
        String sql = "DELETE FROM professor WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        }
    }

    @Override
    public Professor find(String codigo) {
        String sql = "SELECT * FROM professor WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Professor(
                            rs.getString("codigo"),
                            rs.getString("nome"),
                            rs.getString("especializacao"),
                            rs.getInt("cargaHoraria")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Professor> findAll() {
        String sql = "SELECT * FROM professor";
        List<Professor> professores = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                professores.add(new Professor(
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getString("especializacao"),
                        rs.getInt("cargaHoraria")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }
        return professores;
    }
}
