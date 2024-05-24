package ejercicio4;

import ejercicio1.StackLink;
import actividad1.ExceptionIsEmpty;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            System.out.println(symbolBalancing("()()()[()]()"));
            System.out.println(symbolBalancing("((()))[]"));
            System.out.println(symbolBalancing("([])[]("));
            System.out.println(symbolBalancing("([{)]}"));
            System.out.println(symbolBalancing("["));
            System.out.println(symbolBalancing("[][][]{{{}}}"));
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static boolean symbolBalancing(String S) throws ExceptionIsEmpty, exeptions.ExceptionIsEmpty {
        StackLink<Character> stack = new StackLink<>();

        for (char c : S.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatchingPair(stack.top(), c)) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(Character character1, Character character2) {
        return (character1 == '(' && character2 == ')') ||
                (character1 == '[' && character2 == ']') ||
                (character1 == '{' && character2 == '}');
    }

}
