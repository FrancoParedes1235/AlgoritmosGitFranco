public class Main {
    public static void main(String[] args) {
        // Crear una cajonería para almacenar golosinas
        Cajoneria<Golosina> cajoneria = new Cajoneria<>(5);
        // Crear una cajonería para almacenar chocolatinas
        Cajoneria<Chocolatina> cajoneriaChocolatinas = new Cajoneria<>(5);

        // Agregar chocolatinas a la cajonería
        cajoneriaChocolatinas.add(new Chocolatina("Hershey's"), "rojo");
        cajoneriaChocolatinas.add(new Chocolatina("Milka"), "azul");
        cajoneriaChocolatinas.add(new Chocolatina("KitKat"), "verde");
        cajoneriaChocolatinas.add(new Chocolatina("Toblerone"), "amarillo");
        cajoneriaChocolatinas.add(new Chocolatina("Cadbury"), "rosa");

        // Verificar la existencia de algunas chocolatinas por su nombre
        String[] chocolatesABuscar = { "Milka", "Toblerone", "Ferrero" };
        for (String nombre : chocolatesABuscar) {
            Chocolatina chocolate = new Chocolatina(nombre);
            String resultado = cajoneriaChocolatinas.search(chocolate);
            System.out.println("Búsqueda de " + nombre + ": " + resultado);
        }

        // Prueba de la funcionalidad del método delete
        Chocolatina chocolatinaAEliminar = new Chocolatina("KitKat");
        Chocolatina chocolatinaEliminada = cajoneriaChocolatinas.delete(chocolatinaAEliminar);
        System.out.println("Chocolatina eliminada: " + chocolatinaEliminada.getNombre());

        // Imprimir la cajonería después de eliminar la chocolatina
        System.out.println("Cajonería después de eliminar:");
        System.out.println(cajoneria);

        // Agregar golosinas a la cajonería
        cajoneria.add(new Golosina("Chocolate"), "rojo");
        cajoneria.add(new Golosina("Caramelo"), "azul");
        cajoneria.add(new Golosina("Paleta"), "verde");
        cajoneria.add(new Golosina("Chicle"), "amarillo");
        cajoneria.add(new Golosina("Gomita"), "rosa");

        // Verificar la existencia de algunas golosinas por su nombre
        String[] golosinasABuscar = { "Chocolate", "Chicle", "Manzana" };
        for (String nombre : golosinasABuscar) {
            // Crear una golosina para la búsqueda
            Golosina golosina = new Golosina(nombre);

            // Buscar la golosina en la cajonería
            String resultado = cajoneria.search(golosina);

            // Imprimir el resultado de la búsqueda
            System.out.println("Búsqueda de " + nombre + ": " + resultado);
        }

        // Prueba de la funcionalidad del método delete
        Golosina golosinaAEliminar = new Golosina("Caramelo");
        Golosina golosinaEliminada = cajoneria.delete(golosinaAEliminar);
        System.out.println("Golosina eliminada: " + golosinaEliminada.getNombre());

        // Imprimir la cajonería después de eliminar la golosina
        System.out.println("Cajonería después de eliminar:");
        System.out.println(cajoneria);
    }
}