public class MedianWithoutSorting {

    public static double findMedian(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Encuentra el valor máximo y mínimo en el arreglo
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Calcula el tamaño del arreglo de frecuencias
        int[] freq = new int[max - min + 1];
        for (int num : arr) {
            freq[num - min]++;
        }

        // Calcula la suma acumulativa de las frecuencias
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        int n = arr.length;
        int medianIdx = (n + 1) / 2 - 1;

        // Encuentra el índice donde la suma acumulativa es igual o mayor a la mitad del
        // tamaño del arreglo
        int median = min;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > medianIdx) {
                median = i + min;
                break;
            }
        }

        // Si el tamaño del arreglo es impar, la mediana es el elemento correspondiente
        // a ese índice
        // Si es par, la mediana es el promedio de los dos elementos correspondientes a
        // ese índice y al siguiente índice
        if (n % 2 == 1) {
            return median;
        } else {
            // Encuentra el siguiente elemento al índice de la mediana
            int nextMedian = median;
            for (int i = median - min + 1; i < freq.length; i++) {
                if (freq[i] > medianIdx + 1) {
                    nextMedian = i + min;
                    break;
                }
            }
            return (median + nextMedian) / 2.0;
        }
    }

}
