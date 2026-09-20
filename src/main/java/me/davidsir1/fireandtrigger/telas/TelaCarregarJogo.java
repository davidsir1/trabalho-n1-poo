package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import java.util.List;
import me.davidsir1.fireandtrigger.ContextoJogo;

import me.davidsir1.fireandtrigger.ContextoJogo;
import me.davidsir1.fireandtrigger.utilidades.GerenciadorSaves;
import me.davidsir1.fireandtrigger.utilidades.SaveData;
import me.davidsir1.fireandtrigger.entidades.classes.ClassePersonagem;

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
        List<SaveData> saves = GerenciadorSaves.listarSaves();
        
        int op;
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
        if (saves.isEmpty()) {
            do {
                System.out.println("Nenhum save encontrado.");
                System.out.println();
                System.out.println("1 - Voltar");
                System.out.print("Opção: ");
                
                op = leitura.nextInt();
                if (op != 1) System.out.println("Digite apenas o número da opção.");
            } while (op != 1);
            
            return ResultadoTela.Acao.IR_PARA_INICIAL;
        } else {
            for (int i = 0; i < saves.size(); i++) {
                SaveData save = saves.get(i);
                String classe = ClassePersonagem.valueOf(save.getClasse()).getNomeExibicao();

                System.out.printf("%-5d %-20s %-12s %-8d %-18s %-18s%n",
                        i + 1,
                        save.getNomeJogador(),
                        classe,
                        save.getNivel(),
                        "Masmorra " + save.getNivelMasmorra(),
                        save.getDataHora());
            }
        }

        System.out.println();
        System.out.println("1 - Carregar Save");
        System.out.println("2 - Voltar");
        System.out.print("Opção: ");
        op = leitura.nextInt();
        if (op < 0 || op > 2) System.out.println("Não existe essa opção!");

        int opSave;
        do {
            System.out.print("Escolha o save: ");
            opSave = leitura.nextInt();
            if (opSave < 1 || opSave > saves.size()) System.out.println("Digite apenas o número do save.");
        } while (opSave < 1 || opSave > saves.size());

        if (opSave == 0) return ResultadoTela.Acao.IR_PARA_INICIAL;

        // Executar metodo de carregar o save e após isso iniciar o jogo
        SaveData saveSelecionado = saves.get(opSave - 1);

        if (contexto.carregarJogo(saveSelecionado.getCaminhoArquivo())) {
            System.out.println("Jogo carregado com sucesso!");
            return ResultadoTela.Acao.IR_PARA_JOGO;
        }
        
        return ResultadoTela.Acao.MANTER;
    }
}
