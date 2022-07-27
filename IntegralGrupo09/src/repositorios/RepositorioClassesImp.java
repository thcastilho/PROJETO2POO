package repositorios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import modelo.Atributo;
import modelo.Classe;

public class RepositorioClassesImp implements RepositorioClasses {
    private static Set<Classe> listaClasses = new HashSet<>();

    public static Set<Classe> getListaClasses() {
        return listaClasses;
    }

    public static void setListaClasses(Set<Classe> listaClasses) {
        RepositorioClassesImp.listaClasses = listaClasses;
    }

    @Override
    public void cadastrar(Classe classe) {
        if (listaClasses.contains(classe)) {
            System.out.println("Classe já criada anteriormente!");
            return;
        } else {
            listaClasses.add(classe);
            System.out.println("Classe criada com sucesso!");
        }
    }

    @Override
    public void atualizar(String nome) {
        boolean b = false;
        for (Classe c : listaClasses) {
            if (c.getNome().equals(nome)) {
                Atributo atributo = new Atributo();

                System.out.printf("Modificador: ");
                atributo.setModificador(escanearString());
                //System.out.println();

                System.out.printf("Tipo: ");
                atributo.setTipo(escanearString());
                //System.out.println();

                System.out.printf("Nome: ");
                atributo.setNome(escanearString());
                //System.out.println();

                c.addAtributo(atributo);
            }
        }
    }

    private static String escanearString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    @Override
    public void listarClasses() {
        for (Classe c : listaClasses) {
            System.out.println(c);
        }
    }

    @Override
    public StringBuilder gerarCodigo() {
        return null;
    }

    @Override
    public StringBuilder gerarCodigoUML() {
        return null;
    }
    
}
