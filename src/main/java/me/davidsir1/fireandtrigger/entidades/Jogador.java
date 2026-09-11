package me.davidsir1.fireandtrigger.entidades;

import me.davidsir1.fireandtrigger.entidades.classes.ClassePersonagem;

/**
 *
 * @author david
 */
public abstract class Jogador extends Personagem{
    protected double experienciaAtual;
    protected double experienciaProximoNivel;
    protected int manaMaxima;
    protected int manaAtual;
    protected int pocoesVida;
    protected int pocoesMana;
    private String sexo;
    private Raca raca;
    private ClassePersonagem classe;

    public Jogador(String nome, ClassePersonagem classe, int vidaMaxima, int ataqueBase, int defesaBase, int manaMaxima) {
        super(nome, 1, vidaMaxima, ataqueBase, defesaBase);
        this.manaMaxima = manaMaxima;
        this.manaAtual = manaMaxima;
        this.experienciaAtual = 0.0f;
        this.experienciaProximoNivel = 20.0f;
        this.pocoesVida = 3;
        this.pocoesMana = 2;
        this.sexo = "Indefinido";
        this.raca = Raca.HUMANO;
        this.classe = classe;
    }
    
    // Método abstrato para cada tipo de jogador ()
    public abstract void usarHabilidadeEspecial(Personagem alvo);
    
    // Métodos
    public void ganharExperiencia(int experienciaGanha) {
        this.experienciaAtual += experienciaGanha;
        if (this.experienciaAtual >= this.experienciaProximoNivel) {
            // Método para subir de nível
            subirDeNivel();
        }
    }
    
    protected void subirDeNivel() {
        this.nivel += 1;
        this.experienciaAtual -= this.experienciaProximoNivel;
        this.experienciaProximoNivel = this.experienciaProximoNivel * 1.5f;
        
        // Aumento dos atributos base
        this.vidaMaxima += 20;
        this.vidaAtual = this.vidaMaxima;
        this.manaMaxima += 5;
        this.manaAtual = this.manaMaxima;
        this.ataqueBase += 4;
        this.defesaBase += 2;
    }
    
    public boolean usarPocaoVida() {
        if (this.pocoesVida > 0) {
            this.pocoesVida -= 1;
            int cura = (int) (this.vidaMaxima * 0.5);
            this.setVidaAtual(this.vidaAtual + cura);
            return true;
        }
        
        return false;
    }
    
    public boolean usarPocaoMana() {
        if (this.pocoesMana > 0) {
            this.pocoesMana -= 1;
            this.manaAtual = (this.manaAtual + 15 > this.manaMaxima ? this.manaMaxima : this.manaAtual + 15);
            return true;
        }
        
        return false;
    }
    
    public void adicionarPocaoVida(int quantidade) { this.pocoesVida += quantidade; }
    public void adicionarPocaoMana(int quantidade) { this.pocoesMana += quantidade; }
    
    // Getters e Setters
    public double getExperienciaAtual() {
        return experienciaAtual;
    }

    public double getExperienciaProximoNivel() {
        return experienciaProximoNivel;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public int getManaAtual() {
        return manaAtual;
    }

    public int getPocoesVida() {
        return pocoesVida;
    }

    public int getPocoesMana() {
        return pocoesMana;
    }
    
    public Raca getRaca() {
        return raca;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public ClassePersonagem getClasse() {
        return classe;
    }
    
    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
