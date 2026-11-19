package br.com.fiap.heatwatch.dominio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Medicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoSensor;
    private String regiao;
    private double valor;
    private LocalDateTime dataHora;

    public Medicao() {
    }

    public Medicao(String tipoSensor, String regiao, double valor) {
        this.tipoSensor = tipoSensor;
        this.regiao = regiao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
