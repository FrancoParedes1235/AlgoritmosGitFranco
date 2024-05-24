public class ListArray<E> implements TDAList<E> {
    private E array[];
    private int n;
    private int idx;

    public ListArray(int n) {
        this.n = n;
        this.idx = 0;
        this.array = (E[]) new Object[n];
    }

    public boolean isEmpty() {
        return this.idx == 0;
    }

    public int lenght() {
        return this.idx;
    }

    public void destroyList() {
        this.idx = 0;
    }

    public int search(E x) {
        for (int i = 0; i < this.idx; i++) {
            if (this.array[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public void insertFirst(E x) {
        if (this.idx >= n) {
            System.out.println("No hay espacio");
        } else {
            for (int i = 0; i < idx; i++) {
                this.array[idx - i] = this.array[idx - i - 1];
            }
        }
        this.array[0] = x;
        this.idx++;
    }

    public void insertLast(E x) {
        if (this.idx >= n) {
            System.out.println("No hay espacio");
        } else {
            this.array[idx] = x;
        }
        this.idx++;
    }

    public void remove(E x) {
        for (int i = 0; i < idx; i++) {
            if (this.array[i].equals(x)) {
                this.idx--;
                for (int j = i; j < idx; j++) {
                    this.array[j] = this.array[j + 1];
                }
                break;
            }
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < n; i++) {
            str += this.array[i] + ", ";
        }
        return str;
    }
}
