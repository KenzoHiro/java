import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Veiculo veiculo;

            System.out.println("Escolha o tipo de veiculo (1 para Moto, 2 para Carro): ");
            int escolha = scanner.nextInt();

            if (escolha == 1) {
                veiculo = Moto.cadastrarMoto();
            } else if (escolha == 2) {
                veiculo = Carro.cadastrarCarro();
            } else {
                System.out.println("Opcao invalida");
                return;
            }

            System.out.println("\nRelatorio do Veiculo antes do reajuste:");
            veiculo.printDados();

            Veiculo[] veiculos = {veiculo};
            double totalAntes = Veiculo.calcularTotalPreco(veiculos);
            System.out.println("\nTotal de precos antes das alteracoes:R$ " + totalAntes);

            if (veiculo instanceof Moto) {
                Moto.reajustarPrecoMotos(new Moto[]{(Moto) veiculo});
            } else if (veiculo instanceof Carro) {
                Carro.reduzirPrecoCarros(new Carro[]{(Carro) veiculo});
            }

            System.out.println("\nRelatorio do Veiculo apos o reajuste:");
            veiculo.printDados();

            double totalDepois = Veiculo.calcularTotalPreco(veiculos);
            System.out.println("\nTotal de precos apos as alteracoes:R$ " + totalDepois);
        }
    }
}