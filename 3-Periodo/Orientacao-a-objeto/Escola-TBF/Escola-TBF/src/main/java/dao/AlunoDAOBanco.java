package dao;

import classes.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AlunoDAOBanco implements IDao<Aluno> {

    private Connection connection;

    public AlunoDAOBanco(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Aluno aluno) {
        String sql = "INSERT INTO aluno (matricula, nome, curso, idade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getIdade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    @Override
    public void update(String matricula, Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, curso = ?, idade = ? WHERE matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCurso());
            stmt.setInt(3, aluno.getIdade());
            stmt.setString(4, matricula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    @Override
    public void delete(String matricula) {
        String sql = "DELETE FROM aluno WHERE matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        }
    }

    @Override
    public Aluno find(String matricula) {
        String sql = "SELECT * FROM aluno WHERE matricula = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, matricula);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Aluno(
                            rs.getString("matricula"),
                            rs.getString("nome"),
                            rs.getString("curso"),
                            rs.getInt("idade")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                alunos.add(new Aluno(
                        rs.getString("matricula"),
                        rs.getString("nome"),
                        rs.getString("curso"),
                        rs.getInt("idade")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        }
        return alunos;
    }
}
