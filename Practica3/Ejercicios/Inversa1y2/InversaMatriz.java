//Complejidad algoritmica de O(n3)
public class InversaMatriz {

    public static double[][] encontrarInversa(double[][] matriz) {
        int n = matriz.length;

        // Inicializar una matriz identidad del mismo tamaño que la matriz original
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            inversa[i][i] = 1;
        }

        // Aplicar eliminación gaussiana
        for (int i = 0; i < n; i++) {
            // Pivoteo parcial: encontrar el máximo elemento en la columna actual
            int maxFila = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxFila][i])) {
                    maxFila = k;
                }
            }

            // Intercambiar filas si es necesario para tener el pivote en la diagonal
            if (maxFila != i) {
                double[] temp = matriz[i];
                matriz[i] = matriz[maxFila];
                matriz[maxFila] = temp;

                temp = inversa[i];
                inversa[i] = inversa[maxFila];
                inversa[maxFila] = temp;
            }

            // Hacer que el elemento diagonal sea igual a 1
            double divisor = matriz[i][i];
            for (int j = 0; j < n; j++) {
                matriz[i][j] /= divisor;
                inversa[i][j] /= divisor;
            }

            // Restar múltiplos de la fila actual para hacer ceros debajo del pivote
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j < n; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                        inversa[k][j] -= factor * inversa[i][j];
                    }
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
