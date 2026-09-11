package me.davidsir1.fireandtrigger.entidades.classes;

import me.davidsir1.fireandtrigger.entidades.Jogador;
import me.davidsir1.fireandtrigger.entidades.Personagem;

/**
 *
 * @author david
 */
public class Mago extends Jogador{
    public Mago(String nome, int vidaMaxima, int ataqueBase, int defesaBase, int manaMaxima) {
        super(nome, ClassePersonagem.MAGO, vidaMaxima, ataqueBase, defesaBase, manaMaxima);
    }
    
    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = (int)(this.ataqueBase * 2.5);
        alvo.receberDano(dano);
        this.manaAtual -= 8;
    }
}
