package br.com.fiap.heatwatch.servico;

import br.com.fiap.heatwatch.dominio.*;
import br.com.fiap.heatwatch.excecao.FonteIndisponivelException;
import br.com.fiap.heatwatch.excecao.DadosInvalidosException;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    public Medicao realizarLeitura(Sensor sensor, String regiao) {

        if (sensor == null || regiao == null || regiao.isBlank()) {
            throw new DadosInvalidosException(
                "Sensor ou região inválidos!"
            );
        }

        if (!sensor.verificarFuncionamento()) {
            throw new FonteIndisponivelException(
                "Sensor " + sensor.retornarTipo() + " indisponível!"
            );
        }

        double valor = sensor.lerValor();

        return new Medicao(sensor.retornarTipo(), regiao, valor);
    }
}
