public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Kenzo", 20, "Masculino", 5000, "g12345", "Rh");
        Vendedor vendedor = new Vendedor("Pedro", 18, "Masculino", 2500, "v54321", 12000, 50);

        System.out.println("Informações do Gerente:");
        System.out.println(gerente.toString());

        System.out.println("\nInformações do Vendedor:");
        System.out.println(vendedor.toString());
    }
}
