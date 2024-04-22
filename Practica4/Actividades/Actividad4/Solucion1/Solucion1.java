public class Solucion1 {
    // Método para encontrar la moda en un arreglo de enteros
    public static int moda1(int array[]) {
        int first = 0; // Índice del primer elemento del arreglo
        int end = array.length - 1; // Índice del último elemento del arreglo

        // Si el arreglo tiene solo un elemento, ese es la moda
        if (first == end) {
            return array[first];
        }
        
        // Se inicializa la moda con el primer elemento del arreglo
        int moda = array[first];
        // Se calcula la frecuencia del primer elemento
        int maxfrec = frecuencia(array, first, end, moda);

        // Se itera sobre los elementos del arreglo para encontrar la moda
        for (int i = first + 1; i < end; i++) {
            // Se calcula la frecuencia del elemento actual
            int frec = frecuencia(array, i, end, array[i]);
            // Si la frecuencia del elemento actual es mayor que la frecuencia máxima encontrada hasta ahora,
            // se actualiza la moda y la frecuencia máxima
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i];
            }
        }
        return moda; // Se devuelve la moda encontrada
    }

    // Método para calcular la frecuencia de un elemento en un rango específico del arreglo
    private static int frecuencia(int[] array, int first, int end, int ele) {
        if (first > end)
            return 0; // Si el rango es inválido, la frecuencia es cero
        int suma = 0; // Se inicializa la suma de frecuencias en cero
        // Se itera sobre el rango y se cuenta cuántas veces aparece el elemento
        for (int i = first; i <= end; i++) {
            if (array[i] == ele) {
                suma++;
            }
        }
        return suma; // Se devuelve la frecuencia del elemento
    }
}
