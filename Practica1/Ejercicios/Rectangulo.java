class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada c1, Coordenada c2) {
        setEsquina1(c1);
        setEsquina2(c2);
    }

    public void setEsquina1(Coordenada coo) {
        this.esquina1 = coo;
    }

    public void setEsquina2(Coordenada coo) {
        this.esquina2 = coo;
    }

    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    // Método para calcular el área del rectángulo
    public double calculoArea() {
        // Calcular la longitud de los lados del rectángulo usando el método distancia
        // de Coordenada
        double base = Coordenada.distancia(esquina1, new Coordenada(esquina2.getX(), esquina1.getY()));
        double altura = Coordenada.distancia(esquina1, new Coordenada(esquina1.getX(), esquina2.getY()));

        // Calcular el área multiplicando la base por la altura
        return base * altura;
    }

    // Método para calcular el área de la intersección entre dos rectángulos
    public Rectangulo rectanguloSobre(Rectangulo otroRectangulo) {
        // Calcular las coordenadas del rectángulo que representa la intersección
        double x1 = Math.max(this.getEsquina1().getX(), otroRectangulo.getEsquina1().getX());
        double y1 = Math.max(this.getEsquina1().getY(), otroRectangulo.getEsquina1().getY());
        double x2 = Math.min(this.getEsquina2().getX(), otroRectangulo.getEsquina2().getX());
        double y2 = Math.min(this.getEsquina2().getY(), otroRectangulo.getEsquina2().getY());

        // Verificar si hay intersección
        if (x1 < x2 && y1 < y2) {
            // Crear un nuevo objeto Rectangulo con las coordenadas de intersección
            Coordenada esquina1 = new Coordenada(x1, y1);
            Coordenada esquina2 = new Coordenada(x2, y2);
            return new Rectangulo(esquina1, esquina2);
        } else {
            // No hay intersección, devolver un rectángulo con área 0
            return new Rectangulo(new Coordenada(0, 0), new Coordenada(0, 0));
        }
    }

    @Override
    public String toString() {
        return "Rectangulo [esquina1=" + esquina1 + ", esquina2=" + esquina2 + "]";
    }
}