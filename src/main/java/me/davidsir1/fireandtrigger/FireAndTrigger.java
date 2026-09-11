package me.davidsir1.fireandtrigger;

import me.davidsir1.fireandtrigger.telas.GerenciadorTela;

/**
 *
 * @author david
 */
public class FireAndTrigger {

    public static void main(String[] args) {
        System.out.println("""
                             Durante eras, o mundo foi mantido em equilibrio com dois pilares: O Fogo e a Ordem
                           O Fogo era a luz primordial, a for\u00e7a da cria\u00e7\u00e3o que fluia do plano de Pyra, capaz de aquecer imp\u00e9rios
                           ou reduzi-los a cinzas. A Ordem era a vontade dos homens, a arte da engenharia dos selos alqu\u00edmicos
                           que domaram essa energia, transformando o caos em ordem, a\u00e7o e poder.
                           """);
        System.out.println("""
                             Por s\u00e9culos, a Linhagem dos Guardi\u00f5es manteve a Fenda Abissal selada. Sob o Pacto das Cinzas, o mundo prosperou na era das Armas de Fogo.
                           """);
        System.out.println("  Mas os homens esqueceram que o fogo nunca se extingue... apenas espera.\n");
        System.out.println("""
                             Na calada da noite, a Linhagem dos Guardi\u00f5es foi massacrada.
                           Sem o sange real para mentor os selos, o mecanismo ruiu. As velhas fogueiras se apagaram e a 'Ordem' foi quebrada.""");
        System.out.println("""
                             Dois mundos agora se colidem. Portais de chama incadescente rasgam os ce\u00fas, e as hordas do Abismo machar\u00e3o sobre as terra dos homens.
                           """);
        System.out.println("""
                             As profecias falavam de um escolhido.. mas voc\u00ea n\u00e3o \u00e9 o escolhido das lendas. Voc\u00ea \u00e9 apenas um prisoneiro nas masmorras esquecidas sob as cinzas da capital.
                           """);
        System.out.println("  O Fogo foi aceso...");
        
        GerenciadorTela gerenciador = new GerenciadorTela();
        gerenciador.executar();
    }
}
