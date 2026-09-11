package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import me.davidsir1.fireandtrigger.ContextoJogo;

/**
 *
 * @author david
 */
public class TelaInicial extends TelaBase {

    public TelaInicial(ContextoJogo contexto) {
        super(contexto);
    }
    
    @Override
    public ResultadoTela.Acao exibir() {
        Scanner leitura = new Scanner(System.in);
                
        System.out.println("F I R E  A N D  T R I G G E R");
        System.out.println();
        System.out.println("1 - Começar Jogo");
        System.out.println("2 - Carregar Jogo");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma Opção: ");
        int opcao = leitura.nextInt();
        
        if (opcao == 1) {
            return ResultadoTela.Acao.IR_PARA_NOVO_JOGO;
        } else if (opcao == 2) {
            return ResultadoTela.Acao.IR_PARA_CARREGAR_JOGO;
        } else if (opcao == 3) {
            return ResultadoTela.Acao.SAIR;
        } else {
            return ResultadoTela.Acao.MANTER;
        }
    }
}
