package br.com.fiap.heatwatch.dominio;

public class PrevisaoMediaMovel extends EstrategiaPrevisao {

    public PrevisaoMediaMovel() {
        super("Média Móvel");
    }

    @Override
    public double prever(double[] valores) {

        if (valores.length == 0) {
            return 0;
        }

        double soma = 0;

        for (double valor : valores) {
            soma += valor;
        }

        return soma / valores.length;
    }
}
