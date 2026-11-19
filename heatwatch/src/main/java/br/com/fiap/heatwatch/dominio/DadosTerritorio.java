package br.com.fiap.heatwatch.dominio;

import br.com.fiap.heatwatch.excecao.DadosInvalidosException;

public class DadosTerritorio {

    private String regiao;
    private double limiteTemperatura;
    private double limiteEnergia;

    public DadosTerritorio(String regiao, double limiteTemperatura, double limiteEnergia) {

        if (regiao == null || regiao.isBlank()
                || limiteTemperatura <= 0 || limiteEnergia <= 0) {
            throw new DadosInvalidosException("Dados do território inválidos!");
        }

        this.regiao = regiao;
        this.limiteTemperatura = limiteTemperatura;
        this.limiteEnergia = limiteEnergia;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getLimiteTemperatura() {
        return limiteTemperatura;
    }

    public double getLimiteEnergia() {
        return limiteEnergia;
    }

    public void setLimiteTemperatura(double limiteTemperatura) {
        if (limiteTemperatura <= 0) {
            throw new DadosInvalidosException("Limite de temperatura inválido!");
        }
        this.limiteTemperatura = limiteTemperatura;
    }

    public void setLimiteEnergia(double limiteEnergia) {
        if (limiteEnergia <= 0) {
            throw new DadosInvalidosException("Limite de energia inválido!");
        }
        this.limiteEnergia = limiteEnergia;
    }
}
