package br.unesp.rc.modelo;
public class Atributo {
    private String modificador;
    private String tipo;
    private String nome;

    public Atributo() {
    }

    public Atributo(String modificador, String tipo, String nome) {
        this.modificador = modificador;
        this.tipo = tipo;
        this.nome = nome;
    }

    public String getModificador() {
        return this.modificador;
    }

    public void setModificador(String modificador) {
        this.modificador = modificador;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{" +
            " modificador='" + getModificador() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", nome='" + getNome() + "'" +
            "}";
    }


}

