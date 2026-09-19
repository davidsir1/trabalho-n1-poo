package me.davidsir1.fireandtrigger.telas;

import java.util.Scanner;
import java.util.Random;
import me.davidsir1.fireandtrigger.ContextoJogo;
import me.davidsir1.fireandtrigger.entidades.Inimigo;
import me.davidsir1.fireandtrigger.entidades.Jogador;

/**
 *
 * @author 
 */
public class TelaCombate extends TelaBase {
    private Jogador jogador;
    private Inimigo inimigo;
    private boolean ativo;
    private boolean vitoria;
    private String ultimaMensagem;
    private final Scanner leitura;
    
    public TelaCombate(ContextoJogo contexto) {
        super(contexto);
        leitura = new Scanner(System.in);
        ultimaMensagem = "Inicio do combate...";
    }
    
    // Usado quando o evento da masmorra já criou o inimigo
    public TelaCombate(ContextoJogo contexto, Inimigo inimigo) {
        this(contexto);
        this.inimigo = inimigo;
    }
    
    // Métodos
    public void iniciarCombate() {
        jogador = contexto.getJogador();
        vitoria = false;
        ativo = jogador != null && inimigo != null;
        
        if (ativo) {
            ultimaMensagem = jogador.getNome() + " enfrentará " + inimigo.getNome() + ".";
        } else {
            ultimaMensagem = "Não foi possível iniciar: jogador ou inimigo ausente.";
        }
    }
    
    // Executa o ataque simples do jogador e, se necessário, o turno inimigo
    public void atacar() {
        jogador.atacar(inimigo);
        ultimaMensagem = jogador.getNome() + " atacou " + inimigo.getNome() + ".";
        verificarFim();
        if (ativo) {
            turnoInimigo();
        }
    }
    
    // Executa a habilidade da classe escolhida pelo jogador.
    public void usarHabilidadeEspecial() {
        jogador.usarHabilidadeEspecial(inimigo);
        ultimaMensagem = jogador.getNome() + " usou a habilidade especial.";
        verificarFim();
        if (ativo) {
            turnoInimigo();
        }
    }
    
    // Usa uma poção de vida ou de mana
    public void usarPocao(int tipoPocao) {
        boolean usouPocao;
        
        if (tipoPocao == 1) {
            usouPocao = jogador.usarPocaoVida();
            ultimaMensagem = usouPocao ? "Poção de vida utilizada." :
                    "Você não possui poções de vida.";
        } else if (tipoPocao == 2) {
            usouPocao = jogador.usarPocaoMana();
            ultimaMensagem = usouPocao ? "Poção de mana utilizada." :
                    "Você não possui poções de mana.";
        } else {
            ultimaMensagem = "Item inválido.";
            return;
        }
    }
    
    // Tenta fugir com uma chance baixa de sucesso (25%)
    public boolean tentarFugir() {
        Random sorteio = new Random();
        boolean fugiu = sorteio.nextInt(100) < 25;
        
        if (fugiu) {
            ativo = false;
            ultimaMensagem = "Você conseguiu fugir do combate.";
        } else {
            ultimaMensagem = "A fuga falhou!.";
            turnoInimigo();
        }
        
        return fugiu;
    }
    
    // Realiza a jogada automatica do inimigo
    public void turnoInimigo() {
        if (!ativo) return;
        
        inimigo.acaoAutomatica(jogador);
        if (inimigo.usouHablidadeEspecial()) {
            ultimaMensagem = inimigo.getNome() + " usou um golpe especial.";
        } else {
            ultimaMensagem = inimigo.getNome() + " atacou.";
        }
        verificarFim();
    }
    
    // Verifica a derrota ou a vitória e concede a recompensa uma única vez.
    public void verificarFim() {
        if (!inimigo.estaVivo()) {
            double experiencia = inimigo.getRecompensaExperiencia();
            jogador.ganharExperiencia(experiencia);
            ativo = false;
            vitoria = true;
            ultimaMensagem = "Você venceu e ganhou " + experiencia + " de experiência.";
        } else if (!jogador.estaVivo()) {
            ativo = false;
            ultimaMensagem = "Você foi derrotado.";
        }
    }
    
    private void exibirStatus() {
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("Ataque: " + jogador.getAtaqueBase());
        System.out.println("Defesa: " + jogador.getDefesaBase());
        System.out.println("Mana: " + jogador.getManaAtual() + "/" + jogador.getManaMaxima());
        System.out.println("Experiência: " + jogador.getExperienciaAtual()
                + "/" + jogador.getExperienciaProximoNivel());
        ultimaMensagem = "Status exibido.";
    }
    
    // Getters e Setters
    public void setInimigo(Inimigo inimigo) {
        this.inimigo = inimigo;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }
    
    @Override
    public ResultadoTela.Acao exibir() {
        if (!ativo && !vitoria && (jogador == null || inimigo == null)) {
            iniciarCombate();
        }
        
        while (ativo) {
            int opAcao;
            do {
                System.out.println("====================================");
                
                System.out.println();
                System.out.println(jogador.getNome() + " VS. " + inimigo.getNome());
                
                System.out.println("Jogador: "
                        + jogador.getVidaAtual() + "/" + jogador.getVidaMaxima());
                System.out.println("Inimigo: "
                        + inimigo.getVidaAtual() + "/" + inimigo.getVidaMaxima());
                
                System.out.println();
                System.out.println("Última Mensagem: ");
                System.out.println("> " + ultimaMensagem);
                
                System.out.println();
                System.out.println("1. Atacar");
                System.out.println("2. Utilizar Habilidade Especial");
                System.out.println("3. Exibir Status");
                System.out.println("4. Usar Item");
                System.out.println("5. Fugir");
                System.out.print("Opção: ");
                opAcao = leitura.nextInt();
                if (opAcao < 1 || opAcao > 5) System.out.println("Não existe essa opção!");
            } while (opAcao < 1 || opAcao > 5);
            
            switch (opAcao) {
                case 1:
                    atacar();
                    break;
                case 2:
                    usarHabilidadeEspecial();
                    break;
                case 3:
                    exibirStatus();
                    break;
                case 4:
                    int opPocao;
                    do {
                        System.out.println("1. Poção de vida (" + jogador.getPocoesVida() + ")");
                        System.out.println("2. Poção de mana (" + jogador.getPocoesMana() + ")");
                        System.out.print("Item: ");
                        opPocao = leitura.nextInt();
                        if (opPocao < 1 || opPocao > 2) System.out.println("Digite apenas o número do item.");
                    } while (opPocao < 1 || opPocao > 2);
                    usarPocao(opPocao);
                    break;
            }
        }
        
        if (jogador != null && !jogador.estaVivo()) {
            return ResultadoTela.Acao.JOGADOR_MORREU;
        }
        
        return ResultadoTela.Acao.MANTER;
    }
}
