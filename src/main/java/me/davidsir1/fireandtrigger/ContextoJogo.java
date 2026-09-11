package me.davidsir1.fireandtrigger;

import me.davidsir1.fireandtrigger.entidades.Jogador;

/**
 *
 * @author david
 */
public class ContextoJogo {
    private Jogador jogador;
    private int nivelMasmorra;

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
