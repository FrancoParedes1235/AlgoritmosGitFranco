import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        MedianWithoutSorting a = new MedianWithoutSorting();
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
        System.out.println("Arreglo: " + Arrays.toString(arr));
        System.out.println("Mediana: " + a.findMedian(arr));
    }

}
