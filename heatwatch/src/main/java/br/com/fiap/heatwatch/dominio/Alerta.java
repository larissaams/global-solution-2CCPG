package br.com.fiap.heatwatch.dominio;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String regiao;
    private String mensagem;

    @Enumerated(EnumType.STRING)
    private NivelAlerta nivel;

    private LocalDateTime dataHora;

    public Alerta() {
    }

    public Alerta(String regiao, String mensagem, NivelAlerta nivel) {
        this.regiao = regiao;
        this.mensagem = mensagem;
        this.nivel = nivel;
        this.dataHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public NivelAlerta getNivel() {
        return nivel;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
