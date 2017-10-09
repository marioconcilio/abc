import java.nio.file.Paths;

/**
 * @author Mario Concilio.
 */
public class minimiza {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java minimiza [arquivo_entrada] [arquivo_saida]");
            System.exit(1);
        }

        AFD afd = new AFD(args[0]);
        afd.minimiza();

    }
}
