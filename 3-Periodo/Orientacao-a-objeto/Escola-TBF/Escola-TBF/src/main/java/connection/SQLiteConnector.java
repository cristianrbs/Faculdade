package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLiteConnector {

    private Connection connection;

    public SQLiteConnector(String dbName) throws SQLException {
        String url = "jdbc:sqlite:" + dbName;
        this.connection = DriverManager.getConnection(url);

        criarTabelaAluno();
        criarTabelaProfessor();
        criarTabelaDisciplina();
    }

    public Connection getConnection() {
        return connection;
    }

    private void criarTabelaAluno() {
        String sql = "CREATE TABLE IF NOT EXISTS aluno ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " matricula TEXT NOT NULL UNIQUE,"
                + " nome TEXT NOT NULL,"
                + " curso TEXT NOT NULL,"
                + " idade INTEGER NOT NULL"
                + " );";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela aluno: " + e.getMessage());
        }
    }

    private void criarTabelaProfessor() {
        String sql = "CREATE TABLE IF NOT EXISTS professor ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " codigo TEXT NOT NULL UNIQUE,"
                + " nome TEXT NOT NULL,"
                + " especializacao TEXT NOT NULL,"
                + " cargaHoraria INTEGER NOT NULL"
                + " );";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela professor: " + e.getMessage());
        }
    }

    private void criarTabelaDisciplina() {
        String sql = "CREATE TABLE IF NOT EXISTS disciplina ("
                + " id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + " codigo TEXT NOT NULL UNIQUE,"
                + " nome TEXT NOT NULL,"
                + " cargaHoraria INTEGER NOT NULL,"
                + " professorResponsavel TEXT NOT NULL"
                + " );";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela disciplina: " + e.getMessage());
        }
    }
}
