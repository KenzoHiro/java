public class Geladeira extends Eletronicos {
    private int capacidade;

    public Geladeira(String marca, String modelo, int ano, int capacidade) {
        super(marca, modelo, ano);
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Capacidade: " + capacidade + " litros";
    }
}
