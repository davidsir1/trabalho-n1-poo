package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import me.davidsir1.fireandtrigger.ContextoJogo;

/**
 *
 * @author 
 */
public class TelaCarregarJogo extends TelaBase {

    public TelaCarregarJogo(ContextoJogo contexto) {
        super(contexto);
    }

    @Override
    public ResultadoTela.Acao exibir() {
        Scanner leitura = new Scanner(System.in);
        int op;
        do {
            System.out.println("====================================");
            System.out.println("CARRAGER JOGO");
            
            /*
            Esse trecho aqui será feito a leitura da pasta que contém
            o 'saves' do jogador
            A exibição da lista deve ser a seguinte:
            Indice - Nome do Jogador - Classe - Nível - Masmorra Atual - Data do Save
            Exemplo:
            1 - Dovahkin - Guerreiro - 10 - Masmorra 25 - 11/09/2026
            */
            
            System.out.println();
            System.out.println("1 - Carregar Save");
            System.out.println("2 - Voltar");
            System.out.print("Opção: ");
            op = leitura.nextInt();
            if (op < 0 || op > 2) System.out.println("Não existe essa opção!");
        } while (op < 0 || op > 2);
        
        switch (op) {
            case 1:
                // Executar metodo de carregar o save e após isso
                // começar o jogo
                break;
            case 2:
                return ResultadoTela.Acao.IR_PARA_INICIAL;
        }
        
        return ResultadoTela.Acao.MANTER;
    }
}
