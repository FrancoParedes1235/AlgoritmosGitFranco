package Actividad3;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;
    protected int idNode;
    private static int nodeCounter = 0;
    protected boolean leaf;

    public BNode(int n) {
        this.keys = new ArrayList<>(n);
        this.childs = new ArrayList<>(n + 1); // Ajuste para n + 1 hijos
        this.count = 0;
        this.leaf = true; // Inicializar como hoja por defecto
        for (int i = 0; i < n; i++) {
            this.keys.add(null);
            this.childs.add(null);
        }
        this.childs.add(null); // Añadir un espacio adicional para el hijo extra
        this.idNode = nodeCounter++;
    }

    public boolean nodeFull(int maxKeys) {
        return this.count == maxKeys;
    }

    public boolean nodeEmpty() {
        return this.count == 0;
    }

    public boolean searchNode(E key, int[] pos) {
        pos[0] = 0;
        while (pos[0] < this.count && key.compareTo(this.keys.get(pos[0])) > 0) {
            pos[0]++;
        }
        return (pos[0] < this.count && key.compareTo(this.keys.get(pos[0])) == 0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Node ID: ").append(this.idNode).append(", Keys: ");
        for (int i = 0; i < this.count; i++) {
            sb.append(this.keys.get(i)).append(" ");
        }
        return sb.toString();
    }

    public void insertKey(E key) {
        if (this.count < this.keys.size()) {
            this.keys.set(this.count, key);
            this.count++;
        }
    }

    public int getIdNode() {
        return idNode;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<E> getKeys() {
        return keys;
    }

    public ArrayList<BNode<E>> getChilds() {
        return childs;
    }
}
