import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// ==============================
// Superclasse Funcionario
// ==============================
abstract class Funcionario {
    // ==============================
    // Atributos
    // ==============================
    protected String nome;
    protected String cpf;
    protected double salario;
    protected Date dataNascimento;

    // ==============================
    // Construtores
    // ==============================
    public Funcionario(String nome, String cpf, double salario, String dataNascimentoStr) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            this.dataNascimento = sdf.parse(dataNascimentoStr);
        } catch (ParseException e) {
            System.out.println("Data inválida. Usando data atual.");
            this.dataNascimento = new Date();
        }
    }

    // ==============================
    // Métodos
    // ==============================
    // Método a ser sobrescrito pelas subclasses
    public abstract double getSalario();

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Nome: " + nome + ", CPF: " + cpf + ", Salário Base: R$" + String.format("%.2f", salario) +
               ", Data Nascimento: " + sdf.format(dataNascimento);
    }
}

// ==============================
// Subclasse Gerente
// ==============================
class Gerente extends Funcionario {
    // ==============================
    // Atributos
    // ==============================
    private static final double BONIFICACAO = 2000.00;

    // ==============================
    // Construtores
    // ==============================
    public Gerente(String nome, String cpf, double salario, String dataNascimentoStr) {
        super(nome, cpf, salario, dataNascimentoStr);
    }

    // ==============================
    // Métodos
    // ==============================
    @Override
    public double getSalario() {
        return salario + BONIFICACAO;
    }

    @Override
    public String toString() {
        return "[GERENTE] " + super.toString() + " | Salário Total: R$" + String.format("%.2f", getSalario());
    }
}

// ==============================
// Subclasse Atendente
// ==============================
class Atendente extends Funcionario {
    // ==============================
    // Atributos
    // ==============================
    private double comissao;

    // ==============================
    // Construtores
    // ==============================
    public Atendente(String nome, String cpf, double salario, String dataNascimentoStr, double comissao) {
        super(nome, cpf, salario, dataNascimentoStr);
        this.comissao = comissao;
    }

    // ==============================
    // Métodos
    // ==============================
    @Override
    public double getSalario() {
        return salario + comissao;
    }

    @Override
    public String toString() {
        return "[ATENDENTE] " + super.toString() + ", Comissão: R$" + String.format("%.2f", comissao) +
               " | Salário Total: R$" + String.format("%.2f", getSalario());
    }
}

// ==============================
// Classe principal com menu
// ==============================
public class SistemaFuncionarios {
    // ==============================
    // Atributos
    // ==============================
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // ==============================
    // Métodos
    // ==============================
    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> adicionarGerente();
                case 2 -> adicionarAtendente();
                case 3 -> listarFuncionarios();
                case 4 -> mostrarSalarioPorCpf();
                case 5 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n=== SISTEMA DE FUNCIONÁRIOS ===");
        System.out.println("1. Adicionar gerente");
        System.out.println("2. Adicionar atendente");
        System.out.println("3. Listar todos os funcionários");
        System.out.println("4. Mostrar salário de funcionário (por CPF)");
        System.out.println("5. Sair");
    }

    private static void adicionarGerente() {
        System.out.println("\n--- Adicionar Gerente ---");
        String nome = lerString("Nome: ");
        String cpf = lerString("CPF: ");
        double salario = lerDouble("Salário base: ");
        String dataNasc = lerString("Data de nascimento (dd/MM/yyyy): ");

        Gerente gerente = new Gerente(nome, cpf, salario, dataNasc);
        funcionarios.add(gerente);
        System.out.println("Gerente adicionado com sucesso!");
    }

    private static void adicionarAtendente() {
        System.out.println("\n--- Adicionar Atendente ---");
        String nome = lerString("Nome: ");
        String cpf = lerString("CPF: ");
        double salario = lerDouble("Salário base: ");
        String dataNasc = lerString("Data de nascimento (dd/MM/yyyy): ");
        double comissao = lerDouble("Comissão: ");

        Atendente atendente = new Atendente(nome, cpf, salario, dataNasc, comissao);
        funcionarios.add(atendente);
        System.out.println("Atendente adicionado com sucesso!");
    }

    private static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Funcionários ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }

    private static void mostrarSalarioPorCpf() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        String cpf = lerString("Digite o CPF do funcionário: ");
        Funcionario encontrado = null;

        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                encontrado = f;
                break;
            }
        }

        if (encontrado != null) {
            System.out.println("Salário total: R$" + String.format("%.2f", encontrado.getSalario()));
        } else {
            System.out.println("Funcionário com CPF " + cpf + " não encontrado.");
        }
    }

    // Métodos auxiliares para entrada de dados
    private static String lerString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int lerInteiro(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static double lerDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número decimal (use ponto como separador).");
            }
        }
    }
}
