package me.davidsir1.fireandtrigger.entidades.classes;

import me.davidsir1.fireandtrigger.entidades.Jogador;
import me.davidsir1.fireandtrigger.entidades.Personagem;

/**
 *
 * @author david
 */
public class Guerreiro extends Jogador {
    public Guerreiro(String nome, int vidaMaxima, int ataqueBase, int defesaBase, int manaMaxima) {
        super(nome, ClassePersonagem.GUERREIRO, vidaMaxima, ataqueBase, defesaBase, manaMaxima);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = this.ataqueBase * 2;
        alvo.receberDano(dano);
        this.manaAtual -= 10;
    }
}
