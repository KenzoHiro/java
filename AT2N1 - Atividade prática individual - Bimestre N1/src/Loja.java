public class Loja {
    private Conta conta; 
    private Funcionario[] funcionarios; // Array de funcionários da loja
    private Banco banco; 

    public Loja(Conta conta, Funcionario[] funcionarios, Banco banco) {
        this.conta = conta;
        this.funcionarios = funcionarios;
        this.banco = banco;
    }

    // Metodo para pagar os salários dos funcionários
    int indiceFuncionarioAtual = 0; // Cria o indice atual do funcionario na lista circular

    public synchronized void pagarSalarios() {
        if (conta.getSaldo() >= Funcionario.SALARIO) { // Checa se a conta da loja tem saldo suficiente para pagar o salário
            conta.sacar(Funcionario.SALARIO); // Faz o saque do valor do salário da conta da loja
            Funcionario funcionarioAtual = funcionarios[indiceFuncionarioAtual]; // Obtém o funcionario atual da lista circular
            funcionarioAtual.getContaSalario().depositar(Funcionario.SALARIO); // Deposita o salário na conta do funcionario
            funcionarioAtual.investir(); // Faz o investimento do funcionario
            System.out.println(funcionarioAtual.getName() + " foi pago");

            indiceFuncionarioAtual = (indiceFuncionarioAtual + 1) % funcionarios.length; // Atualiza o índice de forma circular para o próximo funcionario
        } else {
            System.out.println("Não foi possível pagar o funcionario"); 
        }
    }

    public Conta getConta() {
        return conta; 
    }

    public Banco getBanco() {
        return banco; 
    }
}
