public class TestProduto {
    public static void main(String[] args) {
        // Criando dois produtos
        Produto p1 = new Produto("Teclado Mecânico", 250.00, 10);
        Produto p2 = new Produto("Mouse Gamer", 150.00, 5);

        // Exibindo informações
        System.out.println("=== Informações Iniciais ===");
        p1.exibirInfo();
        p2.exibirInfo();

        // Calculando valor total do estoque de um produto
        double valorTotal = p1.calcularValorTotalEmEstoque();
        System.out.println("Valor total em estoque do produto \"" + p1 + "\": R$ " + valorTotal);
        System.out.println();

        // Adicionando mais itens ao estoque
        p1.adicionarEstoque(5);
        System.out.println();

        // Exibindo informações novamente
        System.out.println("=== Informações Atualizadas ===");
        p1.exibirInfo();
    }

    
}
