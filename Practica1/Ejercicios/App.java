import java.util.Scanner;

public class App {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingrese el número máximo de rectángulos a crear:");
                int numMaxRectangulos = scanner.nextInt();
                scanner.nextLine(); // Consumir el carácter de nueva línea

                ContainerRect contenedor = new ContainerRect(numMaxRectangulos);
                // Crear un contenedor

                boolean continuar = true;
                while (continuar) {
                        System.out.println("¿Qué desea hacer?");
                        System.out.println("1. Agregar un rectángulo");
                        System.out.println("2. Comparar dos rectángulos almacenados");
                        System.out.println("3. Mostrar Rectangulos ");
                        System.out.println("4. Salir");
                        int opcion = scanner.nextInt();
                        scanner.nextLine(); // Consumir el carácter de nueva línea
                        switch (opcion) {
                                case 1:
                                        if (contenedor.getNumRec() < numMaxRectangulos) {
                                                for (int i = 0; i < numMaxRectangulos; i++) {
                                                        System.out.println("Ingresa las coordenadas del" + (i + 1)
                                                                        + " rectangulo (x1 y1 x2 y2 separados por espacios): ");
                                                        String input1 = scanner.nextLine();
                                                        // Leer la línea de entrada como una cadena
                                                        String[] tokens1 = input1.split(" ");
                                                        // Dividir la cadena en tokens usando el espacio como
                                                        // delimitador
                                                        double x1 = Double.parseDouble(tokens1[0]);
                                                        // Convertir el primer token a double (x1)
                                                        double y1 = Double.parseDouble(tokens1[1]);
                                                        // Convertir el segundo token a double (y1)
                                                        double x2 = Double.parseDouble(tokens1[2]);
                                                        // Convertir el tercer token a double (x2)
                                                        double y2 = Double.parseDouble(tokens1[3]);
                                                        // Convertir el cuarto token a double (y2)

                                                        // Crear las coordenadas y el rectángulo
                                                        Coordenada esquina1 = new Coordenada(x1, y1);
                                                        Coordenada esquina2 = new Coordenada(x2, y2);
                                                        Rectangulo rectangulo = new Rectangulo(esquina1, esquina2);

                                                        // Agregar el rectángulo al contenedor
                                                        contenedor.agregarRectangulo(rectangulo);
                                                }
                                        } else {
                                                System.out.println(
                                                                "El contenedor está lleno, no se pueden agregar más rectángulos.");
                                        }
                                        break;
                                case 2:
                                        if (contenedor.getNumRec() >= 2) {
                                                System.out.println(
                                                                "Ingrese el número del primer rectángulo a comparar:");
                                                int indiceRectangulo1 = scanner.nextInt();
                                                scanner.nextLine(); // Consumir el carácter de nueva línea
                                                System.out.println(
                                                                "Ingrese el número del segundo rectángulo a comparar:");
                                                int indiceRectangulo2 = scanner.nextInt();
                                                scanner.nextLine(); // Consumir el carácter de nueva línea

                                                // Verificar que los índices estén dentro del rango
                                                if (indiceRectangulo1 >= 1
                                                                && indiceRectangulo1 <= contenedor.getNumRec() &&
                                                                indiceRectangulo2 >= 1
                                                                && indiceRectangulo2 <= contenedor.getNumRec()) {
                                                        // Obtener los rectángulos a comparar
                                                        Rectangulo rectangulo1 = contenedor
                                                                        .getRectangulos()[indiceRectangulo1 - 1];
                                                        Rectangulo rectangulo2 = contenedor
                                                                        .getRectangulos()[indiceRectangulo2 - 1];

                                                        // Realizar la comparación
                                                        System.out.println("Comparación entre el rectángulo "
                                                                        + indiceRectangulo1
                                                                        + " y el rectángulo " + indiceRectangulo2
                                                                        + ":");
                                                        System.out.println("¿Los rectángulos están sobre puestos? "
                                                                        + Verificador.esSobrePos(rectangulo1,
                                                                                        rectangulo2));
                                                        System.out.println(
                                                                        "¿Los rectángulos están juntos? " + Verificador
                                                                                        .esJunto(rectangulo1,
                                                                                                        rectangulo2));
                                                        System.out.println("¿Los rectángulos están disjuntos? "
                                                                        + Verificador.esDisjunto(rectangulo1,
                                                                                        rectangulo2));
                                                } else {
                                                        System.out.println(
                                                                        "Los números de rectángulo ingresados no son válidos.");
                                                }
                                        } else {
                                                System.out.println(
                                                                "No hay suficientes rectángulos almacenados para comparar.");
                                        }
                                        break;

                                case 3:
                                        // Mostrar las coordenadas de los rectángulos almacenados en el contenedor
                                        System.out.println("Rectángulos almacenados en el contenedor:");
                                        System.out.println(contenedor);
                                        break;
                                case 4:
                                        continuar = false;
                                        break;
                                default:
                                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                        }
                }

                scanner.close();
        }
}
