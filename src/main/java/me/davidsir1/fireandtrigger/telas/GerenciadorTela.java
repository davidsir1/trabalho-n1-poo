package me.davidsir1.fireandtrigger.telas;

import me.davidsir1.fireandtrigger.ContextoJogo;

/**
 *
 * @author david
 */
public class GerenciadorTela {
    private boolean rodando;
    private ResultadoTela.Acao estadoAtual;
    private ContextoJogo contexto;
    
    public GerenciadorTela() {
        this.rodando = true;
        this.estadoAtual = ResultadoTela.Acao.IR_PARA_INICIAL;
        this.contexto = new ContextoJogo();
    }
    
    public void executar() {
        while (rodando) {
            TelaBase atual = null;
            switch (estadoAtual) {
                case IR_PARA_INICIAL:
                    atual = new TelaInicial(contexto);
                    break;
                case IR_PARA_NOVO_JOGO:
                    atual = new TelaNovoJogo(contexto);
                    break;
                case IR_PARA_JOGO:
                    atual = new TelaJogo(contexto);
                    break;
                default:
                    rodando = false;
                    continue;
            }
            
            estadoAtual = atual.exibir();
        }
    }
}
