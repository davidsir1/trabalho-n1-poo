package me.davidsir1.fireandtrigger.telas;

/**
 *
 * @author david
 */
public class GerenciadorTela {
    private boolean rodando;
    private ResultadoTela.Acao estadoAtual;
    
    public GerenciadorTela() {
        this.rodando = true;
        this.estadoAtual = ResultadoTela.Acao.IR_PARA_INICIAL;
    }
    
    public void executar() {
        while (rodando) {
            TelaBase atual = null;
            switch (estadoAtual) {
                case IR_PARA_INICIAL:
                    atual = new TelaInicial();
                    break;
                case IR_PARA_NOVO_JOGO:
                    break;
                case IR_PARA_JOGO:
                    break;
                default:
                    rodando = false;
                    continue;
            }
            
            estadoAtual = atual.exibir();
        }
    }
}
