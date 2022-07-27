package repositorios;

import modelo.Classe;

public interface RepositorioClasses {
    void cadastrar(Classe classe);

    void atualizar(Classe classe);

    void gerarCodigo();

    void gerarCodigoUML();
}
