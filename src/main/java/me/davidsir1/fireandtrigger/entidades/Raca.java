package me.davidsir1.fireandtrigger.entidades;

/**
 *
 * @author david
 */
public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ANAO("Anão");
    
    private final String nomeExibicao;
    private int bonusVida, bonusAtaque, bonusDefesa, bonusMana;

    private Raca(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }
    
    // Getters e Setters
    public static Raca getHUMANO() {
        return HUMANO;
    }

    public static Raca getELFO() {
        return ELFO;
    }

    public static Raca getANAO() {
        return ANAO;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }
}
