package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import me.davidsir1.fireandtrigger.ContextoJogo;
import me.davidsir1.fireandtrigger.entidades.FabricaJogador;
import me.davidsir1.fireandtrigger.entidades.Jogador;
import me.davidsir1.fireandtrigger.entidades.Raca;
import me.davidsir1.fireandtrigger.entidades.classes.ClassePersonagem;

/**
 *
 * @author david
 */
public class TelaNovoJogo extends TelaBase {

    public TelaNovoJogo(ContextoJogo contexto) {
        super(contexto);
    }
    
    public void exibirFicha(Jogador jogador) {
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Classe: " + jogador.getClasse().getNomeExibicao());
        System.out.println("Raça: " + jogador.getRaca().getNomeExibicao());
        System.out.println("Sexo: " + jogador.getSexo());
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("Vida: " + jogador.getVidaAtual() + "/" + jogador.getVidaMaxima());
        System.out.println("Ataque: " + jogador.getAtaqueBase());
        System.out.println("Defesa: " + jogador.getDefesaBase());
        System.out.println("Mana: " + jogador.getManaAtual() + "/" + jogador.getManaMaxima());
    }
    
    @Override
    public ResultadoTela.Acao exibir() {
        System.out.println("====================================");
        System.out.println("CRIAÇÃO DE PERSONAGEM");

        Scanner leitura = new Scanner(System.in);
        
        // Nome
        String nome;
        do {
            System.out.print("Nome do personagem: ");
            nome = leitura.nextLine().trim();
            if (nome.isEmpty()) System.out.println("O nome não pode ser vazio.");
        } while (nome.isEmpty());

        // Classe
        int opClasse;
        do {
            System.out.println("\nEscolha a classe:");
            System.out.println("  1 - Guerreiro");
            System.out.println("  2 - Arqueiro");
            System.out.println("  3 - Mago");
            System.out.print("Opção: ");
            opClasse = leitura.nextInt();
            if (opClasse <= 0 || opClasse > 3) System.out.println("Apenas valores de 1 à 3.");
        } while (opClasse <= 0 || opClasse > 3);
        
        ClassePersonagem classe = ClassePersonagem.values()[opClasse - 1];

        // Raça
        int opRaca;
        do {
            System.out.println("\nEscolha a raça:");
            System.out.println("  1 - Humano");
            System.out.println("  2 - Elfo");
            System.out.println("  3 - Anão");
            System.out.print("Opção: ");
            opRaca = leitura.nextInt();
            if (opRaca <= 0 || opRaca > 3) System.out.println("Apenas valores de 1 à 3.");
        } while (opRaca <= 0 || opRaca > 3);
        
        Raca raca = Raca.values()[opRaca - 1];

        // Sexo
        int opSexo;
        do {
            System.out.println("\nEscolha o sexo:");
            System.out.println("  1 - Masculino");
            System.out.println("  2 - Feminino");
            System.out.print("Opção: ");
            opSexo = leitura.nextInt();
            if (opSexo <= 0 || opSexo > 2) System.out.println("Apenas valores 1 e 2.");
        } while (opSexo <= 0 || opSexo > 2);
        
        String sexo = (opSexo == 1 ? "Masculino" : "Feminino");

        // Exibir prévia
        System.out.println("====================================");
        System.out.println("PRÉVIA DO PERSONAGEM");
        Jogador novoJogador = FabricaJogador.criarJogador(nome, classe, raca, sexo);
        exibirFicha(novoJogador);

        int opConfirmar;
        do {
            System.out.println("\n1 - Confirmar e iniciar");
            System.out.println("2 - Refazer");
            System.out.println("3 - Voltar ao menu inicial");
            System.out.print("Opção: ");
            opConfirmar = leitura.nextInt();
            if (opRaca <= 0 || opRaca > 3) System.out.println("Apenas valores de 1 à 3.");
        } while (opConfirmar <= 0 || opConfirmar > 3);

        if (opConfirmar == 1) {
            contexto.setJogador(novoJogador);
            return ResultadoTela.Acao.IR_PARA_JOGO;
        } else if (opConfirmar == 2) {
            return ResultadoTela.Acao.IR_PARA_NOVO_JOGO;
        } else {
            return ResultadoTela.Acao.IR_PARA_INICIAL;
        }
    }
}
