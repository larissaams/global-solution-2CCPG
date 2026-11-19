package br.com.fiap.heatwatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import br.com.fiap.heatwatch.servico.*;
import br.com.fiap.heatwatch.dominio.*;
import br.com.fiap.heatwatch.excecao.DadosInvalidosException;
import br.com.fiap.heatwatch.excecao.FonteIndisponivelException;
import br.com.fiap.heatwatch.configuracao.AlertaFactory;

import java.util.Scanner;

@SpringBootApplication
public class HeatwatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeatwatchApplication.class, args);
    }

    @Bean
    @org.springframework.boot.autoconfigure.condition.ConditionalOnProperty(
        name = "heatwatch.menu.enabled",
        havingValue = "true",
        matchIfMissing = true
    )
    CommandLineRunner executar(
            MonitoramentoService monitoramentoService,
            PrevisaoService previsaoService) {

        return args -> {
            Scanner scanner = new Scanner(System.in);
            SensorService sensorService = new SensorService();

            int opcao;

            do {
                System.out.println("\n===== HEATWATCH =====");
                System.out.println("1 - Registrar temperatura");
                System.out.println("2 - Registrar consumo de energia");
                System.out.println("3 - Listar medições");
                System.out.println("4 - Listar alertas");
                System.out.println("5 - Registrar sobrecarga elétrica");
                System.out.println("6 - Consultar medições por sensor");
                System.out.println("7 - Gerar previsão");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                    case 2:
                    case 5:
                        scanner.nextLine();
                        System.out.print("Digite a região: ");
                        String regiao = scanner.nextLine();

                        Sensor sensor;

                        if (opcao == 1) {
                            sensor = new SensorTemperatura();
                        } else if (opcao == 2) {
                            sensor = new SensorConsumoEnergia();
                        } else {
                            sensor = new SensorSobrecarga();
                        }

                        Medicao medicao;

                        try {
                            medicao = sensorService.realizarLeitura(sensor, regiao);
                        } catch (DadosInvalidosException | FonteIndisponivelException e) {
                            System.out.println("Erro: " + e.getMessage());
                            break;
                        }

                        monitoramentoService.registrarMedicao(
                            medicao.getTipoSensor(),
                            medicao.getRegiao(),
                            medicao.getValor()
                        );

                        monitoramentoService.registrarMedicao(
                            medicao.getTipoSensor(),
                            medicao.getRegiao(),
                            medicao.getValor()
                        );

                        System.out.println("Leitura registrada: " + medicao.getValor());

                        Alerta alerta = AlertaFactory.criarAlerta(
                         regiao,
                        medicao.getTipoSensor(),
                        medicao.getValor()
                        );

                        monitoramentoService.registrarAlerta(
                            alerta.getRegiao(),
                            alerta.getMensagem(),
                            alerta.getNivel()
                        );

                        System.out.println("Alerta: " + alerta.getNivel());
                        break;

                    case 3:
                        monitoramentoService.listarMedicoes().forEach(m ->
                            System.out.println(
                                m.getTipoSensor() + " | " +
                                m.getRegiao() + " | " +
                                m.getValor() + " | " +
                                m.getDataHora()
                            )
                        );
                        break;

                    case 4:
                        monitoramentoService.listarAlertas().forEach(a ->
                            System.out.println(
                                a.getRegiao() + " | " +
                                a.getNivel() + " | " +
                                a.getMensagem()
                            )
                        );
                        break;

                    case 6:
                        scanner.nextLine();
                        System.out.println("Digite o tipo do sensor:");
                        System.out.println("Temperatura");
                        System.out.println("Consumo de Energia");
                        System.out.println("Sobrecarga Elétrica");
                        System.out.print("Tipo: ");

                        String tipo = scanner.nextLine();

                        monitoramentoService.listarMedicoesPorSensor(tipo)
                            .forEach(m ->
                                System.out.println(
                                    m.getTipoSensor() + " | " +
                                    m.getRegiao() + " | " +
                                    m.getValor() + " | " +
                                    m.getDataHora()
                                )
                            );
                        break;

                    case 7:
                        System.out.println("Escolha a estratégia:");
                        System.out.println("1 - Média Móvel");
                        System.out.println("2 - Comparação de Leituras");
                        System.out.print("Escolha: ");

                        int estrategiaEscolhida = scanner.nextInt();

                        double[] valores = {30, 35, 40};

                        EstrategiaPrevisao estrategia;

                        if (estrategiaEscolhida == 1) {
                            estrategia = new PrevisaoMediaMovel();
                        } else if (estrategiaEscolhida == 2) {
                            estrategia = new PrevisaoComparacao();
                        } else {
                            System.out.println("Estratégia inválida!");
                            break;
                        }

                        double resultado = previsaoService.gerarPrevisao(
                            estrategia, valores
                        );

                        System.out.println(
                            "Previsão usando " + estrategia.getNomeEstrategia()
                        );
                        System.out.println("Resultado: " + resultado);
                        break;

                    case 0:
                        System.out.println("Encerrando o HeatWatch...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } while (opcao != 0);
        };
    }
}
