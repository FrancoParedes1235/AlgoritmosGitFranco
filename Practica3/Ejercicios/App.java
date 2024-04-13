public class App {
    public static void main(String[] args) {
        // Ejemplo de uso
        double[][] matriz = {
                {2, 1, -1},
                {-3, -1, 2},
                {-2, 1, 2}
        };

        System.out.println("Matriz original:");
        GaussJordan.imprimirMatriz(matriz);

        double[][] matrizInversa = GaussJordan.inversa(matriz);

        System.out.println("\nMatriz inversa:");
        GaussJordan.imprimirMatriz(matrizInversa);
    }
}
