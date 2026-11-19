package br.com.fiap.heatwatch.dominio;

public interface Sensor {

    double lerValor();

    boolean verificarFuncionamento();

    String retornarTipo();

}
