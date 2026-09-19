package me.davidsir1.fireandtrigger.telas;

/**
 *
 * @author david
 */
public class ResultadoTela {
    public enum Acao {
        MANTER,
        IR_PARA_INICIAL,
        IR_PARA_NOVO_JOGO,
        IR_PARA_CARREGAR_JOGO,
        IR_PARA_JOGO,
        JOGADOR_MORREU,
        SAIR
    }
    
    private Acao acao;
}
