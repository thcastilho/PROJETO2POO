package repositorios;

import modelo.Classe;

public interface RepositorioClasses {
    void cadastrar(Classe classe);

    void atualizar(String nome);

    boolean checarExistencia(String nome);

    Classe retornaClasse(String nome);

    void listarClasses();
}
