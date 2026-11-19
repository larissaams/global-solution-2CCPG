package br.com.fiap.heatwatch.dominio;

public abstract class EstrategiaPrevisao {

    protected String nomeEstrategia;

    public EstrategiaPrevisao(String nomeEstrategia) {
        this.nomeEstrategia = nomeEstrategia;
    }

    public abstract double prever(double[] valores);

    public String getNomeEstrategia() {
        return nomeEstrategia;
    }
}
