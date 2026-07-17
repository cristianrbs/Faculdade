package dao;

import java.util.List;

/**
 * Contrato de persistência (Inversão de Dependência).
 * O Controller depende apenas desta abstração, nunca de uma
 * implementação concreta (Banco ou Arquivo) — a implementação é
 * injetada em tempo de execução (Dependency Injection via construtor).
 *
 * @param <T> tipo da entidade manipulada (Aluno, Professor, Disciplina...)
 * @author kaynã
 */
public interface IDao<T> {

    void save(T objeto);

    void update(String id, T objeto);

    void delete(String id);

    T find(String id);

    List<T> findAll();
}
