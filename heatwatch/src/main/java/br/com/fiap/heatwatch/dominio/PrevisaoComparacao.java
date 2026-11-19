package br.com.fiap.heatwatch.dominio;

public class PrevisaoComparacao extends EstrategiaPrevisao {

    public PrevisaoComparacao() {
        super("Comparação de Leituras");
    }

    @Override
    public double prever(double[] valores) {

        if (valores.length == 0) {
            return 0;
        }

        if (valores.length == 1) {
            return valores[0];
        }

        double atual = valores[valores.length - 1];
        double anterior = valores[valores.length - 2];

        return atual + (atual - anterior);
    }
}
