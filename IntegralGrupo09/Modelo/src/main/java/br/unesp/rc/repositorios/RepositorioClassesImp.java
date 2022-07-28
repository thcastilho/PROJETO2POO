package br.unesp.rc.repositorios;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import br.unesp.rc.modelo.Atributo;
import br.unesp.rc.modelo.Classe;

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
        for (Classe c : listaClasses) {
            if (c.getNome().equals(classe.getNome())) {
                System.out.println("Ja existe uma classe com esse nome!");
                return;
            }
        }
        listaClasses.add(classe);
        System.out.println("Classe criada com sucesso!");
    }

    @Override
    public void atualizar(String nome) {
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

    private String escanearString() {
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
    public boolean checarExistencia(String nome) {
        for (Classe c : listaClasses) {
            if (c.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Classe retornaClasse(String nome) {
        for (Classe c : listaClasses) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }
    
}
