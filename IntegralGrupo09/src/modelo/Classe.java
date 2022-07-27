package modelo;
import java.util.HashSet;
import java.util.Set;

public class Classe {
    private String pacote;
    private String nome;
    private Set<Atributo> listaAtributos = new HashSet();

    public Classe() {
    }

    public Classe(String pacote, String nome, Set<Atributo> listaAtributos) {
        this.pacote = pacote;
        this.nome = nome;
        this.listaAtributos = listaAtributos;
    } 
    
    public String getPacote() {
        return this.pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Atributo> getListaAtributos() {
        return listaAtributos;
    }

    public void setListaAtributos(Set<Atributo> listaAtributos) {
        this.listaAtributos = listaAtributos;
    }
    
    public void addAtributo(Atributo a) {
        listaAtributos.add(a);
    }

    @Override
    public String toString() {
        return "{" +
            " pacote='" + getPacote() + "'" +
            ", nome='" + getNome() + "'" +
            ", listaAtributos='" + getListaAtributos() + "'" +
            "}";
    }
    
}
