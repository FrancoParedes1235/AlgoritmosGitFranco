public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    public class NodeAVL extends Node {
        protected int bf; // Factor de equilibrio

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        public NodeAVL(E data, Node left, Node right) {
            super(data, left, right);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data.toString() + " (bf: " + bf + ")";
        }
    }

    @Override
    public void insert(E x) throws ItemDuplicated {
        root = insert((NodeAVL) root, x);
    }

    private NodeAVL insert(NodeAVL node, E x) throws ItemDuplicated {
        if (node == null) {
            return new NodeAVL(x);
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert((NodeAVL) node.left, x);
            if (node.left instanceof NodeAVL) {
                node.bf++;
            }
        } else if (cmp > 0) {
            node.right = insert((NodeAVL) node.right, x);
            if (node.right instanceof NodeAVL) {
                node.bf--;
            }
        } else {
            throw new ItemDuplicated("Item already exists in the AVL tree");
        }

        return balance(node);
    }

    // Implementación del constructor y otros métodos...

    @Override
    public void remove(E x) throws ItemNotFound {
        root = remove((NodeAVL) root, x);
    }

    private NodeAVL remove(NodeAVL node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Item not found in the AVL tree");
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove((NodeAVL) node.left, x);
        } else if (cmp > 0) {
            node.right = remove((NodeAVL) node.right, x);
        } else {
            // Nodo a eliminar encontrado
            if (node.left == null) {
                return (NodeAVL) node.right;
            } else if (node.right == null) {
                return (NodeAVL) node.left;
            } else {
                // Caso 3: nodo con dos hijos
                NodeAVL temp = (NodeAVL) minRemove(node.right);
                node.data = temp.data;
                node.right = remove((NodeAVL) node.right, temp.data);
            }
        }

        return balance(node);
    }

    @Override
    protected NodeAVL minRemove(Node node) {
        if (node.left == null) {
            return (NodeAVL) node;
        }
        return minRemove(node.left);
    }

    private NodeAVL balance(NodeAVL node) {
        if (node.bf == 2) {
            node = balanceToLeft(node);
        } else if (node.bf == -2) {
            node = balanceToRight(node);
        }
        return node;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        if (((NodeAVL) node.left).bf >= 0) {
            node = rotateSR(node);
        } else {
            node = rotateDR(node);
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        if (((NodeAVL) node.right).bf <= 0) {
            node = rotateSL(node);
        } else {
            node = rotateDL(node);
        }
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL leftChild = (NodeAVL) node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        node.bf = node.bf - 1 - Math.max(leftChild.bf, 0);
        leftChild.bf = leftChild.bf - 1 + Math.min(node.bf, 0);
        return leftChild;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL rightChild = (NodeAVL) node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        node.bf = node.bf + 1 - Math.min(rightChild.bf, 0);
        rightChild.bf = rightChild.bf + 1 + Math.max(node.bf, 0);
        return rightChild;
    }

    private NodeAVL rotateDR(NodeAVL node) {
        node.left = rotateSL((NodeAVL) node.left);
        return rotateSR(node);
    }

    private NodeAVL rotateDL(NodeAVL node) {
        node.right = rotateSR((NodeAVL) node.right);
        return rotateSL(node);
    }
}
