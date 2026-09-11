package me.davidsir1.fireandtrigger.entidades;

import me.davidsir1.fireandtrigger.entidades.classes.Arqueiro;
import me.davidsir1.fireandtrigger.entidades.classes.ClassePersonagem;
import me.davidsir1.fireandtrigger.entidades.classes.Guerreiro;
import me.davidsir1.fireandtrigger.entidades.classes.Mago;

/**
 *
 * @author david
 */
public class FabricaJogador {
    public static Jogador criarJogador(String nome, ClassePersonagem classe, Raca raca, String sexo) {
        int vidaMaxima = 0, ataqueBase = 0, defesaBase = 0, manaMaxima = 0;
        
        switch (classe) {
            case GUERREIRO:
                vidaMaxima = 120; ataqueBase = 15; defesaBase = 12; manaMaxima = 10;
                break;
            case ARQUEIRO:
                vidaMaxima = 90; ataqueBase = 18; defesaBase = 10; manaMaxima = 8;
                break;
            case MAGO:
                vidaMaxima = 80; ataqueBase = 10; defesaBase = 6; manaMaxima = 40;
                break;
        }
        
        // Etapa para aplicar bonus de acordo com a raca
        //vidaMaxima += raca.getBonusVida();
        //ataqueBase += raca.getBonusAtaque();
        
        Jogador jogador = null;
        switch (classe) {
            case GUERREIRO:
                jogador = new Guerreiro(nome, vidaMaxima, ataqueBase, defesaBase, manaMaxima);
                break;
            case ARQUEIRO:
                jogador = new Arqueiro(nome, vidaMaxima, ataqueBase, defesaBase, manaMaxima);
                break;
            case MAGO:
                jogador = new Mago(nome, vidaMaxima, ataqueBase, defesaBase, manaMaxima);
                break;
        }
        
        jogador.setRaca(raca);
        jogador.setSexo(sexo);
        
        return jogador;
    }
}
