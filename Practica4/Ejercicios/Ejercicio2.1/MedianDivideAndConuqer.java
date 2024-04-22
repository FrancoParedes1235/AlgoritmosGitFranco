import java.util.Arrays;

public class MedianDivideAndConquer {

    // Método principal para encontrar la mediana de un arreglo
    public static double findMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1) {
            // Si el tamaño del arreglo es impar, la mediana es el elemento en la posición (n+1)/2
            return findKthSmallest(arr, n / 2 + 1);
        } else {
            // Si el tamaño del arreglo es par, la mediana es el promedio de los elementos en las posiciones n/2 y (n/2)+1
            return (findKthSmallest(arr, n / 2) + findKthSmallest(arr, n / 2 + 1)) / 2.0;
        }
    }

    // Método para encontrar el k-ésimo elemento más pequeño en un arreglo
    private static int findKthSmallest(int[] arr, int k) {
        return findKthSmallest(arr, 0, arr.length - 1, k);
    }

    // Método auxiliar recursivo para encontrar el k-ésimo elemento más pequeño en un subarreglo
    private static int findKthSmallest(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left]; // Caso base: si el subarreglo tiene un solo elemento, devuelve ese elemento
        }

        int pivotIndex = partition(arr, left, right); // Índice del pivote después de la partición

        int pivotRank = pivotIndex - left + 1; // Rango del pivote en el subarreglo

        if (k == pivotRank) {
            return arr[pivotIndex]; // Si el rango del pivote es igual a k, devuelve el pivote
        } else if (k < pivotRank) {
            return findKthSmallest(arr, left, pivotIndex - 1, k); // Si k es menor que el rango del pivote, busca en el subarreglo izquierdo
        } else {
            return findKthSmallest(arr, pivotIndex + 1, right, k - pivotRank); // Si k es mayor que el rango del pivote, busca en el subarreglo derecho
        }
    }

    // Método para realizar la partición del arreglo
    private static int partition(int[] arr, int left, int right) {
        int pivotIndex = getPivotIndex(arr, left, right); // Obtiene el índice del pivote
        int pivotValue = arr[pivotIndex]; // Obtiene el valor del pivote
        swap(arr, pivotIndex, right); // Mueve el pivote al final del arreglo
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, i, storeIndex); // Intercambia elementos menores que el pivote a la izquierda
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right); // Mueve el pivote de vuelta a su lugar correcto
        return storeIndex;
    }

    // Método para obtener el índice del pivote (en este caso, simplemente se usa el primer elemento)
    private static int getPivotIndex(int[] arr, int left, int right) {
        return left;
    }

    // Método para intercambiar dos elementos en un arreglo
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
