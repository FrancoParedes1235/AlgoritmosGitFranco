public class Verificador {
    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        // Verifica si los rectángulos están sobrepuestos comparando las coordenadas de
        // las esquinas
        boolean SobreX = (r1.getEsquina1().getX() < r2.getEsquina2().getX()) &&
                (r1.getEsquina2().getX() > r2.getEsquina1().getX());
        boolean SobreY = (r1.getEsquina1().getY() < r2.getEsquina2().getY()) &&
                (r1.getEsquina2().getY() > r2.getEsquina1().getY());
        return SobreX && SobreY;
    }

    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        // Verifica si los rectángulos están juntos, si comparten un lado
        boolean JuntosX = (r1.getEsquina1().getX() == r2.getEsquina2().getX()) ||

                (r1.getEsquina2().getX() == r2.getEsquina1().getX());
        boolean JuntosY = (r1.getEsquina1().getY() == r2.getEsquina2().getY()) ||
                (r1.getEsquina2().getY() == r2.getEsquina1().getY());
        return JuntosX || JuntosY;
    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        // Verifica si los rectángulos están disjuntos por si no
        // están sobrepuestos ni juntos, entonces están disjuntos
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}