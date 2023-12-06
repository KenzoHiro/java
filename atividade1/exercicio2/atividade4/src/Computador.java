public class Computador extends Eletronicos {
    private String processador;
    private int memoriaRAM;

    public Computador(String marca, String modelo, int ano, String processador, int memoriaRAM) {
        super(marca, modelo, ano);
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Processador: " + processador + "\n" +
               "Memória RAM: " + memoriaRAM + " GB";
    }
}