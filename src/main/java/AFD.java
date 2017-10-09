import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mario Concilio.
 */
public class AFD {

    private int numEstados;
    private int numSimbolosAlfabeto;
    private int estadoInicial;

    private boolean estadosAceitacao[];

    public AFD(String arquivo) {
        List<String> linhas = lerArquivo(arquivo);
        buscarInformacoesPrincipais(linhas);
    }

    public void minimiza() {

    }

    private List<String> lerArquivo(String arquivo) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(arquivo))) {
            linhas = br.lines().collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return linhas;
    }

    private void buscarInformacoesPrincipais(List<String> linhas) {
        String[] splitLinhaPrincipal = linhas.get(0).split("\\s+");
        numEstados = Integer.valueOf(splitLinhaPrincipal[0]);
        numSimbolosAlfabeto = Integer.valueOf(splitLinhaPrincipal[1]);
        estadoInicial = Integer.valueOf(splitLinhaPrincipal[2]);

        String[] splitLinhaEstadosAceitacao = linhas.get(1).split("\\s+");
        Stream.of(splitLinhaEstadosAceitacao)
                .map(Integer::valueOf)
                .map(i -> i != 0)
                .toArray(Boolean[]::new);
    }

}
