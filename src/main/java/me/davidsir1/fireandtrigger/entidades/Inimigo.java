package me.davidsir1.fireandtrigger.entidades;

/**
 *
 * @author david
 */
public class Inimigo extends Personagem {
    private double recompensaExperiencia;

    public Inimigo(String nome, int nivel, int vidaMaxima, int ataqueBase, int defesaBase, double experienciaRecompensa) {
        super(nome, nivel, vidaMaxima, ataqueBase, defesaBase);
        this.recompensaExperiencia = experienciaRecompensa;
    }

    public double getRecompensaExperiencia() {
        return recompensaExperiencia;
    }
}
