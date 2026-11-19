package br.com.fiap.heatwatch.dominio;

import java.util.Random;

public class SensorTemperatura implements Sensor {

    private Random random = new Random();

    @Override
    public double lerValor() {
        return 25 + random.nextDouble() * 25;
    }

    @Override
    public boolean verificarFuncionamento() {
        return true;
    }

    @Override
    public String retornarTipo() {
        return "Temperatura";
    }
}
