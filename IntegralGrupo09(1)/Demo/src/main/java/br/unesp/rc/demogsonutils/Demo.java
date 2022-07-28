package br.unesp.rc.demogsonutils;

import java.util.Scanner;

import br.unesp.rc.modelo.Atributo;
import br.unesp.rc.modelo.Classe;
import br.unesp.rc.modelo.Relacionamento;
import br.unesp.rc.repositorios.RepositorioClassesImp;
import br.unesp.rc.repositorios.RepositorioRelacionamentosImp;
import br.unesp.rc.arquivoutils.ArquivoUtils;
import br.unesp.rc.gsonutils.utils.GsonUtils;

public class Demo {
    static RepositorioClassesImp listaClasses = new RepositorioClassesImp();
    static RepositorioRelacionamentosImp listaRelacionamentos = new RepositorioRelacionamentosImp();
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
                    System.out.println("Encerrando programa...");
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
        System.out.println("---------------------------------");
    }
        
    private static void criarClasse() {
        Classe classe = new Classe();

        System.out.printf("Digite o nome do pacote: ");
        classe.setPacote(escanearString());
        System.out.println();

        System.out.printf("Digite o nome da classe: ");
        classe.setNome(escanearString());
        System.out.println();

        int n;
        System.out.printf("Entre com o número de atributos da classe: ");
        n = escanearInteiro();

        for(int i = 1; i <= n; i++) {
            Atributo atributo = new Atributo();

            System.out.println("-----------" + i + "-----------");

            do {
                System.out.printf("Modificador: ");
                atributo.setModificador(escanearString());
            }while(!atributo.getModificador().equals("private") && !atributo.getModificador().equals("public") && !atributo.getModificador().equals("protected"));

            System.out.printf("Tipo: ");
            atributo.setTipo(escanearString());

            System.out.printf("Nome: ");
            atributo.setNome(escanearString());

            classe.addAtributo(atributo);
    }

        listaClasses.cadastrar(classe);
    }

    private static void addAtributo() {
        listaClasses.listarClasses();

        String nome;
        do {
            System.out.printf("Digite o nome da classe que irá ser alterada: ");
            nome = escanearString();
        }while(!listaClasses.checarExistencia(nome));

        listaClasses.atualizar(nome);
    }

    private static void relacionarClasses() {
        listaRelacionamentos.listarRelacionamentos();
        listaClasses.listarClasses();

        String c1, c2;
        Classe class1, class2;
        do {
            System.out.printf("Digite o nome da classe 'pai': ");
            c1 = escanearString();
        }while(!listaClasses.checarExistencia(c1));

        class1 = listaClasses.retornaClasse(c1);

        System.out.println();

        do {
            System.out.printf("Digite o nome da classe 'filho': ");
            c2 = escanearString();
        }while(!listaClasses.checarExistencia(c2));

        class2 = listaClasses.retornaClasse(c2);

        System.out.println();

        int opcao = 0;
        do {
            System.out.println("Defina o tipo de relacionamento:");
            System.out.println("\t1 - Herança");
            System.out.println("\t2 - Composição");
            System.out.println("\t3 - Agregação");
            System.out.printf("Opção: ");
            opcao = escanearInteiro();
        }while(opcao != 1 && opcao != 2 && opcao != 3);

        String relac = null;

        switch(opcao) {
            case 1:
                relac = "Herança";
                break;
            
            case 2:
                relac = "Composição";
                break;

            case 3:
                relac = "Agregação";
                break;
        }

        String mult = null;

        if (opcao == 2 || opcao == 3) {
            opcao = 0;

            do {
                System.out.println("Defina a multiplicidade do relacionamento:");
                System.out.println("\t1 - Um para Um");
                System.out.println("\t2 - Um para Muitos");
                System.out.println("\t3 - Muitos para Muitos");
                System.out.printf("Opção: ");
                opcao = escanearInteiro();
            }while(opcao != 1 && opcao != 2 && opcao != 3);

            switch(opcao) {
                case 1:
                    mult = "1 : 1";
                    break;
                
                case 2:
                    mult = "1 : 1..*";
                    break;
    
                case 3:
                    mult = "1..* : 1..*";
                    break;
            }
        }
        Relacionamento relacionamento = new Relacionamento(class1, class2, relac, mult);

        listaRelacionamentos.cadastrar(relacionamento);
    }

    private static String criaTexto() {
        StringBuilder sb = new StringBuilder();

        sb.append("@startuml\n").append("title Exemplo\n");

        for (Classe c : RepositorioClassesImp.getListaClasses()) {
            sb.append("package " + c.getPacote() + " {\n").append("\tclass " + c.getNome()).append("\n}\n\n");

            sb.append("class " + c.getNome()).append(" {").append("\n");

            for (Atributo a : c.getListaAtributos()) {

                switch(a.getModificador()) {
                    case "public": 
                        sb.append("- ").append(a.getTipo() + " ").append(a.getNome() + "\n");
                        break;

                    case "private":
                        sb.append("+ ").append(a.getTipo() + " ").append(a.getNome() + "\n");
                        break;

                    case "protected":
                        sb.append("# ").append(a.getTipo() + " ").append(a.getNome() + "\n");
                        break;
                }

            }
            sb.append("+ " + c.getNome() + "()\n").append("}\n\n");

        }

        for (Relacionamento r : RepositorioRelacionamentosImp.getListaRelacionamentos()) {
            sb.append(r.getClassePai().getNome() + " ");

            switch(r.getRelacao()) {
                case "Herança":
                    sb.append("<|-- ");
                    break;

                case "Composição":
                    sb.append("\"").append(r.getMultiplicidade().substring(0, r.getMultiplicidade().indexOf(" :"))).append("\"").append(" ");
                    sb.append("*-- ");
                    sb.append("\"").append(r.getMultiplicidade().substring(r.getMultiplicidade().indexOf(": ")+2)).append("\"").append(" ");
                    break;

                case "Agregação":
                    sb.append("\"").append(r.getMultiplicidade().substring(0, r.getMultiplicidade().indexOf(" :"))).append("\"").append(" ");
                    sb.append("o-- ");
                    sb.append("\"").append(r.getMultiplicidade().substring(r.getMultiplicidade().indexOf(": ")+2)).append("\"").append(" ");
                    break;
            }
            
            sb.append(r.getClasseFilho().getNome()).append("\n");
        }
        sb.append("@enduml");

        return sb.toString();
    }

    private static void criarTXT() {
        String txt = criaTexto();
        System.out.println(ArquivoUtils.salvar("..//", "Exemplo.txt", txt));

    }

    private static void criarJSON() {
        String json = "{";
        for (Classe c : RepositorioClassesImp.getListaClasses()) {
            String aux = GsonUtils.objetoToXML(c);
            String aux2 = aux.substring(1, aux.length() - 1);
            json = json + aux2 + ",";
        }
        json = json.substring(0, json.length() - 1);
        json = json + "}";
        System.out.println(json);
        System.out.println(ArquivoUtils.salvar("", "Exemplo.json", json));
    }

    private static void criarPUML() {
        String puml = criaTexto();
        System.out.println(ArquivoUtils.salvar("", "Exemplo.puml", puml));
        
    }

    private static void abrirArquivo() {
        System.out.println("Digite o nome do arquivo que deseja abrir: ");
        String arquivo = "..//" + escanearString();

        System.out.println(ArquivoUtils.leitura(arquivo)); 
    }
}
