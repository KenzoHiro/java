import java.util.Scanner;

public class CD extends Midia {
    private int nMusicas;

    public CD(int codigo, double preco, String nome, int nMusicas) {
        super(codigo, preco, nome);
        this.nMusicas = nMusicas;
    }

    @Override
    public String getTipo() {
        return "CD";
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + "\nNúmero de Músicas: " + nMusicas;
    }

    @Override
    public void inserirDados() {
        super.inserirDados();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o número de músicas: ");
            this.nMusicas = scanner.nextInt();
        } finally {
            scanner.close();
        }
    }

    @Override
    public void printDados() {
        super.printDados();
        System.out.println("Número de Músicas: " + nMusicas);
    }
}