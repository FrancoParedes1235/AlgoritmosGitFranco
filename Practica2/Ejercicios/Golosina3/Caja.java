public class Caja<T> {
    private T dato;
    private String color; // Nuevo atributo para almacenar el color de la caja

    // Constructor que asigna el color al crear una nueva caja
    public Caja(String color) {
        super();
        this.color = color;
    }

    public T dame() {
        return this.dato;
    }

    public void pon(T x) {
        this.dato = x;
    }

    // Método para obtener el color de la caja
    public String getColor() {
        return color;
    }

    // Método para establecer el color de la caja
    public void setColor(String color) {
        this.color = color;
    }
}