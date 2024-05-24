package ejercicio3;

import ejercicio1.StackLink;
import actividad1.ExceptionIsEmpty;

public class ProblemaCorchetes {

    public static boolean estaBalanceado(String S) throws exeptions.ExceptionIsEmpty, ExceptionIsEmpty {
        StackLink<Character> pila = new StackLink<>();

        for (char c : S.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                // Si encontramos un corchete de apertura, lo agregamos a la pila
                pila.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                // Si encontramos un corchete de cierre
                if (pila.isEmpty()) {
                    return false; // Si la pila está vacía y encontramos un corchete de cierre, está desbalanceado
                }
                char top = 0;
                top = pila.top(); // Obtenemos el corchete de apertura correspondiente sin eliminarlo
                // Verificamos si los corchetes coinciden
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // Si no coinciden, está desbalanceado
                }
                pila.pop();
            }
        }

        return pila.isEmpty(); // Si la pila está vacía al final, los corchetes están balanceados
    }

    public static void main(String[] args) throws exeptions.ExceptionIsEmpty, ExceptionIsEmpty {
        String[] casosPrueba = {
                "()()()[()]()",
                "((()))[]",
                "([])[](",
                "([{)]}",
                "[",
                "[][][]{{{}}}"
        };

        for (String caso : casosPrueba) {
            System.out.println("Cadena: " + caso + ", ¿Está balanceada?: " + estaBalanceado(caso));
        }
    }
}
