import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Conta {
    private String cliente;
    private double saldo;
    private Lock lock = new ReentrantLock(); // Lock para garantir a sincronização

    public Conta(String cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    // Metodo para depositar nas contas
    public void depositar(double valor) {
        lock.lock(); // Inicia o bloqueio do lock
        try {
            saldo += valor; // Incrementa o saldo com o valor do depósito
        } finally {
            lock.unlock(); // Libera o lock
        }
    }

    // Metodo para sacar nas contas
    public void sacar(double valor) {
        lock.lock(); // Inicia o bloqueio do lock
        try {
            saldo -= valor; // Decrementa o saldo com o valor do saque
        } finally {
            lock.unlock(); // Libera o lock
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public String toString() {
        return cliente;
    }
}