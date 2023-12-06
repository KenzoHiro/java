import java.util.Scanner;

public class DVD extends Midia {
    private int nFaixas;

    public DVD(int codigo, double preco, String nome, int nFaixas) {
        super(codigo, preco, nome);
        this.nFaixas = nFaixas;
    }

    @Override
    public String getTipo() {
        return "DVD";
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + "\nNúmero de Faixas: " + nFaixas;
    }

    @Override
    public void inserirDados() {
        super.inserirDados();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o número de faixas: ");
            this.nFaixas = scanner.nextInt();
        } finally {
            scanner.close();
        }
    }

    @Override
    public void printDados() {
        super.printDados();
        System.out.println("Número de Faixas: " + nFaixas);
    }
}