package br.com.fiap.heatwatch.dominio;

import java.util.Random;

public class SensorConsumoEnergia implements Sensor {

    private Random random = new Random();

    @Override
    public double lerValor() {
        return 100 + random.nextDouble() * 900;
    }

    @Override
    public boolean verificarFuncionamento() {
        return true;
    }

    @Override
    public String retornarTipo() {
        return "Consumo de Energia";
    }
}
