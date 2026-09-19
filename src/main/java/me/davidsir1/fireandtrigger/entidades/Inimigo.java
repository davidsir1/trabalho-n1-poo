package me.davidsir1.fireandtrigger.entidades;

import java.util.Random;

/**
 *
 * @author matheus
 */
public class Inimigo extends Personagem {
    private double recompensaExperiencia;
    private boolean usouHabilidadeEspecial;

    public Inimigo(String nome, int nivel, int vidaMaxima, int ataqueBase, int defesaBase, double experienciaRecompensa) {
        super(nome, nivel, vidaMaxima, ataqueBase, defesaBase);
        this.recompensaExperiencia = experienciaRecompensa;
    }

    public double getRecompensaExperiencia() {
        return recompensaExperiencia;
    }
    
    public boolean usouHablidadeEspecial() {
        return usouHabilidadeEspecial;
    }

    /*
    Realiza a ação do inimigo: 80% de chance de ataque comum e 20% de chance de golpe
    especial.
    */
    public void acaoAutomatica(Jogador alvo) {
        Random sorteio = new Random();
        usouHabilidadeEspecial = sorteio.nextInt(100) >= 80;
        
        if (usouHabilidadeEspecial) {
            int danoEspecial = ataqueBase + 3;
            alvo.receberDano(danoEspecial);
        } else {
            atacar(alvo);
        }
    }
}
