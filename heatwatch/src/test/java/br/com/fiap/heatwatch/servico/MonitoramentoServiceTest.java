package br.com.fiap.heatwatch.servico;

import br.com.fiap.heatwatch.dominio.*;
import br.com.fiap.heatwatch.persistencia.MedicaoRepository;
import br.com.fiap.heatwatch.persistencia.AlertaRepository;
import br.com.fiap.heatwatch.excecao.DadosInvalidosException;
import br.com.fiap.heatwatch.excecao.FonteIndisponivelException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;

class MonitoramentoServiceTest {

    @Test
    void deveRegistrarMedicaoComSucesso() {

        // Arrange
        MedicaoRepository medicaoRepository = Mockito.mock(MedicaoRepository.class);
        AlertaRepository alertaRepository = Mockito.mock(AlertaRepository.class);

        MonitoramentoService service = new MonitoramentoService(
            medicaoRepository, alertaRepository
        );

        Medicao medicao = new Medicao("Temperatura", "Centro", 35.0);

        Mockito.when(medicaoRepository.save(Mockito.any(Medicao.class)))
               .thenReturn(medicao);

        // Act
        Medicao resultado = service.registrarMedicao(
            "Temperatura", "Centro", 35.0
        );

        // Assert
        assertEquals(35.0, resultado.getValor());
        Mockito.verify(medicaoRepository).save(Mockito.any(Medicao.class));
    }

    @Test
    void deveLancarErroQuandoRegiaoForVazia() {

        // Arrange
        MedicaoRepository medicaoRepository = Mockito.mock(MedicaoRepository.class);
        AlertaRepository alertaRepository = Mockito.mock(AlertaRepository.class);

        MonitoramentoService service = new MonitoramentoService(
            medicaoRepository, alertaRepository
        );

        // Act e Assert
        assertThrows(DadosInvalidosException.class, () ->
            service.registrarMedicao("Temperatura", "", 35.0)
        );
    }

    @Test
    void deveRegistrarAlertaComSucesso() {

        MedicaoRepository medicaoRepository = Mockito.mock(MedicaoRepository.class);
        AlertaRepository alertaRepository = Mockito.mock(AlertaRepository.class);

        MonitoramentoService service = new MonitoramentoService(
            medicaoRepository, alertaRepository
        );

        Alerta alerta = new Alerta(
            "Centro", "Consumo elevado", NivelAlerta.ALERTA
        );

        Mockito.when(alertaRepository.save(Mockito.any(Alerta.class)))
               .thenReturn(alerta);

        Alerta resultado = service.registrarAlerta(
            "Centro", "Consumo elevado", NivelAlerta.ALERTA
        );

        assertEquals(NivelAlerta.ALERTA, resultado.getNivel());
    }

    @Test
    void deveListarMedicoes() {

        MedicaoRepository medicaoRepository = Mockito.mock(MedicaoRepository.class);
        AlertaRepository alertaRepository = Mockito.mock(AlertaRepository.class);

        MonitoramentoService service = new MonitoramentoService(
            medicaoRepository, alertaRepository
        );

        Mockito.when(medicaoRepository.findAll())
               .thenReturn(java.util.List.of(
                   new Medicao("Temperatura", "Centro", 35.0)
               ));

        assertEquals(1, service.listarMedicoes().size());
    }

    @Test
    void deveListarAlertas() {

        MedicaoRepository medicaoRepository = Mockito.mock(MedicaoRepository.class);
        AlertaRepository alertaRepository = Mockito.mock(AlertaRepository.class);

        MonitoramentoService service = new MonitoramentoService(
            medicaoRepository, alertaRepository
        );

        Mockito.when(alertaRepository.findAll())
               .thenReturn(java.util.List.of(
                   new Alerta("Centro", "Consumo elevado", NivelAlerta.ALERTA)
               ));

        assertEquals(1, service.listarAlertas().size());
    }

    @Test
    void deveLancarErroQuandoSensorEstiverIndisponivel() {

        SensorService service = new SensorService();

        Sensor sensor = new Sensor() {

            @Override
            public double lerValor() {
                return 0;
            }

            @Override
            public boolean verificarFuncionamento() {
                return false;
            }

            @Override
            public String retornarTipo() {
                return "Temperatura";
            }
        };

        assertThrows(FonteIndisponivelException.class, () ->
            service.realizarLeitura(sensor, "Centro")
        );
    }
}
