import java.util.Scanner;

public class p23atv {
    //==============================================================
    //Main
    //==============================================================
    public static void main(String[] args){
        // Test Notas
        Notas();

        // Test Hipotenusa
        double a = 3.0, b = 4.0;
        System.out.println("Hipotenusa de " + a + " e " + b + ": " + Hipotenusa(a, b));

        // Test lista 
        int[] array = {5, 2, 9, 1, 7};
        System.out.println("Maior valor no array: " + Lista(array));

        // Test elementoExiste
        int[] array2 = {1, 2, 3, 4, 5};
        int valor = 3;
        System.out.println("Elemento " + valor + " existe? " + ElementoExiste(array2, valor));

        // Test pares
        int[] numeros = {1, 2, 3, 4, 5, 6};
        int[] resultado = Pares(numeros);
        System.out.println("Pares: " + resultado[0] + ", Ímpares: " + resultado[1]);

        // Test SomarMatriz
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Soma da matriz: " + SomarMatriz(matriz));

        // Test menorValorMatriz
        System.out.println("Menor valor da matriz: " + MenorValorMatriz(matriz));

        // Test somarDiagonalPrincipal
        System.out.println("Soma da diagonal principal: " + SomarDiagonalPrincipal(matriz));
    
    }
    //==============================================================
    //Recebe notas
    //==============================================================
    public static void Notas(){
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int contador = 0; 

        while(true){
            System.out.println("Digita uma nota ou -1 para cancelar :");
            double nota = scanner.nextDouble();
            if(nota==-1){
                System.out.println("cancelando :"); 
                break;

            }
            soma = soma + nota;
            contador++;


        }
        if (contador> 0) {
            double media = soma/contador;
            System.out.println("media :" + media);
            
            
        }
        scanner.close();
    }
    //==============================================================
    //Calculo de hipotenusa
    //==============================================================
    public static double Hipotenusa(double a, double b){
        double hipotenusa = 0;
        double AA = a*a;
        double BB = b*b;
        hipotenusa = Math.sqrt((AA+BB));
        return hipotenusa;
    }
    
    //==============================================================
    //Maior numero do array
    //==============================================================
    public static int Lista(int[] lista){
        int Maior= lista[0];
        for (int i = 0; i<lista.length;i++){
            if(lista[i]>Maior){
                Maior = lista[i];
            }
        }
        return Maior;
    }

    //==============================================================
    //ElemntoExiste
    //==============================================================
    public static Boolean ElementoExiste (int[] lista, int  a){
        for(int i = 0; i<lista.length;i++){
            if(lista[i]==a){
                return true;
            }
        }
        return false;
    }

    //==============================================================
    //ContarPARES
    //==============================================================
    public static int[] Pares(int[] numero){
        int impar = 0; 
        int par = 0;

        for(int i =0; i<numero.length;i++){
            if(numero[i] % 2 == 0){
                par++;
            } else{ 
                impar++;
            }
        }
        return new int[]{par,impar};
    }

    //==============================================================
    //SomarMatriz
    //==============================================================
    public static int SomarMatriz(int[][]matriz){
        int soma = 0;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                soma = soma + matriz[i][j];
            }
        }
        return soma;
    }
    //==============================================================
    //MenorValorMatriz
    //==============================================================
    public static int MenorValorMatriz(int[][]mmatriz){
        int menor = mmatriz[0][0];
        for(int i=0;i<mmatriz.length;i++){
            for(int j=0;j<mmatriz[i].length;j++){
                if(mmatriz[i][j]<menor){
                    menor = mmatriz[i][j];
                }
            }
        }
        return menor;

    }

    //==============================================================
    //somarDiagonalPrincipal
    //==============================================================
    public static int SomarDiagonalPrincipal(int[][]matrizD){
        int somaD = 0;
        for(int i=0;i<matrizD.length;i++){
            somaD = somaD + matrizD[i][i]; 
        }
        return somaD;
    }
}
