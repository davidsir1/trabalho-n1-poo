package me.davidsir1.fireandtrigger.entidades.classes;

import me.davidsir1.fireandtrigger.entidades.Jogador;
import me.davidsir1.fireandtrigger.entidades.Personagem;

/**
 *
 * @author david
 */
public class Arqueiro extends Jogador{
    public Arqueiro(String nome, int vidaMaxima, int ataqueBase, int defesaBase, int manaMaxima) {
        super(nome, ClassePersonagem.ARQUEIRO, vidaMaxima, ataqueBase, defesaBase, manaMaxima);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = this.ataqueBase * 2;
        alvo.receberDano(dano);
        this.manaAtual -= 6;
    }
}
