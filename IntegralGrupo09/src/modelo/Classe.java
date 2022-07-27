package modelo;
import java.util.HashSet;
import java.util.Set;

public class Classe {
    private String pacote;
    private Tipo tipo;
    private String nome;
    private Set<Atributo> listaAtributos = new HashSet();

    public Classe() {
    }

    public Classe(String pacote, Tipo tipo, String nome, Set<Atributo> listaAtributos) {
        this.pacote = pacote;
        this.tipo = tipo;
        this.nome = nome;
        this.listaAtributos = listaAtributos;
    } 
    
    public String getPacote() {
        return this.pacote;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            ", listaAtributos='" + getListaAtributos() + "'" +
            "}";
    }
    

}
