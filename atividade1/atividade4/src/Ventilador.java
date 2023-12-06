public class Ventilador extends Eletronicos {
    private int velocidade;

    public Ventilador(String marca, String modelo, int ano, int velocidade) {
        super(marca, modelo, ano);
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Velocidade: " + velocidade;
    }
}