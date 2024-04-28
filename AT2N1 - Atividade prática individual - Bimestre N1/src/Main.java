public class Main {
    public static void main(String[] args) {
        // Criação do banco para intermediar as transações
        Banco banco = new Banco();

        // Criação das contas para as duas lojas
        Conta contaLoja1 = new Conta("Loja 1", 0);
        Conta contaLoja2 = new Conta("Loja 2", 0);

        // Criação dos funcionarios para cada loja, incluindo suas contas de salário e investimentos
        Funcionario funcionario1Loja1 = new Funcionario(new Conta("Funcionario 1 (Loja 1)", 0),
                new Conta("Investimento Funcionario 1 (Loja 1)", 0));
        Funcionario funcionario2Loja1 = new Funcionario(new Conta("Funcionario 2 (Loja 1)", 0),
                new Conta("Investimento Funcionario 2 (Loja 1)", 0));
        Funcionario funcionario1Loja2 = new Funcionario(new Conta("Funcionario 1 (Loja 2)", 0),
                new Conta("Investimento Funcionario 1 (Loja 2)", 0));
        Funcionario funcionario2Loja2 = new Funcionario(new Conta("Funcionario 2 (Loja 2)", 0),
                new Conta("Investimento Funcionario 2 (Loja 2)", 0));

        // Início das threads dos funcionarios para processar os pagamentos e investimentos
        funcionario1Loja1.start();
        funcionario2Loja1.start();
        funcionario1Loja2.start();
        funcionario2Loja2.start();

        // Criação das lojas com suas contas e funcionarios associados
        Loja loja1 = new Loja(contaLoja1, new Funcionario[] { funcionario1Loja1, funcionario2Loja1 }, banco);
        Loja loja2 = new Loja(contaLoja2, new Funcionario[] { funcionario1Loja2, funcionario2Loja2 }, banco);

        // Criação das contas para os clientes e início das threads dos clientes para realizar as compras
        Conta[] contasClientes = new Conta[5];
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < 5; i++) {
            contasClientes[i] = new Conta("Cliente " + (i + 1), 1000);
            clientes[i] = new Cliente(contasClientes[i], new Loja[] { loja1, loja2 }, banco);
        }

        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Aguarda o término das threads dos clientes para prosseguir
        try {
            for (Cliente cliente : clientes) {
                cliente.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Aguarda o término das threads dos funcionarios para prosseguir
        try {
            funcionario1Loja1.join();
            funcionario2Loja1.join();
            funcionario1Loja2.join();
            funcionario2Loja2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Impressões dos das contas
        System.out.println("Saldos finais:\n\n");
        System.out.println("\nSaldo das lojas:");
        System.out.println("Loja 1: R$" + contaLoja1.getSaldo());
        System.out.println("Loja 2: R$" + contaLoja2.getSaldo());

        System.out.println("\nSalário dos funcionarios:");
        System.out.println("Salário Funcionário 1 (Loja 1): R$" + funcionario1Loja1.getContaSalario().getSaldo());
        System.out.println("Salário Funcionário 2 (Loja 1): R$" + funcionario2Loja1.getContaSalario().getSaldo());
        System.out.println("Salário Funcionário 1 (Loja 2): R$" + funcionario1Loja2.getContaSalario().getSaldo());
        System.out.println("Salário Funcionário 2 (Loja 2): R$" + funcionario2Loja2.getContaSalario().getSaldo());

        System.out.println("\nInvestimento dos funcionarios:");
        System.out.println("Investimento Funcionário 1 (Loja 1): R$" + funcionario1Loja1.getContaInvestimentos().getSaldo());
        System.out.println("Investimento Funcionário 2 (Loja 1): R$" + funcionario2Loja1.getContaInvestimentos().getSaldo());
        System.out.println("Investimento Funcionário 1 (Loja 2): R$" + funcionario1Loja2.getContaInvestimentos().getSaldo());
        System.out.println("Investimento Funcionário 2 (Loja 2): R$" + funcionario2Loja2.getContaInvestimentos().getSaldo());

        System.out.println("\nSaldo dos clientes:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Cliente " + (i + 1) + ": R$" + contasClientes[i].getSaldo());
        }
    }
}
