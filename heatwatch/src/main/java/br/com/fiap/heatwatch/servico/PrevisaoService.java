package br.com.fiap.heatwatch.servico;

import br.com.fiap.heatwatch.dominio.EstrategiaPrevisao;
import br.com.fiap.heatwatch.excecao.DadosInvalidosException;
import org.springframework.stereotype.Service;

@Service
public class PrevisaoService {

    public double gerarPrevisao(EstrategiaPrevisao estrategia, double[] valores) {

        if (estrategia == null || valores == null || valores.length == 0) {
            throw new DadosInvalidosException("Dados da previsão inválidos!");
        }

        return estrategia.prever(valores);
    }
}
