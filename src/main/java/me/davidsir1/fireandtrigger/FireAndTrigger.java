/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package me.davidsir1.fireandtrigger;

import me.davidsir1.fireandtrigger.telas.GerenciadorTela;

/**
 *
 * @author david
 */
public class FireAndTrigger {

    public static void main(String[] args) {
        System.out.println("  Durante eras, o mundo foi mantido em equilibrio com dois pilares: O Fogo e a Ordem\n" +
                "O Fogo era a luz primordial, a força da criação que fluia do plano de Pyra, capaz de aquecer impérios" +
                "ou reduzi-los a cinzas. A Ordem era a vontade dos homens, a arte da engenharia dos selos alquímicos " +
                "que domaram essa energia, transformando o caos em ordem, aço e poder.\n");
        System.out.println("  Por séculos, a Linhagem dos Guardiões manteve a Fenda Abissal selada. Sob o Pacto das Cinzas" +
                ", o mundo prosperou na era das Armas de Fogo.\n");
        System.out.println("  Mas os homens esqueceram que o fogo nunca se extingue... apenas espera.\n");
        System.out.println("  Na calada da noite, a Linhagem dos Guardiões foi massacrada. Sem o sange real para mentor os selos, " +
                "o mecanismo ruiu. As velhas fogueiras se apagaram e a 'Ordem' foi quebrada.");
        System.out.println("  Dois mundos agora se colidem. Portais de chama incadescente rasgam os ceús, e as hordas do Abismo " +
                "macharão sobre as terra dos homens.\n");
        System.out.println("  As profecias falavam de um escolhido.. mas você nãoe é o escolhido das lendas. Você é apenas mais " +
                "um prisoneiro nas masmorras esquecidas sob as cinzas da capital.\n");
        System.out.println("  O Fogo foi aceso...");
        
        GerenciadorTela gerenciador = new GerenciadorTela();
        gerenciador.executar();
    }
}
