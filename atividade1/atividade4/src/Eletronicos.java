public class Eletronicos {
    private String marca;
    private String modelo;
    private int ano;

    public Eletronicos(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + "\n" +
               "Modelo: " + modelo + "\n" +
               "Ano: " + ano;
    }
}