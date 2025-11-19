import java.util.Scanner;

// 1. Exceção personalizada
class LoginInvalidoException extends Exception {
    public LoginInvalidoException(String mensagem) {
        super(mensagem);
    }
}

// 2. Classe do sistema de login
class SistemaLogin {
    private String senhaSecreta;

    // Construtor com valor default da senha
    public SistemaLogin() {
        this.senhaSecreta = "123456";
    }

    // Método que realiza o login e lança exceção se a senha estiver errada
    public void fazerLogin(String usuario, String senha) throws LoginInvalidoException {
        if (!senha.equals(this.senhaSecreta)) {
            throw new LoginInvalidoException("Senha inválida");
        }
        
        // Se chegou até aqui, a senha está correta
        System.out.println("Acesso CONCEDIDO! Bem-vindo, " + usuario + "!");
    }
}

// 3. Classe de teste com o método main
public class TesteLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaLogin sistema = new SistemaLogin();

        System.out.println("=== Sistema de Login ===");
        System.out.print("Digite o usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Bloco try-catch capturando a exceção personalizada
        try {
            sistema.fazerLogin(usuario, senha);
        } catch (LoginInvalidoException e) {
            System.out.println("Acesso Negado: Credenciais incorretas");
        }

        scanner.close();
    }
}