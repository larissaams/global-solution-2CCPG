package br.com.fiap.heatwatch.configuracao;

import br.com.fiap.heatwatch.dominio.Alerta;
import br.com.fiap.heatwatch.dominio.NivelAlerta;

public class AlertaFactory {

    public static Alerta criarAlerta(String regiao, String tipoSensor, double valor) {

        double limiteAlerta;
        double limiteCritico;

        if (tipoSensor.equals("Temperatura")) {
            limiteAlerta = 35;
            limiteCritico = 42;

        } else if (tipoSensor.equals("Consumo de Energia")) {
            limiteAlerta = 600;
            limiteCritico = 800;

        } else {
            limiteAlerta = 60;
            limiteCritico = 80;
        }

        if (valor >= limiteCritico) {
            return new Alerta(
                regiao,
                "Risco crítico detectado!",
                NivelAlerta.CRITICO
            );
        }

        if (valor >= limiteAlerta) {
            return new Alerta(
                regiao,
                "Atenção: nível elevado detectado!",
                NivelAlerta.ALERTA
            );
        }

        return new Alerta(
            regiao,
            "Nível de atenção: situação monitorada.",
            NivelAlerta.ATENCAO
        );
    }
}
