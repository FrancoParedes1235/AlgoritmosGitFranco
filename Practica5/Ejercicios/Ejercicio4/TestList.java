public class TestList {
    public static void main(String[] args) {

        // Prueba con enteros
        OrderListLinked<Integer> orderListInt = new OrderListLinked<>();
        orderListInt.insert(10);
        System.out.println(orderListInt);
        orderListInt.insert(20);
        System.out.println(orderListInt);
        orderListInt.insert(5);
        System.out.println(orderListInt);
        orderListInt.insert(30);
        System.out.println(orderListInt);

        orderListInt.remove(20);
        System.out.println(orderListInt);
        System.out.println("Posición de 30: " + orderListInt.search(30));
        System.out.println("Longitud: " + orderListInt.length());
        System.out.println("Es vacía? " + orderListInt.isEmpty());

        // Prueba con personas
        OrderListLinked<Person> orderListPerson = new OrderListLinked<>();
        Person p1 = new Person("Franco", "Paredes", 20);
        Person p2 = new Person("Salvador", "Zamora", 18);
        Person p3 = new Person("Juan", "Alzamora", 21);
        Person p4 = new Person("Luis", "Zanahoria", 22);
        Person p5 = new Person("Jose", "Pepe", 19);

        orderListPerson.insert(p1);
        System.out.println(orderListPerson);
        orderListPerson.insert(p2);
        System.out.println(orderListPerson);
        orderListPerson.insert(p3);
        System.out.println(orderListPerson);
        orderListPerson.insert(p4);
        System.out.println(orderListPerson);
        orderListPerson.insert(p5);
        System.out.println(orderListPerson);

        orderListPerson.remove(p3);
        System.out.println(orderListPerson);
        System.out.println("Posición de Salvador Zamora: " + orderListPerson.search(p2));
        System.out.println("Longitud: " + orderListPerson.length());
        System.out.println("Es vacía? " + orderListPerson.isEmpty());
    }
}
