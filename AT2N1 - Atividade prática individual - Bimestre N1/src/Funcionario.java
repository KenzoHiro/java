public class Funcionario extends Thread {
    public static final int SALARIO = 1400; // Salário fixo
    private Conta contaSalario;
    private Conta contaInvestimentos;

    public Funcionario(Conta contaSalario, Conta contaInvestimentos) {
        this.contaSalario = contaSalario;
        this.contaInvestimentos = contaInvestimentos;
    }

    // Metodo que faz o investimento de cada funcionario
    public void investir() {
        synchronized (contaSalario) { // Sincronização para garantir operações coordenadas nas contas
            if (contaSalario.getSaldo() >= SALARIO) { // Verifica se há saldo suficiente para investimento
                double valorInvestimento = SALARIO * 0.2; // Calcula o valor do investimento (20% do salário)
                contaSalario.sacar(valorInvestimento); // Faz o saque do salário
                contaInvestimentos.depositar(valorInvestimento); // faz o deposito do investimento
                System.out.println(Thread.currentThread().getName() + " investiu R$" + valorInvestimento);
            } else {
                System.out.println(Thread.currentThread().getName() + " sem dinheiro para investir");
            }
        }
    }

    public Conta getContaSalario() {
        return contaSalario;
    }

    public Conta getContaInvestimentos() {
        return contaInvestimentos;
    }
}