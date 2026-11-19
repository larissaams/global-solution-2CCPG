package br.com.fiap.heatwatch.excecao;

public class FonteIndisponivelException extends RuntimeException {

    public FonteIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
