public interface TDAList<E> {
    boolean isEmpty();

    int lenght();

    void destroyList();

    int search(E x);

    void insertFirst(E x);

    void insertLast(E x);

    void remove(E x);
}
