package me.davidsir1.fireandtrigger.entidades.classes;

/**
 *
 * @author david
 */
public enum ClassePersonagem {
    GUERREIRO("Guerreiro"),
    ARQUEIRO("Arqueiro"),
    MAGO("Mago");
    
    private final String nomeExibicao;
    
    ClassePersonagem(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }
    
    // Getters e Setters
    public static ClassePersonagem getGUERREIRO() {
        return GUERREIRO;
    }

    public static ClassePersonagem getARQUEIRO() {
        return ARQUEIRO;
    }

    public static ClassePersonagem getMAGO() {
        return MAGO;
    }

    public String getNomeExibicao() {
        return nomeExibicao;
    }
}
