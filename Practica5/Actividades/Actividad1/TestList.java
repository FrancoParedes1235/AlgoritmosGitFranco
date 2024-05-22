import java.util.List;

public class TestList {
    public static void main(String[] args) throws Exception {
        TDAList<Integer> listInt = new ListArray(5);

        listInt.insertFirst(10);
        System.out.println(listInt);
        listInt.insertFirst(20);
        System.out.println(listInt);
        listInt.insertLast(40);
        System.out.println(listInt);
        listInt.insertFirst(30);
        System.out.println(listInt);
        listInt.insertLast(50);
        System.out.println(listInt);

        System.out.println("posion : " + listInt.search(40));
        System.out.println("posion : " + listInt.search(70));
        System.out.println("longitud : " + listInt.lenght());
        System.out.println("Es vacia? : " + listInt.isEmpty());

        listInt.destroyList();
        System.out.println("Longitud : " + listInt.lenght());
        System.out.println("Es vacia? : " + listInt.isEmpty());

        listInt.insertLast(156);
        System.out.println(listInt);
        System.out.println("longitud : " + listInt.lenght());
        System.out.println("Es vacia? : " + listInt.isEmpty());

        listInt.insertFirst(20);
        listInt.insertLast(40);
        listInt.insertFirst(30);
        listInt.insertLast(50);

        listInt.remove(349);
        System.out.println(listInt);
        System.out.println("longitud : " + listInt.lenght());
        System.out.println("ES vacia? : " + listInt.isEmpty());

        TDAList<Person> listPerson = new ListArray(5);
        Person p1 = new Person("Franco", "Paredes", 20);
        Person p2 = new Person("Salvador", "Zamora", 18);
        Person p3 = new Person("Juan", "Alzamora", 21);
        Person p4 = new Person("Luis", "Zanahoria", 22);
        Person p5 = new Person("Jose", "Pepe", 19);

        listPerson.insertFirst(p1);
        System.out.println(listPerson);
        listPerson.insertFirst(p2);
        System.out.println(listPerson);
        listPerson.insertLast(p3);
        System.out.println(listPerson);
        listPerson.insertFirst(p4);
        System.out.println(listPerson);
        listPerson.insertLast(p5);
        System.out.println(listPerson);

        System.out.println("posicion : " + listPerson.search(p2));
        System.out.println("posicion : " + listPerson.search(p4));
        System.out.println("longitud : " + listPerson.lenght());
        System.out.println("Es Vacia : " + listPerson.isEmpty());

        listPerson.destroyList();
        System.out.println("longitud : " + listPerson.lenght());
        System.out.println("Es vacia : " + listPerson.isEmpty());

        listPerson.insertLast(p4);
        System.out.println(listPerson);
        System.out.println("longitud : " + listPerson.lenght());
        System.out.println("Es Vacia : " + listPerson.isEmpty());

        listPerson.insertFirst(p1);
        listPerson.insertLast(p2);
        listPerson.insertFirst(p3);
        listPerson.insertLast(p5);

        listPerson.remove(p4);
        System.out.println(listPerson);
        System.out.println("longitud : " + listPerson.lenght());
        System.out.println("Es vacia? : " + listPerson.isEmpty());

    }
}
