package Actividad3;

import Excepciones.*;

public class BTree<E extends Comparable<E>> {
    private BNode<E> root;
    private int orden;
    private boolean up;
    private BNode<E> nDes;

    public BTree(int orden) {
        this.orden = orden;
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E cl) {
        up = false;
        E mediana;
        BNode<E> pnew;
        mediana = push(this.root, cl);
        if (up) {
            pnew = new BNode<>(this.orden);
            pnew.count = 1;
            pnew.keys.set(0, mediana);
            pnew.childs.set(0, this.root);
            pnew.childs.set(1, nDes);
            this.root = pnew;
        }
    }

    private E push(BNode<E> current, E cl) {
        int[] pos = new int[1];
        E mediana;
        if (current == null) {
            up = true;
            nDes = null;
            return cl;
        } else {
            boolean fl;
            fl = current.searchNode(cl, pos);
            if (fl) {
                System.out.println("Item duplicado\n");
                up = false;
                return null;
            }
            mediana = push(current.childs.get(pos[0]), cl);
            if (up) {
                if (current.nodeFull(this.orden - 1))
                    mediana = dividedNode(current, mediana, pos[0]);
                else {
                    up = false;
                    putNode(current, mediana, nDes, pos[0]);
                }
            }
            return mediana;
        }
    }

    private void putNode(BNode<E> current, E cl, BNode<E> rd, int k) {
        int i;
        for (i = current.count - 1; i >= k; i--) {
            current.keys.set(i + 1, current.keys.get(i));
            current.childs.set(i + 2, current.childs.get(i + 1));
        }
        current.keys.set(k, cl);
        current.childs.set(k + 1, rd);
        current.count++;
    }

    private E dividedNode(BNode<E> current, E cl, int k) {
        BNode<E> rd = nDes;
        int i, posMdna;
        posMdna = (k <= this.orden / 2) ? this.orden / 2 : this.orden / 2 + 1;
        nDes = new BNode<>(this.orden);
        for (i = posMdna; i < this.orden - 1; i++) {
            nDes.keys.set(i - posMdna, current.keys.get(i));
            nDes.childs.set(i - posMdna + 1, current.childs.get(i + 1));
        }
        nDes.count = (this.orden - 1) - posMdna;
        current.count = posMdna;
        if (k <= this.orden / 2)
            putNode(current, cl, rd, k);
        else
            putNode(nDes, cl, rd, k - posMdna);
        E median = current.keys.get(current.count - 1);
        nDes.childs.set(0, current.childs.get(current.count));
        current.count--;
        return median;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (isEmpty()) {
            s.append("BTree is empty...");
        } else {
            s.append(writeTree(this.root, "", null));
        }
        return s.toString();
    }

    private String writeTree(BNode<E> current, String prefix, BNode<E> parent) {
        StringBuilder sb = new StringBuilder();
        if (current != null) {
            for (int i = 0; i < current.count; i++) {
                if (current.childs.get(i) != null) {
                    sb.append(writeTree(current.childs.get(i), prefix + "  ", current));
                }
            }
            if (current.childs.get(current.count) != null) {
                sb.append(writeTree(current.childs.get(current.count), prefix + "  ", current));
            }
            sb.append(prefix)
                    .append("Node ID: ").append(current.idNode).append("\n")
                    .append(prefix)
                    .append("Keys: ").append(current.keys.subList(0, current.count)).append("\n")
                    .append(prefix)
                    .append("Parent ID: ").append(parent == null ? "--" : parent.idNode).append("\n")
                    .append(prefix)
                    .append("Children IDs: ");
            for (int i = 0; i <= current.count; i++) {
                if (current.childs.get(i) != null) {
                    sb.append(current.childs.get(i).idNode).append(" ");
                }
            }
            sb.append("\n\n");
        }
        return sb.toString();
    }

    public String printVisualTree() {
        try {
            if (this.root == null) {
                throw new ItemNotFound("El árbol está vacío.");
            }
            StringBuilder sb = new StringBuilder();
            printVisualTree(this.root, sb, 0, "");
            return sb.toString();
        } catch (ItemNotFound e) {
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }

    private void printVisualTree(BNode<E> node, StringBuilder sb, int depth, String prefix) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Nodo no encontrado.");
        }
        if (depth == 0) {
            sb.append(prefix).append(node.keys.subList(0, node.count)).append("\n");
        } else {
            sb.append(" ".repeat(depth * 4)).append(prefix).append(node.keys.subList(0, node.count)).append("\n");
        }
        for (int i = 0; i <= node.count; i++) {
            if (node.childs.get(i) != null) {
                if (i < node.count) {
                    printVisualTree(node.childs.get(i), sb, depth + 1, " /");
                } else {
                    printVisualTree(node.childs.get(i), sb, depth + 1, " \\");
                }
            }
        }
    }

    // Método para buscar una clave en el árbol B
    public boolean search(E cl) {
        return search(this.root, cl);
    }

    // Método de soporte recursivo para buscar una clave en el árbol B
    private boolean search(BNode<E> current, E cl) {
        if (current == null) {
            return false;
        }
        int[] pos = new int[1];
        if (current.searchNode(cl, pos)) {
            System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posición " + pos[0]);
            return true;
        } else {
            return search(current.childs.get(pos[0]), cl);
        }
    }

    // Método para eliminar una clave del árbol B
    public void remove(E cl) {
        if (search(cl)) {
            remove(this.root, cl);
            if (this.root != null && this.root.count == 0) {
                this.root = this.root.childs.get(0); // Eliminar el nodo raíz si está vacío
            }
        } else {
            System.out.println("La clave " + cl + " no se encuentra en el árbol.");
        }
    }

    private void remove(BNode<E> current, E cl) {
        if (current == null) {
            return;
        }
        int[] pos = new int[1];
        if (current.searchNode(cl, pos)) {
            // La clave está en el nodo actual
            if (current.childs.get(pos[0]) == null) {
                // Eliminar la clave del nodo hoja
                removeFromLeaf(current, pos[0]);
            } else {
                // La clave está en un nodo interno
                removeFromNonLeaf(current, pos[0]);
            }
        } else {
            // La clave no está en el nodo actual
            if (current.leaf) {
                System.out.println("La clave " + cl + " no se encuentra en el árbol.");
                return;
            }

            // El flag indica si la clave está presente en el subárbol final del nodo
            boolean flag = (pos[0] == current.count);

            // Si el hijo donde debe estar la clave tiene menos de t claves, llenarlo
            if (current.childs.get(pos[0]).count < (orden / 2)) {
                fill(current, pos[0]);
            }

            // Si la última clave se fusionó, recurrir en el hijo anterior
            if (flag && pos[0] >= current.count) {
                remove(current.childs.get(pos[0] - 1), cl);
            } else {
                remove(current.childs.get(pos[0]), cl);
            }
        }
    }

    private void removeFromLeaf(BNode<E> node, int idx) {
        for (int i = idx + 1; i < node.count; i++) {
            node.keys.set(i - 1, node.keys.get(i));
        }
        node.count--;
    }

    private void removeFromNonLeaf(BNode<E> node, int idx) {
        E k = node.keys.get(idx);

        // Si el hijo anterior tiene al menos t claves, encontrar el predecesor
        if (node.childs.get(idx).count >= (orden / 2)) {
            E pred = getPredecessor(node, idx);
            node.keys.set(idx, pred);
            remove(node.childs.get(idx), pred);
        }
        // Si el hijo siguiente tiene al menos t claves, encontrar el sucesor
        else if (node.childs.get(idx + 1).count >= (orden / 2)) {
            E succ = getSuccessor(node, idx);
            node.keys.set(idx, succ);
            remove(node.childs.get(idx + 1), succ);
        }
        // Fusionar los hijos
        else {
            merge(node, idx);
            remove(node.childs.get(idx), k);
        }
    }

    private E getPredecessor(BNode<E> node, int idx) {
        BNode<E> current = node.childs.get(idx);
        while (!current.leaf) {
            current = current.childs.get(current.count);
        }
        return current.keys.get(current.count - 1);
    }

    private E getSuccessor(BNode<E> node, int idx) {
        BNode<E> current = node.childs.get(idx + 1);
        while (!current.leaf) {
            current = current.childs.get(0);
        }
        return current.keys.get(0);
    }

    private void fill(BNode<E> node, int idx) {
        if (idx != 0 && node.childs.get(idx - 1).count >= (orden / 2)) {
            borrowFromPrev(node, idx);
        } else if (idx != node.count && node.childs.get(idx + 1).count >= (orden / 2)) {
            borrowFromNext(node, idx);
        } else {
            if (idx != node.count) {
                merge(node, idx);
            } else {
                merge(node, idx - 1);
            }
        }
    }

    private void borrowFromPrev(BNode<E> node, int idx) {
        BNode<E> child = node.childs.get(idx);
        BNode<E> sibling = node.childs.get(idx - 1);

        for (int i = child.count - 1; i >= 0; i--) {
            child.keys.set(i + 1, child.keys.get(i));
        }

        if (!child.leaf) {
            for (int i = child.count; i >= 0; i--) {
                child.childs.set(i + 1, child.childs.get(i));
            }
        }

        child.keys.set(0, node.keys.get(idx - 1));
        if (!child.leaf) {
            child.childs.set(0, sibling.childs.get(sibling.count));
        }

        node.keys.set(idx - 1, sibling.keys.get(sibling.count - 1));
        sibling.count--;
        child.count++;
    }

    private void borrowFromNext(BNode<E> node, int idx) {
        BNode<E> child = node.childs.get(idx);
        BNode<E> sibling = node.childs.get(idx + 1);

        child.keys.set(child.count, node.keys.get(idx));

        if (!child.leaf) {
            child.childs.set(child.count + 1, sibling.childs.get(0));
        }

        node.keys.set(idx, sibling.keys.get(0));

        for (int i = 1; i < sibling.count; i++) {
            sibling.keys.set(i - 1, sibling.keys.get(i));
        }

        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.count; i++) {
                sibling.childs.set(i - 1, sibling.childs.get(i));
            }
        }

        sibling.count--;
        child.count++;
    }

    private void merge(BNode<E> node, int idx) {
        BNode<E> child = node.childs.get(idx);
        BNode<E> sibling = node.childs.get(idx + 1);

        child.keys.set((orden / 2) - 1, node.keys.get(idx));

        for (int i = 0; i < sibling.count; i++) {
            child.keys.set(i + (orden / 2), sibling.keys.get(i));
        }

        if (!child.leaf) {
            for (int i = 0; i <= sibling.count; i++) {
                child.childs.set(i + (orden / 2), sibling.childs.get(i));
            }
        }

        for (int i = idx + 1; i < node.count; i++) {
            node.keys.set(i - 1, node.keys.get(i));
        }

        for (int i = idx + 2; i <= node.count; i++) {
            node.childs.set(i - 1, node.childs.get(i));
        }

        child.count += sibling.count + 1;
        node.count--;
    }

}
