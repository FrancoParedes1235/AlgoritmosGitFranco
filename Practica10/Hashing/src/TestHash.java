import java.io.*;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestHash {
    public static void main(String[] args) {
        try {
            // Leer el archivo
            File file = new File(
                    "D:\\franco\\franco tareas u\\UCSM 2024\\Algoritmos\\GitAlgoritmos\\Fase3\\Hashing\\EMPLEADO.TXT");
            Scanner scanner = new Scanner(file);

            // Leer la cantidad de empleados desde la primera línea
            int numRegistros = Integer.parseInt(scanner.nextLine().trim());

            // Crear la tabla hash con el tamaño igual al número de registros
            HashA<Empleado> hashTable = new HashA<>(numRegistros);

            // Leer los registros y agregarlos a la tabla hash
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int codigo = Integer.parseInt(parts[0].trim());
                String nombre = parts[1].trim();
                String direccion = parts[2].trim();

                Empleado emp = new Empleado(codigo, nombre, direccion);
                hashTable.insert(codigo, emp);
            }
            scanner.close();

            // Mostrar la tabla hash
            System.out.println(hashTable);

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado. Asegúrate de que la ruta es correcta.");
        }
    }

    private static int calculatePrime(int number) {
        // Implementar la búsqueda de un número primo mayor que el dado
        while (!isPrime(number))
            number++;
        return number;
    }

    private static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        if (number <= 3)
            return true;
        if (number % 2 == 0 || number % 3 == 0)
            return false;
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
