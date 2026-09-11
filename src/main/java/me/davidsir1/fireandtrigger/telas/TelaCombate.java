package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import me.davidsir1.fireandtrigger.ContextoJogo;

/**
 *
 * @author 
 */
public class TelaCombate extends TelaBase {
    public TelaCombate(ContextoJogo contexto) {
        super(contexto);
    }
    
    @Override
    public ResultadoTela.Acao exibir() {
        Scanner leitura = new Scanner(System.in);
        
        int opAcao;
        do {
            System.out.println("====================================");
            
            System.out.println();
            System.out.println("Jogador VS. Inimigo");
            
            System.out.println("Jogador: 100/100");
            System.out.println("Inimigo: 100/100");
            
            System.out.println();
            System.out.println("Última Mensagem: ");
            System.out.println("> Jogador desafiou o inimigo.");
            
            System.out.println();
            System.out.println("1. Atacar");
            System.out.println("2. Utilizar Habilidade Especial");
            System.out.println("3. Exibir Status");
            System.out.println("4. Usar Item");
            System.out.println("5. Fugir");
            System.out.print("Opção: ");
            opAcao = leitura.nextInt();
            if (opAcao < 1 || opAcao > 5) System.out.println("Não existe essa opção!");
        } while (opAcao < 1 || opAcao > 5);
        
        switch (opAcao) {
            case 1:
                // Utilizar metodo de ataque
                break;
            case 2:
                // Utilizar metodo de habilidade especial
                break;
            case 3:
                // Exibir o status completo do jogador
                break;
            case 4:
                // Usar poções
                break;
        }
        
        return ResultadoTela.Acao.MANTER;
    }
}
