package me.davidsir1.fireandtrigger.utilidades;

import java.io.Serializable;

/**
 *
 * @author Filipe Sebastiao
 */
public class SaveData implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nomeJogador;
    private String classe;
    private String raca;
    private String sexo;

    private int nivel;
    private int vidaAtual;
    private int vidaMaxima;
    private int ataque;
    private int defesa;

    private int manaAtual;
    private int manaMaxima;
    private int pocosVida;
    private int pocosMana;

    private double experienciaAtual;
    private double experienciaProximoNivel;

    private int nivelMasmorra;
    private String dataHora;

    // Usado somente enquanto o save está listado; não é gravado no arquivo.
    private transient String caminhoArquivo;

    public SaveData() {
    }

    public SaveData(String nomeJogador, String classe, String raca, String sexo,
                    int nivel, int vidaAtual, int vidaMaxima, int ataque, int defesa,
                    int manaAtual, int manaMaxima, int pocosVida, int pocosMana,
                    double experienciaAtual, double experienciaProximoNivel,
                    int nivelMasmorra, String dataHora) {
        this.nomeJogador = nomeJogador;
        this.classe = classe;
        this.raca = raca;
        this.sexo = sexo;
        this.nivel = nivel;
        this.vidaAtual = vidaAtual;
        this.vidaMaxima = vidaMaxima;
        this.ataque = ataque;
        this.defesa = defesa;
        this.manaAtual = manaAtual;
        this.manaMaxima = manaMaxima;
        this.pocosVida = pocosVida;
        this.pocosMana = pocosMana;
        this.experienciaAtual = experienciaAtual;
        this.experienciaProximoNivel = experienciaProximoNivel;
        this.nivelMasmorra = nivelMasmorra;
        this.dataHora = dataHora;
    }

    public String getNomeJogador() { return nomeJogador; }
    public String getClasse() { return classe; }
    public String getRaca() { return raca; }
    public String getSexo() { return sexo; }
    public int getNivel() { return nivel; }
    public int getVidaAtual() { return vidaAtual; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
    public int getManaAtual() { return manaAtual; }
    public int getManaMaxima() { return manaMaxima; }
    public int getPocosVida() { return pocosVida; }
    public int getPocosMana() { return pocosMana; }
    public double getExperienciaAtual() { return experienciaAtual; }
    public double getExperienciaProximoNivel() { return experienciaProximoNivel; }
    public int getNivelMasmorra() { return nivelMasmorra; }
    public String getDataHora() { return dataHora; }

    public String getCaminhoArquivo() { return caminhoArquivo; }
    public void setCaminhoArquivo(String caminhoArquivo) { this.caminhoArquivo = caminhoArquivo; }
}
