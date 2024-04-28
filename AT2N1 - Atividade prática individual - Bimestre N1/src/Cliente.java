import java.util.Random;

public class Cliente extends Thread {
    private static final int[] valorespossiveis = { 100, 200 }; // Valores das compras possiveis
    private Conta conta;
    private Loja[] lojas;
    private Banco banco;

    public Cliente(Conta conta, Loja[] lojas, Banco banco) {
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    public void run() {
        int indiceLojaAtual = 0; // Cria o indice atual da loja na lista circular
        while (conta.getSaldo() > 0) {
            int valorCompra = valorespossiveis[new Random().nextInt(valorespossiveis.length)];

            synchronized (conta) {
                realizarCompra(valorCompra, lojas[indiceLojaAtual].getConta());
            }

            lojas[indiceLojaAtual].pagarSalarios();

            indiceLojaAtual = (indiceLojaAtual + 1) % lojas.length; // Atualiza o indice
        }
    }

    public Conta getConta() {
        return conta;
    }

    // Metodo para fazer a compra
    public synchronized void realizarCompra(int valor, Conta contaDestino) {
        if (conta.getSaldo() >= valor) { // Checa se há saldo suficiente na conta
            banco.transferencia(conta, contaDestino, valor); // Faz a transferência bancaria
            System.out.println(Thread.currentThread().getName() + " fez uma compra de R$" + valor);
        } else {
            System.out.println(Thread.currentThread().getName() + " não conseguiu terminar a compra de R$" + valor +
                    " (saldo insuficiente)");
        }
    }
}