import java.util.Scanner;

public class Cadastro{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cadastro de Pessoa
        System.out.println("Cadastro de Pessoa");
        System.out.print("Nome: ");
        String nomePessoa = scanner.nextLine();
        System.out.print("Idade: ");
        int idadePessoa = scanner.nextInt();

        // Cadastro de Pet
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Cadastro de Pet");
        System.out.print("Nome do Pet: ");
        String nomePet = scanner.nextLine();
        System.out.print("Tipo do Pet: ");
        String tipoPet = scanner.nextLine();

        // Cadastro de Veículo
        System.out.println("Cadastro de Veículo");
        System.out.print("Marca do Veículo: ");
        String marcaVeiculo = scanner.nextLine();
        System.out.print("Modelo do Veículo: ");
        String modeloVeiculo = scanner.nextLine();

        // Exibindo os dados cadastrados
        System.out.println("\nDados Cadastrados:");
        System.out.println("Pessoa: Nome " + nomePessoa + ", Idade " + idadePessoa);
        System.out.println("Pet: Nome " + nomePet + ", Tipo " + tipoPet);
        System.out.println("Veículo: Marca " + marcaVeiculo + ", Modelo " + modeloVeiculo);

        // Fechando o scanner
        scanner.close();
    }
}