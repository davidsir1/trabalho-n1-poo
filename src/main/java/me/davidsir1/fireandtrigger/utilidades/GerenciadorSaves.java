package me.davidsir1.fireandtrigger.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import me.davidsir1.fireandtrigger.entidades.FabricaJogador;
import me.davidsir1.fireandtrigger.entidades.Jogador;
import me.davidsir1.fireandtrigger.entidades.Raca;
import me.davidsir1.fireandtrigger.entidades.classes.ClassePersonagem;

/**
 *
 * @author Filipe Sebastiao
 */
public class GerenciadorSaves {
    private static final String PASTA_SAVES = "dados";
    private static final DateTimeFormatter FORMATO_DATA =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private static final DateTimeFormatter FORMATO_ARQUIVO =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    public static void salvar(Jogador jogador, int nivelMasmorra) {
        File pasta = new File(PASTA_SAVES);

        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        String dataHora = LocalDateTime.now().format(FORMATO_DATA);
        String nomeArquivo = "dado_" +
                LocalDateTime.now().format(FORMATO_ARQUIVO) + ".dat";

        SaveData dados = new SaveData(
                jogador.getNome(),
                jogador.getClasse().name(),
                jogador.getRaca().name(),
                jogador.getSexo(),
                jogador.getNivel(),
                jogador.getVidaAtual(),
                jogador.getVidaMaxima(),
                jogador.getAtaqueBase(),
                jogador.getDefesaBase(),
                jogador.getManaAtual(),
                jogador.getManaMaxima(),
                jogador.getPocoesVida(),
                jogador.getPocoesMana(),
                jogador.getExperienciaAtual(),
                jogador.getExperienciaProximoNivel(),
                nivelMasmorra,
                dataHora
        );

        File arquivo = new File(pasta, nomeArquivo);

        try (ObjectOutputStream saida =
                     new ObjectOutputStream(new FileOutputStream(arquivo))) {
            saida.writeObject(dados);
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o jogo.");
            System.out.println("Detalhes: " + e.getMessage());
        }
    }

    public static List<SaveData> listarSaves() {
        List<SaveData> saves = new ArrayList<>();
        File pasta = new File(PASTA_SAVES);

        if (!pasta.exists()) {
            return saves;
        }

        File[] arquivos = pasta.listFiles((dir, nome) ->
                nome.startsWith("dado_") && nome.endsWith(".dat"));

        if (arquivos == null) {
            return saves;
        }

        for (File arquivo : arquivos) {
            try {
                SaveData dados = carregar(arquivo.getPath());
                dados.setCaminhoArquivo(arquivo.getPath());
                saves.add(dados);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Não foi possível ler o save: "
                        + arquivo.getName());
            }
        }

        saves.sort(Comparator.comparing(
                GerenciadorSaves::converterData,
                Comparator.nullsLast(Comparator.reverseOrder())
        ));

        return saves;
    }

    private static LocalDateTime converterData(SaveData save) {
        if (save == null || save.getDataHora() == null) {
            return null;
        }

        try {
            return LocalDateTime.parse(save.getDataHora(), FORMATO_DATA);
        } catch (Exception e) {
            return null;
        }
    }

    public static SaveData carregar(String caminhoArquivo)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream entrada =
                     new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            Object objeto = entrada.readObject();

            if (!(objeto instanceof SaveData)) {
                throw new IOException("Arquivo de save inválido.");
            }

            return (SaveData) objeto;
        }
    }

    public static Jogador reconstruirJogador(SaveData dados) {
        ClassePersonagem classe =
                ClassePersonagem.valueOf(dados.getClasse());
        Raca raca = Raca.valueOf(dados.getRaca());

        Jogador jogador = FabricaJogador.criarJogador(
                dados.getNomeJogador(),
                classe,
                raca,
                dados.getSexo()
        );

        // A fábrica cria o personagem com os valores iniciais.
        // Aqui restauramos exatamente o estado que estava no save.
        jogador.setNivel(dados.getNivel());
        jogador.setVidaMaxima(dados.getVidaMaxima());
        jogador.setVidaAtual(dados.getVidaAtual());
        jogador.setAtaqueBase(dados.getAtaque());
        jogador.setDefesaBase(dados.getDefesa());
        jogador.setManaMaxima(dados.getManaMaxima());
        jogador.setManaAtual(dados.getManaAtual());
        jogador.setPocoesVida(dados.getPocosVida());
        jogador.setPocoesMana(dados.getPocosMana());
        jogador.setExperienciaAtual(dados.getExperienciaAtual());
        jogador.setExperienciaProximoNivel(dados.getExperienciaProximoNivel());

        return jogador;
    }
}
