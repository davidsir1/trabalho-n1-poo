package me.davidsir1.fireandtrigger.entidades;

/**
 *
 * @author david
 */
public class Personagem {
    protected String nome;
    protected int nivel;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int ataqueBase;
    protected int defesaBase;
    
    // Construtor
    public Personagem(String nome, int nivel, int vidaMaxima, int ataqueBase, int defesaBase) {
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.ataqueBase = ataqueBase;
        this.defesaBase = defesaBase;
    }
    
    // Metodos
    public void atacar(Personagem alvo) {
        int danoEfetivo = this.ataqueBase - alvo.getDefesaBase();
        if (danoEfetivo < 1) {
            danoEfetivo = 1;
        }
        alvo.receberDano(danoEfetivo);
    }
    
    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
    }
    
    public boolean estaVivo() {
        return this.vidaAtual > 0;
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }

    public int getDefesaBase() {
        return defesaBase;
    }
    
    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }
}
