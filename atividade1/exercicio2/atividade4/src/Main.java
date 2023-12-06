public class Main {
    public static void main(String[] args) {
        Computador computador = new Computador("Dell", "alienware", 2022, "Intel i7", 32);
        Ventilador ventilador = new Ventilador("Mondial", "potente", 2021, 3);
        Geladeira geladeira = new Geladeira("Brastemp", "Algumai", 2020, 400);

        System.out.println("Informações do Computador:\n" + computador.toString() + "\n");
        System.out.println("Informações do Ventilador:\n" + ventilador.toString() + "\n");
        System.out.println("Informações da Geladeira:\n" + geladeira.toString() + "\n");
    }
}