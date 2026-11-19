package br.com.fiap.heatwatch.dominio;

import java.util.Random;

public class SensorSobrecarga implements Sensor {

    private Random random = new Random();

    @Override
    public double lerValor() {
        return 20 + random.nextDouble() * 80;
    }

    @Override
    public boolean verificarFuncionamento() {
        return true;
    }

    @Override
    public String retornarTipo() {
        return "Sobrecarga Elétrica";
    }
}
