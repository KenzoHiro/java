import java.util.Scanner;

public class Midia {
    private int codigo;
    private double preco;
    private String nome;

    public Midia(int codigo, double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public String getTipo() {
        return "Midia";
    }

    public String getDetalhes() {
        return String.format("Código: %d\nNome: %s\nPreço: %.2f", codigo, nome, preco);
    }

    public void inserirDados() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o código: ");
            this.codigo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome: ");
            this.nome = scanner.nextLine();
            System.out.print("Digite o preço: ");
            this.preco = scanner.nextDouble();
        } finally {
            scanner.close();
        }
    }

    public void printDados() {
        System.out.println("Tipo: " + getTipo());
        System.out.println("Detalhes:\n" + getDetalhes());
    }
}