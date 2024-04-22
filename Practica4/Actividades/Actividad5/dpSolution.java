public class dpSolution {
    // Método para obtener el valor máximo posible al cortar la varilla
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1]; // Arreglo para almacenar las soluciones parciales
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1; // Variable temporal para almacenar el valor máximo temporal
            for (int j = 0; j < i; j++)
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]); // Calcula el máximo entre el valor actual y la suma del valor anterior y la solución parcial correspondiente
            subSolutions[i] = tmpMax; // Almacena el valor máximo en el arreglo de soluciones parciales
        }
        return subSolutions[rodLength]; // Devuelve el valor máximo posible al cortar la varilla de longitud dada
    }

    public static void main(String[] args) {
        int[] values = new int[] { 3, 7, 1, 3, 9 }; // Valores asociados a cortes de varilla de diferentes longitudes
        int rodLength = values.length; // Longitud de la varilla
        System.out.println("El valor máximo: " + getValue(values, rodLength)); // Imprime el valor máximo posible al cortar la varilla
    }
}
