import java.util.Stack;

public class BSTree<E extends Comparable<E>> implements LinkBST<E> {
    public class Node {
        protected E data;
        protected Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;

    public BSTree() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    // Método que inserta un elemento en el BST
    // Si el elemento ya existe en el árbol, levanta la excepción ItemDuplicated
    @Override
    public void insert(E x) throws ItemDuplicated {
        root = insert(root, x);
    }

    private Node insert(Node node, E x) throws ItemDuplicated {
        if (node == null) {
            return new Node(x);
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, x);
        } else if (cmp > 0) {
            node.right = insert(node.right, x);
        } else {
            throw new ItemDuplicated("Item already exists in the BST");
        }
        return node;
    }

    // Método que busca un elemento y retorna su información
    // Si no existe, se levanta la excepción ItemNotFound
    @Override
    public E search(E x) throws ItemNotFound {
        return search(root, x);
    }

    private E search(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Item not found in the BST");
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            return search(node.left, x);
        } else if (cmp > 0) {
            return search(node.right, x);
        } else {
            return node.data;
        }
    }

    // Método que elimina un elemento del BST
    @Override
    public void remove(E x) throws ItemNotFound {
        root = remove(root, x);
    }

    private Node remove(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Item not found in the BST");
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, x);
        } else if (cmp > 0) {
            node.right = remove(node.right, x);
        } else {
            // Nodo a eliminar encontrado
            if (node.left == null) {
                return node.right; // Caso 1: nodo con solo hijo derecho o sin hijos
            } else if (node.right == null) {
                return node.left; // Caso 2: nodo con solo hijo izquierdo
            } else {
                // Caso 3: nodo con dos hijos
                Node temp = minRemove(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }
        return node;
    }

    // Método que encuentra y retorna el nodo con el valor mínimo
    private Node minRemove(Node node) {
        if (node.left == null) {
            return node;
        }
        return minRemove(node.left);
    }

    // Método público que retorna el valor mínimo del árbol
    public E findMin() throws ItemNotFound {
        if (isEmpty()) {
            throw new ItemNotFound("The BST is empty");
        }
        return minRemove(root).data;
    }

    // Retorna la cadena que tiene toda la información del BST
    // Utiliza alguno de los recorridos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.toString();
    }

    private void toString(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        toString(node.left, sb);
        sb.append(node.data).append(" ");
        toString(node.right, sb);
    }

    // Método que cuenta los nodos no-hojas
    @Override
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Método que retorna la altura de un nodo específico
    @Override
    public int height(E x) throws ItemNotFound {
        Node node = findNode(root, x);
        if (node == null) {
            throw new ItemNotFound("Item not found in the BST");
        }
        return height(node);
    }

    private Node findNode(Node node, E x) {
        if (node == null) {
            return null;
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            return findNode(node.left, x);
        } else if (cmp > 0) {
            return findNode(node.right, x);
        } else {
            return node;
        }
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Método que cuenta los nodos hoja
    private int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // Método que calcula el área del árbol
    public int area() {
        int height = height(root);
        int leafNodes = countLeafNodes(root);
        return height * leafNodes;
    }

    // lista de libreria para guardar en preorden
    public void iterativePreOrden() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    // Metodo recursivo para los nodos
    public int countNodesRecursive() {
        return countNodesRecursive(root);
    }

    private int countNodesRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRecursive(node.left) + countNodesRecursive(node.right);
    }

}
