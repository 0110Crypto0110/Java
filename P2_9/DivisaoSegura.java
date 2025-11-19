
import java.util.Scanner;

public class DivisaoSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Calculadora de Divisão ===\n");
        
        while (true) {
            try {
                // Lê o primeiro número
                System.out.print("Digite o primeiro número inteiro (dividendo): ");
                String entrada1 = scanner.nextLine();
                
                // Lê o segundo número
                System.out.print("Digite o segundo número inteiro (divisor): ");
                String entrada2 = scanner.nextLine();
                
                // Converte para int (pode lançar NumberFormatException)
                int num1 = Integer.parseInt(entrada1);
                int num2 = Integer.parseInt(entrada2);
                
                // Verifica divisão por zero
                if (num2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida.");
                }
                
                // Realiza a divisão (divisão de inteiros dá resultado inteiro, 
                // mas vamos mostrar com casas decimais para ficar mais claro)
                double resultado = (double) num1 / num2;
                
                System.out.printf("\nO resultado da divisão %d ÷ %d é: %.4f\n\n", 
                                  num1, num2, resultado);
                
                System.out.println("Obrigado por usar o programa!");
                break; // Sai do loop com sucesso
                
            } catch (NumberFormatException e) {
                System.out.println("Erro: Você digitou algo que não é um número inteiro válido.");
                System.out.println("Por favor, digite apenas números inteiros (ex: -5, 0, 42).\n");
                
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("O divisor (segundo número) não pode ser zero.\n");
                
            } catch (Exception e) {
                // Qualquer outro erro inesperado
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage() + "\n");
            }
        }
        
        scanner.close();
    }
}