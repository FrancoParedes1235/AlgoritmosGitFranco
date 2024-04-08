public class Coordenada {
    private double x;
    private double y;

    // constructores
    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada() {
    }

    // metodo de instancia y metodo de clase
    double distancia(Coordenada c) {
        double distance;
        distance = Math.sqrt(Math.pow(c.getX() - this.x, 2) + Math.pow(c.getY() - this.y, 2));
        return distance;
    }

    // metodo estatico
    static double distancia(Coordenada c1, Coordenada c2) {
        double distance;
        distance = Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getY(), 2));
        return distance;
    }

    // getter setter
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // tostring
    @Override
    public String toString() {
        return "Coordenada [x=" + x + ", y=" + y + "]";
    }
}
