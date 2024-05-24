import java.util.List;

public class TestList {
    public static void main(String[] args) throws Exception {

        /*
         * //Actividades
         * TDAList<Integer> listInt = new ListArray(5);
         * 
         * listInt.insertFirst(10);
         * System.out.println(listInt);
         * listInt.insertFirst(20);
         * System.out.println(listInt);
         * listInt.insertLast(40);
         * System.out.println(listInt);
         * listInt.insertFirst(30);
         * System.out.println(listInt);
         * listInt.insertLast(50);
         * System.out.println(listInt);
         * 
         * System.out.println("posion : " + listInt.search(40));
         * System.out.println("posion : " + listInt.search(70));
         * System.out.println("longitud : " + listInt.lenght());
         * System.out.println("Es vacia? : " + listInt.isEmpty());
         * 
         * listInt.destroyList();
         * System.out.println("Longitud : " + listInt.lenght());
         * System.out.println("Es vacia? : " + listInt.isEmpty());
         * 
         * listInt.insertLast(156);
         * System.out.println(listInt);
         * System.out.println("longitud : " + listInt.lenght());
         * System.out.println("Es vacia? : " + listInt.isEmpty());
         * 
         * listInt.insertFirst(20);
         * listInt.insertLast(40);
         * listInt.insertFirst(30);
         * listInt.insertLast(50);
         * 
         * listInt.remove(349);
         * System.out.println(listInt);
         * System.out.println("longitud : " + listInt.lenght());
         * System.out.println("ES vacia? : " + listInt.isEmpty());
         * 
         * TDAList<Person> listPerson = new ListArray(5);
         * Person p1 = new Person("Franco", "Paredes", 20);
         * Person p2 = new Person("Salvador", "Zamora", 18);
         * Person p3 = new Person("Juan", "Alzamora", 21);
         * Person p4 = new Person("Luis", "Zanahoria", 22);
         * Person p5 = new Person("Jose", "Pepe", 19);
         * 
         * listPerson.insertFirst(p1);
         * System.out.println(listPerson);
         * listPerson.insertFirst(p2);
         * System.out.println(listPerson);
         * listPerson.insertLast(p3);
         * System.out.println(listPerson);
         * listPerson.insertFirst(p4);
         * System.out.println(listPerson);
         * listPerson.insertLast(p5);
         * System.out.println(listPerson);
         * 
         * System.out.println("posicion : " + listPerson.search(p2));
         * System.out.println("posicion : " + listPerson.search(p4));
         * System.out.println("longitud : " + listPerson.lenght());
         * System.out.println("Es Vacia : " + listPerson.isEmpty());
         * 
         * listPerson.destroyList();
         * System.out.println("longitud : " + listPerson.lenght());
         * System.out.println("Es vacia : " + listPerson.isEmpty());
         * 
         * listPerson.insertLast(p4);
         * System.out.println(listPerson);
         * System.out.println("longitud : " + listPerson.lenght());
         * System.out.println("Es Vacia : " + listPerson.isEmpty());
         * 
         * listPerson.insertFirst(p1);
         * listPerson.insertLast(p2);
         * listPerson.insertFirst(p3);
         * listPerson.insertLast(p5);
         * 
         * listPerson.remove(p4);
         * System.out.println(listPerson);
         * System.out.println("longitud : " + listPerson.lenght());
         * System.out.println("Es vacia? : " + listPerson.isEmpty());
         */

        // Ejercicio1

        /*
         * // crear instacia
         * LinkedList<String> list = new LinkedList<>();
         * list.insertLast("a");
         * list.insertLast("b");
         * list.insertLast("c");
         * list.insertLast("c");
         * 
         * // Imprimir la lista antes de eliminar duplicados
         * System.out.println("Lista antes de eliminar duplicados:");
         * System.out.println(list.toString());
         * 
         * // Llamar a deleteDuplicates() para eliminar duplicados
         * list1.deleteDuplicates();
         * 
         * // Imprimir la lista después de eliminar duplicados
         * System.out.println("Lista después de eliminar duplicados:");
         * System.out.println(list.toString());
         * // Crear una instancia de LinkedList
         * LinkedList<Integer> list2 = new LinkedList<>();
         * 
         * // Insertar elementos en la lista (incluyendo duplicados)
         * list2.insertLast(47);
         * list2.insertLast(89);
         * list2.insertLast(56);
         * list2.insertLast(89);
         * list2.insertLast(89);
         * list2.insertLast(56);
         * 
         * // Imprimir la lista antes de eliminar duplicados
         * System.out.println("Lista antes de eliminar duplicados:");
         * System.out.println(list2.toString());
         * 
         * // Llamar a deleteDuplicates() para eliminar duplicados
         * list2.deleteDuplicates();
         * 
         * // Imprimir la lista después de eliminar duplicados
         * System.out.println("Lista después de eliminar duplicados:");
         * System.out.println(list2.toString());
         * 
         * LinkedList<Integer> list3 = new LinkedList<>();
         * 
         * // Insertar elementos en la lista (incluyendo duplicados)
         * list3.insertLast(1);
         * list3.insertLast(2);
         * list3.insertLast(3);
         * list3.insertLast(4);
         * list3.insertLast(5);
         * list3.insertLast(6);
         * 
         * // Imprimir la lista antes de eliminar duplicados
         * System.out.println("Lista antes de eliminar duplicados:");
         * System.out.println(list3.toString());
         * 
         * // Llamar a deleteDuplicates() para eliminar duplicados
         * list3.deleteDuplicates();
         * 
         * // Imprimir la lista después de eliminar duplicados
         * System.out.println("Lista después de eliminar duplicados:");
         * System.out.println(list3.toString());
         * 
         * // crear instacia
         * LinkedList<String> list4 = new LinkedList<>();
         * list4.insertLast("Luis");
         * list4.insertLast("Rodrigo");
         * list4.insertLast("Luis");
         * 
         * // Imprimir la lista antes de eliminar duplicados
         * System.out.println("Lista antes de eliminar duplicados:");
         * System.out.println(list4.toString());
         * 
         * // Llamar a deleteDuplicates() para eliminar duplicados
         * list4.deleteDuplicates();
         * 
         * // Imprimir la lista después de eliminar duplicados
         * System.out.println("Lista después de eliminar duplicados:");
         * System.out.println(list4.toString());
         */

        // Ejercicio 2
        // Crear una instancia de LinkedList

        /*
         * LinkedList<String> list5 = new LinkedList<>();
         * 
         * // Insertar elementos en la lista
         * list5.insertLast("a");
         * list5.insertLast("b");
         * list5.insertLast("c");
         * 
         * // Imprimir la lista original
         * System.out.println("Lista original:");
         * System.out.println(list5.toString());
         * 
         * // Insertar un elemento en la posición 2
         * list5.insertNth("c", 3);
         * 
         * // Imprimir la lista después de insertar
         * System.out.println("Lista después de insertar en la posición :");
         * System.out.println(list5.toString());
         * 
         * // Intentar insertar un elemento en una posición fuera de rango
         * list5.insertNth("c", 10);
         * 
         * // Imprimir la lista después del intento de inserción fuera de rango
         * System.out.
         * println("Lista después del intento de insertar en una posición fuera de rango:"
         * );
         * System.out.println(list5.toString());
         * 
         * LinkedList<Integer> list6 = new LinkedList<>();
         * 
         * // Insertar elementos en la lista
         * list6.insertLast(10);
         * list6.insertLast(20);
         * list6.insertLast(30);
         * 
         * // Imprimir la lista original
         * System.out.println("Lista original:");
         * System.out.println(list6.toString());
         * 
         * // Insertar un elemento en la posición 2
         * list6.insertNth(5, 0);
         * 
         * // Imprimir la lista después de insertar
         * System.out.println("Lista después de insertar en la posición :");
         * System.out.println(list6.toString());
         */

        // Crear una instancia de LinkedList 7
        LinkedList<String> list7 = new LinkedList<>();

        // Insertar elementos en la lista
        list7.insertLast("a");
        list7.insertLast("b");
        list7.insertLast("d");

        // Imprimir la lista original
        System.out.println("Lista original:");
        System.out.println(list7.toString());

        // Eliminar el elemento en la posición
        list7.deleteNth(2);

        // Imprimir la lista después de eliminar el elemento
        System.out.println("Lista después de eliminar el elemento en la posición:");
        System.out.println(list7.toString());

        // Intentar eliminar un elemento en una posición fuera de rango
        list7.deleteNth(10);

        // Imprimir la lista después del intento de eliminación fuera de rango
        System.out.println("Lista después del intento de eliminar en una posición fuera de rango:");
        System.out.println(list7.toString());
        // Eliminar el elemento en la posición
        list7.deleteNth(0);

        // Imprimir la lista después de eliminar el elemento
        System.out.println("Lista después de eliminar el elemento en la posición:");
        System.out.println(list7.toString());

        // Crear una instancia de LinkedList 8
        LinkedList<Integer> list8 = new LinkedList<>();

        // Insertar elementos en la lista
        list8.insertLast(10);

        // Imprimir la lista original
        System.out.println("Lista original:");
        System.out.println(list8.toString());

        // Eliminar el elemento en la posición
        list8.deleteNth(0);

        // Imprimir la lista después de eliminar el elemento
        System.out.println("Lista después de eliminar el elemento en la posición:");
        System.out.println(list8.toString());

    }
}
