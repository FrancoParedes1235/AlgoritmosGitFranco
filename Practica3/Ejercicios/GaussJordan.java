public class GaussJordan {

    // Método para imprimir una matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double num : fila) {
                System.out.print(num + " "); // Imprime cada número de la fila seguido de un espacio
            }
            System.out.println(); // Al final de cada fila, imprime una nueva línea
        }
    }

    // Método para intercambiar dos filas en una matriz
    public static void intercambiarFilas(double[][] matriz, int fila1, int fila2) {
        double[] temp = matriz[fila1]; // Almacena la fila 1 temporalmente
        matriz[fila1] = matriz[fila2]; // Reemplaza la fila 1 con la fila 2
        matriz[fila2] = temp; // Reemplaza la fila 2 con la fila temporal (fila 1 original)
    }

    // Método para hacer ceros por debajo de un elemento en una columna
    public static void hacerCerosAbajo(double[][] matriz, int filaPivot, int columnaPivot) {
        int numFilas = matriz.length;
        double pivot = matriz[filaPivot][columnaPivot]; // El elemento en la posición del pivot
        for (int fila = filaPivot + 1; fila < numFilas; fila++) {
            double factor = matriz[fila][columnaPivot] / pivot; // Factor para hacer cero el elemento
            for (int columna = columnaPivot; columna < matriz[0].length; columna++) {
                matriz[fila][columna] -= factor * matriz[filaPivot][columna]; // Resta el producto del factor y el elemento de la fila del pivot
            }
        }
    }

    // Método para reducir la matriz a su forma escalonada reducida por filas
    public static void reducirAFilaEchelonForm(double[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
        int minDim = Math.min(numFilas, numColumnas); // Toma la dimensión más pequeña (filas o columnas)

        for (int fila = 0; fila < minDim; fila++) {
            // Encontrar el pivot no nulo en la columna actual
            int filaPivot = fila;
            while (filaPivot < numFilas && matriz[filaPivot][fila] == 0) {
                filaPivot++; // Busca el siguiente pivot no nulo
            }
            if (filaPivot == numFilas) continue; // No se encontró ningún pivot no nulo en la columna

            // Intercambiar la fila actual con la fila del pivot
            intercambiarFilas(matriz, fila, filaPivot);

            // Hacer ceros por debajo del pivot en la columna actual
            hacerCerosAbajo(matriz, fila, fila);
        }
    }

    // Método para hacer unos en la diagonal principal de una matriz
    public static void hacerUnosEnDiagonal(double[][] matriz) {
        int numFilas = matriz.length;
        for (int fila = 0; fila < numFilas; fila++) {
            double pivot = matriz[fila][fila];
            if (pivot != 0) {
                for (int columna = fila; columna < matriz[0].length; columna++) {
                    matriz[fila][columna] /= pivot; // Divide todos los elementos de la fila por el pivot
                }
            }
        }
    }

    // Método para llevar la matriz a la forma de la matriz identidad
    public static void reducirAReducedRowEchelonForm(double[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;
        int minDim = Math.min(numFilas, numColumnas);

        for (int fila = minDim - 1; fila >= 0; fila--) {
            // Hacer unos en la diagonal principal
            double pivot = matriz[fila][fila];
            if (pivot != 0) {
                for (int columna = fila; columna < numColumnas; columna++) {
                    matriz[fila][columna] /= pivot; // Divide todos los elementos de la fila por el pivot
                }
            }

            // Hacer ceros por encima del pivot en la columna actual
            for (int i = fila - 1; i >= 0; i--) {
                double factor = matriz[i][fila];
                for (int j = fila; j < numColumnas; j++) {
                    matriz[i][j] -= factor * matriz[fila][j]; // Resta el producto del factor y el elemento de la fila del pivot
                }
            }
        }
    }

    // Método para encontrar la matriz inversa
    public static double[][] inversa(double[][] matriz) {
        int numFilas = matriz.length;
        int numColumnas = matriz[0].length;

        // Concatenar la matriz original con la matriz identidad
        double[][] matrizAumentada = new double[numFilas][numColumnas * 2];
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                matrizAumentada[i][j] = matriz[i][j];
                // Agregar la matriz identidad
                matrizAumentada[i][j + numFilas] = (i == j) ? 1 : 0; // Añade 1 en la diagonal principal, 0 en otros lugares
            }
        }

        // Llevar la matriz a su forma escalonada reducida por filas
        reducirAFilaEchelonForm(matrizAumentada);

        // Llevar la matriz a su forma de la matriz identidad
        reducirAReducedRowEchelonForm(matrizAumentada);

        // Extraer la parte derecha de la matriz resultante, que será la inversa de la matriz original
        double[][] matrizInversa = new double[numFilas][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            System.arraycopy(matrizAumentada[i], numFilas, matrizInversa[i], 0, numColumnas);
        }

        return matrizInversa;
    }
}
