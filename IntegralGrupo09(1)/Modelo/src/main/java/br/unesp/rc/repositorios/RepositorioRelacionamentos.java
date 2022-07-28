package br.unesp.rc.repositorios;

import br.unesp.rc.modelo.Relacionamento;

public interface RepositorioRelacionamentos {
    void cadastrar(Relacionamento relacionamento);

    void listarRelacionamentos();
}
