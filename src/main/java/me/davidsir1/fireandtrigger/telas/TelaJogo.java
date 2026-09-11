package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import me.davidsir1.fireandtrigger.ContextoJogo;

/**
 *
 * @author 
 */
public class TelaJogo extends TelaBase{
    
    public TelaJogo(ContextoJogo contexto) {
        super(contexto);
    }
    
    @Override
    public ResultadoTela.Acao exibir() {
        Scanner leitura = new Scanner(System.in);
        
        int opAcao;
        do {
            System.out.println("====================================");
            System.out.println("MASMORRA " + contexto.getNivelMasmorra());
            
            System.out.println();
            System.out.println("EXIBIR A FICHA AQUI!");
            
            System.out.println();
            System.out.println("Última Mensagem: ");
            System.out.println("> Você acordou..."); // Exibir mensagem de ação do jogador
            
            System.out.println();
            System.out.println("1 - Explorar Masmorra");
            System.out.println("2 - Usar Item");
            System.out.println("3 - Exibir Status");
            System.out.println("4 - Opções");
            System.out.println("====================================");
            System.out.print("Opção: ");
            opAcao = leitura.nextInt();
            if (opAcao <= 0 || opAcao > 4) System.out.println("Não existe essa opção!");
        } while (opAcao <= 0 || opAcao > 4);
        
        switch (opAcao) {
            case 1:
                // Evento de exploração
                break;
            case 2:
                // Utilizar Item
                break;
            case 3:
                // Exibir detalhes do jogador
                break;
            case 4:
                int opOpcao;
                do {
                    System.out.println("====================================");
                    System.out.println("1 - Salvar Jogo");
                    System.out.println("2 - Sair");
                    System.out.println("3 - Voltar ao Jogo");
                    System.out.print("Opção: ");
                    opOpcao = leitura.nextInt();
                    if (opOpcao <= 0 || opOpcao > 3) System.out.println("Não existe essa opção!");
                } while (opOpcao <= 0 || opOpcao > 3);
                
                if (opOpcao == 1) {
                    // Escrever metodo para salvar jogo
                } else if (opOpcao == 2) {
                    return ResultadoTela.Acao.SAIR;
                } else {
                    return ResultadoTela.Acao.MANTER;
                }
                break;
            default:
        }
        
        // Uma condição para verificar se o jogador morreu
        
        return ResultadoTela.Acao.MANTER;
    }
}
