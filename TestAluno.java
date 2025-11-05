public class TestAluno {
    public static void main(String[] args) {
        // Instanciando dois alunos com notas diferentes
        Aluno a1 = new Aluno("João Ricardo", "2025001", 8.0, 7.5, 9.0);
        Aluno a2 = new Aluno("Maria Fernanda", "2025002", 5.0, 6.0, 4.5);

        // Verificando situação de cada aluno
        System.out.println("=== Resultados dos Alunos ===");
        a1.verificarSituacao();
        a2.verificarSituacao();
    }
}
