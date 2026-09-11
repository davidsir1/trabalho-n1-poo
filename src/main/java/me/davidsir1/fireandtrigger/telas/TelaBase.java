package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import me.davidsir1.fireandtrigger.ContextoJogo;

/**
 *
 * @author david
 */
public abstract class TelaBase {
    protected ContextoJogo contexto;
    
    public TelaBase(ContextoJogo contexto) {
        this.contexto = contexto;
    }
    
    public abstract ResultadoTela.Acao exibir();
}
