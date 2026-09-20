package me.davidsir1.fireandtrigger;

import me.davidsir1.fireandtrigger.entidades.Jogador;
import me.davidsir1.fireandtrigger.utilidades.GerenciadorSaves;
import me.davidsir1.fireandtrigger.utilidades.SaveData;

/**
 *
 * @author david
 */
public class ContextoJogo {
    private Jogador jogador;
    private int nivelMasmorra;
    
    
    public ContextoJogo() {
        jogador = null;
        nivelMasmorra = 1;
    }
    
    public void salvarJogo() {
        if (jogador == null) {
            System.out.println("Não existe jogador para salvar.");
            return;
        }
        
        GerenciadorSaves.salvar(jogador, nivelMasmorra);
    }
    
    public boolean carregarJogo(String arquivo) {
        try {
            SaveData dados = GerenciadorSaves.carregar(arquivo);
            this.jogador = GerenciadorSaves.reconstruirJogador(dados);
            this.nivelMasmorra = dados.getNivelMasmorra();
            return true;
        } catch (Exception e) {
            System.out.println("Não foi possível carregar o jogo.");
            System.out.println("Detalhes: " + e.getMessage());
            return false;
        }
    }

    public int getNivelMasmorra() {
        return nivelMasmorra;
    }

    public void setNivelMasmorra(int nivelMasmorra) {
        this.nivelMasmorra = nivelMasmorra;
    }

    public Jogador getJogador() {
        return jogador;
    }
    
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}
