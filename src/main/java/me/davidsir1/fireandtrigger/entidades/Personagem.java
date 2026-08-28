package me.davidsir1.fireandtrigger.entidades;

/**
 *
 * @author david
 */
public class Personagem {
    private String nome;
    private int nivel;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataqueBase;
    private int defesaBase;
    private float experiencia; // Atributo para evolução do personagem
    
    // Construtor
    public Personagem(String nome) {
        this.nome = nome;
        // Os atributos são iniciados com valores pré definidos
        this.nivel = 1;
        this.vidaMaxima = 100;
        this.vidaAtual = this.vidaMaxima;
        this.ataqueBase = 10;
        this.defesaBase = 10;
        this.experiencia = 0.0f;
    }
    
    // Metodos
    public void atacar(Personagem alvo, int dano) {
        alvo.receberDano(dano);
        
        /*
        Implementar lógica de receber experiencia se o jogador matou o inimigo
        */
    }
    
    public void receberDano(int dano) {
        if (this.vidaAtual - dano > 0) {
            this.vidaAtual = this.vidaAtual - dano;
        } else {
            this.vidaAtual = 0;
        }
    }
    
    public boolean estaVivo() {
        if (this.vidaAtual == 0) 
            return true;
        else
            return false;
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

    public float getExperiencia() {
        return experiencia;
    }
    
}
