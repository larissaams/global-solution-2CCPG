package br.com.fiap.heatwatch.dominio;

public abstract class ComponenteTerritorial {

    protected int id;
    protected String nome;
    protected String regiao;
    protected String status;

    public ComponenteTerritorial(int id, String nome, String regiao) {
        this.id = id;
        this.nome = nome;
        this.regiao = regiao;
        this.status = "ATIVO";
    }

    public abstract void verificarStatus();

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getStatus() {
        return status;
    }
}
