public class Aluno {
    // ==============================
    // Atributos
    // ==============================
    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;
    private double notaTrabalho;

    // ==============================
    // Construtor
    // ==============================
    public Aluno(String nome, String matricula, double nota1, double nota2, double notaTrabalho) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.notaTrabalho = notaTrabalho;
    }

    // ==============================
    // Métodos
    // ==============================
    // Calcula a média aritmética das notas
    public double calcularMedia() {
        return (nota1 + nota2 + notaTrabalho) / 3;
    }

    // Verifica a situação do aluno com base na média
    public void verificarSituacao() {
        double media = calcularMedia();
        System.out.println("Aluno: " + nome + " | Matrícula: " + matricula);
        System.out.printf("Média: %.2f%n", media);

        if (media >= 7.0) {
            System.out.println("Situação: APROVADO ");
        } else {
            System.out.println("Situação: REPROVADO ");
        }

        System.out.println("-----------------------------------");
    }
}
