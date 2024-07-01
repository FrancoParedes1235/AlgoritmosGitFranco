import java.util.ArrayList;

public class HashC<E extends Comparable<E>> {

    protected class Element {
        int mark; // 0 = empty, 1 = occupied, -1 = deleted
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<Element> table;
    protected int m;
    private int hashMethod; // 0 = modulo, 1 = square, 2 = fold

    public HashC(int n, int method) {
        this.m = n; // calcular el primo cercano a n y asignarlo a m
        this.hashMethod = method;
        this.table = new ArrayList<Element>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new Element(0, null));
        }
    }

    private int hash(int key) {
        switch (hashMethod) {
            case 1:
                return squareMethod(key);
            case 2:
                return foldMethod(key);
            default:
                return functionHash(key);
        }
    }

    private int functionHash(int key) {
        return key % m;
    }

    private int squareMethod(int key) {
        long squaredKey = (long) key * key;
        String keyStr = String.valueOf(squaredKey);
        int mid = keyStr.length() / 2;
        int digits = (int) Math.log10(m) + 1;
        int start = Math.max(0, mid - digits / 2);
        int end = Math.min(keyStr.length(), start + digits);
        int squareHash = Integer.parseInt(keyStr.substring(start, end));
        return squareHash % m;
    }

    private int foldMethod(int key) {
        String keyStr = String.valueOf(key);
        int sum = 0;
        int partLength = 3;
        for (int i = 0; i < keyStr.length(); i += partLength) {
            int end = Math.min(keyStr.length(), i + partLength);
            sum += Integer.parseInt(keyStr.substring(i, end));
        }
        return sum % m;
    }

    private int linearProbing(int dressHash, int key) {
        int i = 0;
        while (table.get((dressHash + i) % m).mark == 1 && table.get((dressHash + i) % m).reg.getKey() != key) {
            i++;
        }
        return (dressHash + i) % m;
    }

    public void insert(int key, E reg) {
        int hash = hash(key); // Usa el método de hash elegido
        int pos = linearProbing(hash, key);
        table.set(pos, new Element(1, new Register<E>(key, reg)));
    }

    // Metodo de busqueda unificado, sin importar el hash que usa
    public E search(int key) {
        int hash = hash(key); // Usa el mismo método de hash
        int i = 0;
        while (table.get((hash + i) % m).mark != 0) {
            if (table.get((hash + i) % m).mark == 1 && table.get((hash + i) % m).reg.getKey() == key) {
                return table.get((hash + i) % m).reg.value;
            }
            i++;
        }
        return null;
    }

    public String toString() {
        String s = "D.Real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {
            s += (i++) + " -->\t";
            if (item.mark == 1) {
                s += hash(item.reg.getKey()) + "\t" + item.reg + "\n";
            } else {
                s += "empty\n";
            }
        }
        return s;
    }
}
