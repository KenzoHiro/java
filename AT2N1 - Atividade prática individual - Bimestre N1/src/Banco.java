import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private Lock lock = new ReentrantLock(); // Lock para garantir a sincronização

    // Metodo para transferência entre contas
    public void transferencia(Conta origem, Conta destino, double valor) {
        lock.lock(); // Inicia o bloqueio do lock
        try {
            if (origem.getSaldo() >= valor) { // Checa se a conta de origem possui saldo suficiente
                origem.sacar(valor); // Faz o saque na conta de origem
                destino.depositar(valor); // Faz o depósito na conta de destino
                System.out.println(origem.getCliente() + " transferiu " + valor + " para " + destino.getCliente());
            } else {
                System.out.println(origem.getCliente() + " falhou na transferência para " + destino.getCliente() +
                        " (saldo insuficiente)");
            }
        } finally {
            lock.unlock(); // Libera o lock
        }
    }
}