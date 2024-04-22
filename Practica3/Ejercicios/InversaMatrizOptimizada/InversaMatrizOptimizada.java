//Complejidad algoritmica O(n2)
public class InversaMatrizOptimizada {

    public static double[][] encontrarInversa(double[][] matriz) {
        int n = matriz.length;

        // Inicializar una matriz identidad del mismo tamaño que la matriz original
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            inversa[i][i] = 1;
        }

        // Aplicar eliminación gaussiana
        for (int i = 0; i < n; i++) {
            // Hacer que el elemento diagonal sea igual a 1
            double divisor = matriz[i][i];
            for (int j = 0; j < n; j++) {
                matriz[i][j] /= divisor;
                inversa[i][j] /= divisor;
            }

            // Hacer ceros debajo del pivote
            for (int k = i + 1; k < n; k++) {
                double factor = matriz[k][i];
                // Operar en bloques para reducir la complejidad a O(n^2)
                for (int j = 0; j < n; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                    inversa[k][j] -= factor * inversa[i][j];
                }
            }
        }

        // Hacer ceros encima del pivote
        for (int i = n - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                double factor = matriz[k][i];
                // Operar en bloques para reducir la complejidad a O(n^2)
                for (int j = 0; j < n; j++) {
                    matriz[k][j] -= factor * matriz[i][j];
                    inversa[k][j] -= factor * inversa[i][j];
                }
            }
        }

        return inversa;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        double[][] matriz = { { 2, 1, 3 }, { 0, 4, -1 }, { 1, 2, 1 } };
        double[][] inversa = encontrarInversa(matriz);

        // Imprimir la matriz inversa
        for (int i = 0; i < inversa.length; i++) {
            for (int j = 0; j < inversa[0].length; j++) {
                System.out.print(inversa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
