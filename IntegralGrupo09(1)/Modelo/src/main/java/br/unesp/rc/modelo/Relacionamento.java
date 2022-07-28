package br.unesp.rc.modelo;

public class Relacionamento {
    private Classe classePai;
    private Classe classeFilho;
    private String relacao;
    private String multiplicidade;

    public Relacionamento() {
    }
    
    public Relacionamento(Classe classePai, Classe classeFilho, String relacao, String multiplicidade) {
        this.classePai = classePai;
        this.classeFilho = classeFilho;
        this.relacao = relacao;
        this.multiplicidade = multiplicidade;
    }

    public Classe getClassePai() {
        return classePai;
    }

    public void setClassePai(Classe classePai) {
        this.classePai = classePai;
    }

    public Classe getClasseFilho() {
        return classeFilho;
    }

    public void setClasseFilho(Classe classeFilho) {
        this.classeFilho = classeFilho;
    }

    public String getRelacao() {
        return relacao;
    }

    public void setRelacao(String relacao) {
        this.relacao = relacao;
    }
    
    public String getMultiplicidade() {
        return multiplicidade;
    }

    public void setMultiplicidade(String multiplicidade) {
        this.multiplicidade = multiplicidade;
    }

    @Override
    public String toString() {
        return "[" +
            " classePai='" + getClassePai().getNome() + "'" +
            ", classeFilho='" + getClasseFilho().getNome() + "'" +
            ", relacao='" + getRelacao() + "'" +
            ", multiplicidade='" + getMultiplicidade() + "'" +
            "]";
    }

}
