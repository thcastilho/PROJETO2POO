package repositorios;

import modelo.Classe;

public interface RepositorioClasses {
    void cadastrar(Classe classe);

    void atualizar(String nome);

    void listarClasses();

    StringBuilder gerarCodigo();

    StringBuilder gerarCodigoUML();
}
