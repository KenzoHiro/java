public class FaturaTeste {
    public static void main(String[] args) {
        Fatura minhaFatura = new Fatura("123", "Teclado", 2, 29.99);

        System.out.println("Número da Fatura: " + minhaFatura.getNumero());
        System.out.println("Descrição: " + minhaFatura.getDescricao());
        System.out.println("Quantidade: " + minhaFatura.getQuantidade());
        System.out.println("Preço por Item: $" + minhaFatura.getPrecoPorItem());
        System.out.println("Total da Fatura: $" + minhaFatura.getTotalFatura());

        minhaFatura.setQuantidade(3);
        minhaFatura.setPrecoPorItem(24.99);

        System.out.println("\nInformações Atualizadas:");
        System.out.println("Quantidade: " + minhaFatura.getQuantidade());
        System.out.println("Preço por Item: $" + minhaFatura.getPrecoPorItem());
        System.out.println("Novo Total da Fatura: $" + minhaFatura.getTotalFatura());
    }
}
