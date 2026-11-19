package br.com.fiap.heatwatch.servico;

import br.com.fiap.heatwatch.dominio.*;
import br.com.fiap.heatwatch.persistencia.*;
import br.com.fiap.heatwatch.excecao.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonitoramentoService {

    private final MedicaoRepository medicaoRepository;
    private final AlertaRepository alertaRepository;

    public MonitoramentoService(MedicaoRepository medicaoRepository,
                                AlertaRepository alertaRepository) {
        this.medicaoRepository = medicaoRepository;
        this.alertaRepository = alertaRepository;
    }

    public Medicao registrarMedicao(String tipo, String regiao, double valor) {

        if (regiao == null || regiao.isBlank() || valor < 0) {
            throw new DadosInvalidosException("Dados da medição inválidos!");
        }

        Medicao medicao = new Medicao(tipo, regiao, valor);

        return medicaoRepository.save(medicao);
    }

    public Alerta registrarAlerta(String regiao, String mensagem, NivelAlerta nivel) {

        if (regiao == null || regiao.isBlank() || mensagem == null || mensagem.isBlank()) {
            throw new DadosInvalidosException("Dados do alerta inválidos!");
        }

        Alerta alerta = new Alerta(regiao, mensagem, nivel);

        return alertaRepository.save(alerta);
    }

    public List<Medicao> listarMedicoes() {
        return medicaoRepository.findAll();
}

    public List<Medicao> listarMedicoesPorSensor(String tipoSensor) {
        return medicaoRepository.findByTipoSensor(tipoSensor);
}
    public List<Alerta> listarAlertas() {
        return alertaRepository.findAll();
    }
}
