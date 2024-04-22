import java.util.Arrays;

public class SubsetSum {
    public static boolean progressiveSum(int[] arr, int target) {
        int n = arr.length;

        // Llama a la función auxiliar recursiva
        return progressiveSumRecursive(arr, n, target);
    }

    // Función auxiliar recursiva
    private static boolean progressiveSumRecursive(int[] arr, int n, int target) {
        // Caso base: si el objetivo es 0, devuelve true
        if (target == 0) {
            return true;
        }

        // Caso base: si no hay elementos en el arreglo o el objetivo es negativo,
        // devuelve false
        if (n == 0 || target < 0) {
            return false;
        }

        // Llama recursivamente con el último elemento excluido y el objetivo reducido
        return progressiveSumRecursive(arr, n - 1, target) ||
                progressiveSumRecursive(arr, n - 1, target - arr[n - 1]);
    }

    public static boolean subsetSum(int[] nums, int target) {
        boolean foundSevenFollowedByOne = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 && nums[i + 1] == 1) {
                foundSevenFollowedByOne = true;
                break;
            }
        }
        if (foundSevenFollowedByOne) {
            return sieteSeguido(nums, target);
        } else {
            return sieteNoSeguido(nums, target);
        }
    }// progabndo

    public static boolean probar(int[] nums, int target) {
        boolean foundSevenFollowedByOne = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 7 && nums[i + 1] == 1) {
                foundSevenFollowedByOne = true;
                return true;
            }
        }
        return false;
    }

    public static void borrarNumero(int[] arreglo, int numero) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == numero) {
                arreglo[i] = 0; // Cambia el valor del elemento encontrado a 0
                break; // Termina el bucle después de eliminar la primera ocurrencia del número
            }
        }
    }

    private static boolean sieteSeguido(int[] nums, int target) {
        if (target < 0) {
            return false; // Si alcanzamos el objetivo, devolvemos true
        }
        // Eliminar los sietes del arreglo
        borrarNumero(nums, 7);
        // Verificar la suma en combinaciones
        if (progressiveSum(nums, target)) {
            return true;
        }
        return false; // Si no se encuentra ninguna combinación que cumpla, devolvemos false
    }

    private static boolean sieteNoSeguido(int[] nums, int target) {
        if (target < 0) {
            return false; // Si el objetivo es menor que 7, no se puede alcanzar sumando 7
        }
        // Eliminar los sietes del arreglo
        borrarNumero(nums, 7);
        // Agregar el 7 al objetivo
        target -= 7;
        // Verificar la suma en combinaciones
        if (progressiveSum(nums, target)) {
            return true;
        }
        return false; // Si no se encuentra ninguna combinación que cumpla, devolvemos false
    }

    // Método principal para probar la función subsetSum.
    public static void main(String[] args) {
        // Ejemplos de entrada y salida esperada

        int[] nums1 = { 2, 7, 10, 4 };
        int target1 = 17;
        System.out.println(Arrays.toString(nums1) + " " + target1 + " " +
                subsetSum(nums1, target1)); // Output: true

        int[] nums2 = { 2, 7, 10, 4 };
        int target2 = 16;
        System.out.println(Arrays.toString(nums2) + " " + target2 + " " +
                subsetSum(nums2, target2)); // Output: false

        int[] nums3 = { 2, 7, 1, 4 };
        int target3 = 6;
        System.out.println(Arrays.toString(nums3) + " " + target3 + " " +
                subsetSum(nums3, target3)); // Output: true

        int[] nums4 = { 2, 7, 1, 4 };
        int target4 = 7;
        System.out.println(Arrays.toString(nums4) + " " + target4 + " " +
                subsetSum(nums4, target4)); // Output: true

        int[] nums5 = { 2, 7, 1, 4 };
        int target5 = 8;
        System.out.println(Arrays.toString(nums5) + " " + target5 + " " +
                subsetSum(nums5, target5)); // Output: false

    }
}
