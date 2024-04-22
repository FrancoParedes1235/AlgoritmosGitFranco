import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangle extends JPanel {
    private int grado;

    public Triangle(int n) {
        this.grado = n;
        setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension tam = getSize();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, tam.width, tam.height);
        g2d.setColor(Color.BLUE);

        int x1 = 700, y1 = 700, x2 = 30, y2 = 700, x3 = 365, y3 = 120;
        trazaTriangulo(g2d, new Point(x1, y1), new Point(x2, y2), new Point(x3, y3), grado);
    }

    public static void trazaTriangulo(Graphics2D objGrafico, Point p1, Point p2, Point p3, int grado) {
        if (grado <= 0) {
            objGrafico.drawLine(p1.x, p1.y, p2.x, p2.y);
            objGrafico.drawLine(p2.x, p2.y, p3.x, p3.y);
            objGrafico.drawLine(p3.x, p3.y, p1.x, p1.y);
        } else {
            int dx1 = (p2.x + p1.x) / 2, dy1 = (p2.y + p1.y) / 2;
            int dx2 = (p3.x + p2.x) / 2, dy2 = (p3.y + p2.y) / 2;
            int dx3 = (p1.x + p3.x) / 2, dy3 = (p1.y + p3.y) / 2;

            trazaTriangulo(objGrafico, new Point(p1.x, p1.y), new Point(dx1, dy1), new Point(dx3, dy3), grado - 1);
            trazaTriangulo(objGrafico, new Point(p2.x, p2.y), new Point(dx2, dy2), new Point(dx1, dy1), grado - 1);
            trazaTriangulo(objGrafico, new Point(p3.x, p3.y), new Point(dx3, dy3), new Point(dx2, dy2), grado - 1);
        }
    }

    public static void uso() {
        System.err.println("Programa para trazar ...");
        System.err.println("Uso: Triangle <grado>");
        System.err.println("grado es un entero no negativo");
        System.err.println("Indica el nivel de construccion.");
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int niv = Integer.parseInt(args[0]);
                JFrame frame = new JFrame("Sierpinsky");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Triangle(niv));
                frame.pack();
                frame.setVisible(true);
            } catch (NumberFormatException e) {
                uso();
            }
        } else {
            uso();
        }
    }
}
