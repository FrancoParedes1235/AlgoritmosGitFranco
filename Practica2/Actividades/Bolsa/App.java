public class App {
    public static void main(String[] args) {
        // Crear una bolsa de chocolatinas con una capacidad máxima de 4 elementos
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(4);

        // Crear algunas chocolatinas
        Chocolatina c = new Chocolatina("milka");
        Chocolatina c1 = new Chocolatina("milka");
        Chocolatina c2 = new Chocolatina("ferrero");

        // Agregar las chocolatinas a la bolsa
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        // Iterar sobre la bolsa de chocolatinas e imprimir las marcas de las
        // chocolatinas
        System.out.println("Chocolatinas en la bolsa:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        // Crear una bolsa de golosinas con una capacidad máxima de 4 elementos
        Bolsa<Golosina> bolsaGol = new Bolsa<Golosina>(4);

        // Crear algunas golosinas
        Golosina g = new Golosina("paleta");
        Golosina g1 = new Golosina("chicle");
        Golosina g2 = new Golosina("caramelo");

        // Agregar las golosinas a la bolsa
        bolsaGol.add(g);
        bolsaGol.add(g1);
        bolsaGol.add(g2);

        // Iterar sobre la bolsa de golosinas e imprimir las marcas de las golosinas
        System.out.println("\nGolosinas en la bolsa:");
        for (Golosina golosina : bolsaGol) {
            System.out.println(golosina.getNombre());
        }
    }
}
