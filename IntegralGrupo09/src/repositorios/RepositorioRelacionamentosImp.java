package repositorios;

import java.util.HashSet;
import java.util.Set;

import modelo.Relacionamento;

public class RepositorioRelacionamentosImp implements RepositorioRelacionamentos{
    private static Set<Relacionamento> listaRelacionamentos = new HashSet<>();
    
    @Override
    public void cadastrar(Relacionamento relacionamento) {
        if(listaRelacionamentos.contains(relacionamento)) {
            System.out.println("Esse relacionamento já existe!");
            return;
        } else listaRelacionamentos.add(relacionamento);
    }

    @Override
    public void listarRelacionamentos() {
        for (Relacionamento r : listaRelacionamentos) {
            System.out.println(r);
        }
    }
    
}
