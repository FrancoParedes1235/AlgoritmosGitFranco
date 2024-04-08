import java.util.Scanner;

public class App {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                // Coordenadas del primer rectángulo
                System.out.println(
                                "Ingresa las coordenadas del primer rectangulo (x1 y1 x2 y2 separados por espacios): ");
                String input1 = scanner.nextLine(); // Leer la línea de entrada como una cadena
                String[] tokens1 = input1.split(" "); // Dividir la cadena en tokens usando el espacio como delimitador
                double x1 = Double.parseDouble(tokens1[0]); // Convertir el primer token a double (x1)
                double y1 = Double.parseDouble(tokens1[1]); // Convertir el segundo token a double (y1)
                double x2 = Double.parseDouble(tokens1[2]); // Convertir el tercer token a double (x2)
                double y2 = Double.parseDouble(tokens1[3]); // Convertir el cuarto token a double (y2)

                // Coordenadas del segundo rectángulo
                System.out.println(
                                "Ingresa las coordenadas del segundo rectangulo (x3 y3 x4 y4 separados por espacios): ");
                String input2 = scanner.nextLine(); // Leer la línea de entrada como una cadena
                String[] tokens2 = input2.split(" "); // Dividir la cadena en tokens usando el espacio como delimitador
                double x3 = Double.parseDouble(tokens2[0]); // Convertir el primer token a double (x3)
                double y3 = Double.parseDouble(tokens2[1]); // Convertir el segundo token a double (y3)
                double x4 = Double.parseDouble(tokens2[2]); // Convertir el tercer token a double (x4)
                double y4 = Double.parseDouble(tokens2[3]); // Convertir el cuarto token a double (y4)

                // Crear instancias de Coordenada para las esquinas de ambos rectángulos
                Coordenada esquina1 = new Coordenada(x1, y1);
                Coordenada esquina2 = new Coordenada(x2, y2);
                Coordenada esquina3 = new Coordenada(x3, y3);
                Coordenada esquina4 = new Coordenada(x4, y4);

                // Crear instancias de Rectangulo
                Rectangulo rectangulo1 = new Rectangulo(esquina1, esquina2);
                Rectangulo rectangulo2 = new Rectangulo(esquina3, esquina4);

                // Mostrar las coordenadas de los rectángulos
                System.out.println("Coordenadas del primer rectangulo:");
                System.out.println(rectangulo1.toString());
                System.out.println("Coordenadas del segundo rectangulo:");
                System.out.println(rectangulo2.toString());

                // Verificar si los rectángulos están sobre puestos
                System.out.println("¿Los rectangulos están sobre puestos? " +
                                Verificador.esSobrePos(rectangulo1, rectangulo2));

                // Verificar si los rectángulos están juntos
                System.out.println("¿Los rectangulos están juntos? " +
                                Verificador.esJunto(rectangulo1, rectangulo2));

                // Verificar si los rectángulos están disjuntos
                System.out.println("¿Los rectangulos están disjuntos? " +
                                Verificador.esDisjunto(rectangulo1, rectangulo2));

                // Calcular y mostrar el área del rectángulo
                double area = rectangulo1.calculoArea();
                System.out.println("Área del rectangulo 1: " + area);
                double area2 = rectangulo2.calculoArea();
                System.out.println("Área del rectangulo 2: " + area2);

                // Calcular y mostrar el área de la sobreposición
                Rectangulo rectangulo3 = rectangulo1.rectanguloSobre(rectangulo2);
                System.out.println("Rectángulo que representa la intersección: " + rectangulo3.toString());
                double area3 = rectangulo3.calculoArea();
                System.out.println("Área del rectangulo sobrepuesto es: " + area3);

                scanner.close(); // Cerrar
        }
}
