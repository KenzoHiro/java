public class Main {
    public static void main(String[] args) {
        Endereco endereco1 = new Endereco("Rua benedito", "Luziania", "GO");

        Telefone telefone1 = new Telefone("1234567890", "Residencial", "61");
        Telefone telefone2 = new Telefone("9876543210", "Celular", "62");

        Aluno aluno1 = new Aluno("Kenzo", "12345678901", "Kenzo@email.com", 8.5);
        aluno1.setEndereco(endereco1);
        aluno1.addTelefone(telefone1);

        Aluno aluno2 = new Aluno("Maria", "234534534532", "maria@email.com", 9.0);
        aluno2.setEndereco(endereco1);
        aluno2.addTelefone(telefone2);

        Curso curso1 = new Curso("CC");
        Curso curso2 = new Curso("ADS");

        Professor professor1 = new Professor("Hially", "34567890123", "Hially@email.com", "Doutorado", 5000.0);
        professor1.setEndereco(endereco1);
        professor1.addTelefone(telefone1);

        Disciplina disciplina1 = new Disciplina("POO");

        disciplina1.adicionarAluno(aluno1);
        disciplina1.adicionarAluno(aluno2);
        disciplina1.adicionarCurso(curso1);
        disciplina1.adicionarCurso(curso2);
        disciplina1.setProfessor(professor1);

        professor1.addCurso(curso1);

        disciplina1.imprimirDisciplina();

        System.out.println("\nInformações do Aluno 1:");
        aluno1.imprimirAluno();

        System.out.println("\nInformações do Aluno 2:");
        aluno2.imprimirAluno();

        System.out.println("\nInformações do Professor:");
        professor1.imprimirProfessor();
    }
}