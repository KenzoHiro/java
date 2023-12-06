import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Midia> cadastroMidias = new ArrayList<>();

        CD cd = new CD(1, 20.0, "Frank Sinatra", 20);
        cadastroMidias.add(cd);

        DVD dvd = new DVD(2, 30.0, "Tyler the creator", 12);
        cadastroMidias.add(dvd);

        System.out.println("\nDetalhes do Cadastro:");
        for (Midia midia : cadastroMidias) {
            midia.printDados();
        }
    }
}