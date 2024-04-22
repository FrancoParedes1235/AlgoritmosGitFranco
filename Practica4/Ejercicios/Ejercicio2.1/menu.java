import java.util.Arrays;

public class menu {
    public static void main(String[] args) {
        MedianDivideAndConquer a = new MedianDivideAndConquer();
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16 };
        System.out.println("Arreglo: " + Arrays.toString(arr));
        System.out.println("Mediana: " + a.findMedian(arr));
    }

}
