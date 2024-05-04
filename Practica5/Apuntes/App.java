public class App {
    public static void main(String[] args) throws Exception {
        pila pila = new pila();
        pila.push("1");
        pila.push("2");
        pila.push("3");
        pila.push("4");
        pila.push("5");
        System.out.println(pila.pop());
        System.out.println(pila.empty());
        System.out.println(pila.pop());
        System.out.println(pila.empty());


    }
}
