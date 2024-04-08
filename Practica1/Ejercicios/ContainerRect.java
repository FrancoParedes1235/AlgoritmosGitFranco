import java.util.ArrayList;
import java.util.Arrays;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int n;
    private static int numRec = 0; // Contador de rectángulos almacenados

    // Constructor
    public ContainerRect(int n) {// recibe el tamaño maximo de contenedor
        // inicializa los arreglos con el tamaño
        this.n = n;
        rectangulos = new Rectangulo[n];
        distancias = new double[n];
        areas = new double[n];
    }

    // Método para agregar un rectángulo al contenedor
    public void agregarRectangulo(Rectangulo rectangulo) {
        if (numRec < n) {
            rectangulos[numRec] = rectangulo;// se añade al contenedor
            distancias[numRec] = rectangulo.getEsquina1().distancia(rectangulo.getEsquina2()); // Utilizando el método
            // de distancia euclidiana de Coordenada
            areas[numRec] = rectangulo.calculoArea();
            numRec++;
        } else {
            System.out.println("El contenedor está lleno, no se pueden agregar más rectángulos.");
        }
    }

    // Getters
    public Rectangulo[] getRectangulos() {
        return rectangulos;
    }

    public double[] getDistancias() {
        return distancias;
    }

    public double[] getAreas() {
        return areas;
    }

    public int getNumRec() {
        return numRec;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectangulo\tCoordenadas\t\tDistancia\tArea\n");
        for (int i = 0; i < numRec; i++) {
            sb.append(i + 1).append("\t\t").append(rectangulos[i].toString()).append("\t");
            sb.append(String.format("%.3f", distancias[i])).append("\t");
            sb.append(String.format("%.2f", areas[i])).append("\n");
        }
        return sb.toString();
    }

}
