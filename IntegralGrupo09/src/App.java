import java.util.Scanner;

import modelo.Atributo;
import modelo.Classe;
import repositorios.RepositorioClasses;
import repositorios.RepositorioClassesImp;

public class App {
    static RepositorioClasses listaClasses = new RepositorioClassesImp();
    public static void main(String[] args) throws Exception {
        int opcao;

        do {
            printaMenu();
            System.out.printf("Opção: ");
            opcao = escanearInteiro();
            switch(opcao) {
                case 1:
                    criarClasse();
                    break;

                case 2:
                    addAtributo();
                    break;

                case 3:
                    relacionarClasses();
                    break;

                case 4:
                    criarTXT();
                    break;

                case 5:
                    criarJSON();
                    break;

                case 6:
                    criarPUML();
                    break;

                case 7:
                    abrirArquivo();
                    break;

                case 0:
                    encerrarPrograma();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }while(opcao != 0);
    }

    private static String escanearString() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
    
    private static int escanearInteiro() {
        Scanner scanner = new Scanner(System.in);

        return Integer.parseInt(escanearString());
    }

    private static void printaMenu() {
        System.out.println("---------------------------------");
        System.out.println("1 - Criar uma nova classe");
        System.out.println("2 - Adicionar atributos a uma classe");
        System.out.println("3 - Definir relacionamentos");
        System.out.println("4 - Criar arquivo .txt");
        System.out.println("5 - Criar arquivo .json");
        System.out.println("6 - Criar arquivo .puml");
        System.out.println("7 - Abrir arquivo");
        System.out.println("0 - Encerrar programa");
        System.out.println("--------------------------------");
    }

    private static void criarClasse() {
        Classe classe = new Classe();

        System.out.printf("Digite o nome do pacote: ");
        classe.setPacote(escanearString());
        System.out.println();

        boolean b = false;
        do {
            System.out.printf("Digite o tipo da classe (class, abstract class ou interface): ");
            String aux = escanearString();
            if (aux.equals("class") || aux.equals("abstract class") || aux.equals("interface")) {
                classe.setTipo(aux);
                b = true;
            } else System.out.println("Tipo inválido!");
        }while(!b);
        System.out.println();

        System.out.printf("Digite o nome da classe: ");
        classe.setNome(escanearString());
        System.out.println();

        if (classe.getTipo().equals("class") || classe.getTipo().equals("abstract class")) {
            int n;
            System.out.printf("Entre com o número de atributos da classe: ");
            n = escanearInteiro();

            for(int i = 1; i <= n; i++) {
                Atributo atributo = new Atributo();

                System.out.println("-----------" + i + "-----------");

                System.out.printf("Modificador: ");
                atributo.setModificador(escanearString());
                //System.out.println();

                System.out.printf("Tipo: ");
                atributo.setTipo(escanearString());
                //System.out.println();

                System.out.printf("Nome: ");
                atributo.setNome(escanearString());
                //System.out.println();

                classe.addAtributo(atributo);
            }
        }

        listaClasses.cadastrar(classe);
    }

    private static void addAtributo() {
        listaClasses.listarClasses();

        String nome;
        System.out.printf("Digite o nome da classe que irá ser alterada: ");
        nome = escanearString();

        listaClasses.atualizar(nome);
    }

    private static void relacionarClasses() {
        
    }

    private static void criarTXT() {
        
    }

    private static void criarJSON() {
        
    }

    private static void criarPUML() {
        
    }

    private static void abrirArquivo() {
        
    }

    private static void encerrarPrograma() {
        
    }
}
