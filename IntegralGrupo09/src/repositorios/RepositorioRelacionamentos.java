package repositorios;

import modelo.Relacionamento;

public interface RepositorioRelacionamentos {
    void cadastrar(Relacionamento relacionamento);

    void listarRelacionamentos();
}
