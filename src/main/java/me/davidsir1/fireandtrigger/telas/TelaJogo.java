package me.davidsir1.fireandtrigger.telas;

import java.util.Random;
import java.util.Scanner;

import me.davidsir1.fireandtrigger.ContextoJogo;
import me.davidsir1.fireandtrigger.entidades.Inimigo;
import me.davidsir1.fireandtrigger.entidades.Jogador;

/**
 * Tela principal da masmorra.
 * Controla a exploração e os eventos encontrados pelo jogador.
 */
public class TelaJogo extends TelaBase {

    private Inimigo inimigoAtual;
    private String ultimaMensagem;
    private Scanner leitura;
    private Random sorteio;

    public TelaJogo(ContextoJogo contexto) {
        super(contexto);
        inimigoAtual = null;
        ultimaMensagem = "Você acordou...";
        leitura = new Scanner(System.in);
        sorteio = new Random();
    }

    @Override
    public ResultadoTela.Acao exibir() {

        while (true) {

            Jogador jogador = contexto.getJogador();

            if (jogador != null && !jogador.estaVivo()) {
                return ResultadoTela.Acao.JOGADOR_MORREU;
            }

            System.out.println("====================================");
            System.out.println("MASMORRA " + contexto.getNivelMasmorra());
            System.out.println("====================================");
            System.out.println();
            System.out.println("Última Mensagem:");
            System.out.println("> " + ultimaMensagem);
            System.out.println();
            System.out.println("1 - Explorar Masmorra");
            System.out.println("2 - Usar Item");
            System.out.println("3 - Exibir Status");
            System.out.println("4 - Opções");
            System.out.println("====================================");
            System.out.print("Opção: ");

            int opAcao = leitura.nextInt();

            switch (opAcao) {

                case 1: {
                    EventoMasmorra evento = explorar();

                    switch (evento) {
                        case NADA:
                            System.out.println("Jogador não encontrou nada de interessante...");
                            pausar();
                            break;
                        case ENCONTRO_INIMIGO:
                            tratarEncontroInimigo();
                            break;
                        case ENCONTRO_BAU:
                            tratarEncontroBau();
                            break;
                        case ENCONTRO_SAIDA:
                            tratarEncontroSaida();
                            break;
                    }

                    break;
                }

                case 2:
                    System.out.println("Sistema de itens ainda não implementado.");
                    pausar();
                    break;

                case 3:
                    exibirStatus();
                    pausar();
                    break;

                case 4: {
                    int opOpcao;

                    do {
                        System.out.println("====================================");
                        System.out.println("1 - Salvar Jogo");
                        System.out.println("2 - Sair");
                        System.out.println("3 - Voltar ao Jogo");
                        System.out.println("====================================");
                        System.out.print("Opção: ");

                        opOpcao = leitura.nextInt();

                        if (opOpcao < 1 || opOpcao > 3) {
                            System.out.println("Não existe essa opção!");
                        }

                    } while (opOpcao < 1 || opOpcao > 3);

                    if (opOpcao == 1) {
                        System.out.println("Sistema de salvar ainda não integrado.");
                        pausar();
                    } else if (opOpcao == 2) {
                        return ResultadoTela.Acao.SAIR;
                    }

                    break;
                }

                default:
                    System.out.println("Não existe essa opção!");
                    pausar();
                    break;
            }
        }
    }
    
    /**
     * Controla o encontro com um inimigo.
     */
    private void tratarEncontroInimigo() {

        System.out.println();
        System.out.println("====================================");
        System.out.println("ENCONTRO COM INIMIGO");
        System.out.println("====================================");
        System.out.println("Você encontrou: " + inimigoAtual.getNome());
        System.out.println();
        System.out.println("1 - Lutar");
        System.out.println("2 - Fugir");
        System.out.print("Opção: ");

        int opcao = leitura.nextInt();

        if (opcao == 1) {

            TelaCombate telaCombate =
                    new TelaCombate(contexto, inimigoAtual);

            ResultadoTela.Acao resultado = telaCombate.exibir();

            if (resultado == ResultadoTela.Acao.JOGADOR_MORREU) {
                return;
            }

            ultimaMensagem = telaCombate.getUltimaMensagem();

        } else if (opcao == 2) {

            // O jogador tem 25% de chance de fugir.
            if (sorteio.nextInt(100) < 25) {

                ultimaMensagem = "Você conseguiu fugir do inimigo!";

            } else {

                ultimaMensagem = "Você não conseguiu fugir!";
                System.out.println(ultimaMensagem);

                inimigoAtual.acaoAutomatica(contexto.getJogador());

                if (!contexto.getJogador().estaVivo()) {
                    return;
                }
            }

            System.out.println(ultimaMensagem);
            pausar();

        } else {

            System.out.println("Não existe essa opção!");
            pausar();
        }
    }

    /**
     * Sorteia o evento da masmorra.
     * 30% nada, 40% inimigo, 20% baú e 10% saída.
     */
    private EventoMasmorra explorar() {

        int numeroSorteado = sorteio.nextInt(100);

        if (numeroSorteado < 30) {

            ultimaMensagem = "Jogador não encontrou nada de interessante...";
            return EventoMasmorra.NADA;

        } else if (numeroSorteado < 70) {

            inimigoAtual = gerarInimigo();
            ultimaMensagem = "Um " + inimigoAtual.getNome()
                    + " apareceu na masmorra!";

            return EventoMasmorra.ENCONTRO_INIMIGO;

        } else if (numeroSorteado < 90) {

            ultimaMensagem = "Você encontrou um baú!";
            return EventoMasmorra.ENCONTRO_BAU;

        } else {

            ultimaMensagem = "Você encontrou a saída da masmorra!";
            return EventoMasmorra.ENCONTRO_SAIDA;
        }
    }

    /**
     * Cria um inimigo aleatório com atributos
     * de acordo com o nível da masmorra.
     */
    private Inimigo gerarInimigo() {

        int nivel = contexto.getNivelMasmorra();
        int tipo = sorteio.nextInt(3);

        String nome;
        int vida;
        int ataque;
        int defesa;
        double experiencia;

        if (tipo == 0) {

            nome = "Rato";
            vida = 20 + nivel * 5;
            ataque = 5 + nivel * 2;
            defesa = 2 + nivel;
            experiencia = 5 + nivel;

        } else if (tipo == 1) {

            nome = "Esqueleto";
            vida = 30 + nivel * 7;
            ataque = 8 + nivel * 2;
            defesa = 4 + nivel;
            experiencia = 7 + nivel;

        } else {

            nome = "Morto-vivo";
            vida = 40 + nivel * 9;
            ataque = 10 + nivel * 3;
            defesa = 5 + nivel * 2;
            experiencia = 10 + nivel;
        }

        return new Inimigo(
                nome,
                nivel,
                vida,
                ataque,
                defesa,
                experiencia
        );
    }

    /**
     * Dá poções ao jogador ao encontrar um baú.
     */
    private void tratarEncontroBau() {

        Jogador jogador = contexto.getJogador();

        jogador.adicionarPocaoVida(1);
        jogador.adicionarPocaoMana(1);

        ultimaMensagem =
                "Você encontrou um baú e recebeu 1 poção de vida e 1 poção de mana!";

        System.out.println(ultimaMensagem);
        pausar();
    }

    /**
     * Controla o encontro com a saída da masmorra.
     */
    private void tratarEncontroSaida() {

        int opcao;

        do {
            System.out.println();
            System.out.println("====================================");
            System.out.println("SAÍDA DA MASMORRA");
            System.out.println("====================================");
            System.out.println("1 - Sair da masmorra");
            System.out.println("2 - Continuar explorando");
            System.out.print("Opção: ");

            opcao = leitura.nextInt();

            if (opcao < 1 || opcao > 2) {
                System.out.println("Não existe essa opção!");
            }

        } while (opcao < 1 || opcao > 2);

        if (opcao == 1) {
            sairDaMasmorra();
        } else {
            ultimaMensagem = "Você decidiu continuar explorando a masmorra.";
            System.out.println(ultimaMensagem);
            pausar();
        }
    }

    /**
     * Avança para o próximo nível da masmorra,
     * recupera parte da vida e concede experiência.
     */
    private void sairDaMasmorra() {

        Jogador jogador = contexto.getJogador();

        contexto.setNivelMasmorra(
                contexto.getNivelMasmorra() + 1
        );

        int cura = (int) (jogador.getVidaMaxima() * 0.30);

        jogador.setVidaAtual(
                Math.min(
                        jogador.getVidaAtual() + cura,
                        jogador.getVidaMaxima()
                )
        );

        jogador.ganharExperiencia(5);

        ultimaMensagem =
                "Você saiu da masmorra e avançou para o nível "
                + contexto.getNivelMasmorra() + "!";

        System.out.println(ultimaMensagem);
        System.out.println("Você recuperou parte da vida e recebeu 5 de experiência.");

        pausar();
    }

    /**
     * Exibe o status atual do jogador.
     */
    private void exibirStatus() {

        Jogador jogador = contexto.getJogador();

        System.out.println();
        System.out.println("====================================");
        System.out.println("STATUS DO JOGADOR");
        System.out.println("====================================");
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("Vida: " + jogador.getVidaAtual()
                + "/" + jogador.getVidaMaxima());
        System.out.println("Mana: " + jogador.getManaAtual()
                + "/" + jogador.getManaMaxima());
        System.out.println("Poções de vida: " + jogador.getPocoesVida());
        System.out.println("Poções de mana: " + jogador.getPocoesMana());
        System.out.println("Experiência: " + jogador.getExperienciaAtual()
                + "/" + jogador.getExperienciaProximoNivel());
    }

    /**
     * Aguarda o jogador pressionar ENTER.
     */
    private void pausar() {

        leitura.nextLine();

        System.out.println();
        System.out.println("Pressione ENTER para continuar...");
        leitura.nextLine();
    }
}
