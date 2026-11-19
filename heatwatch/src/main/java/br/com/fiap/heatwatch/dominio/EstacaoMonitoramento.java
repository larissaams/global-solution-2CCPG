package br.com.fiap.heatwatch.dominio;

public class EstacaoMonitoramento extends ComponenteTerritorial {

    public EstacaoMonitoramento(int id, String nome, String regiao) {
        super(id, nome, regiao);
    }

    @Override
    public void verificarStatus() {
        this.status = "ATIVO";
    }
}
