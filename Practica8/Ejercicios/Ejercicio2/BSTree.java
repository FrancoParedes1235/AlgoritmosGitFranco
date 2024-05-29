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

        @Override
        public String toString() {
            return data.toString();
        }
    }

    protected Node root;

    public BSTree() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

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
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node temp = minRemove(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }
        return node;
    }

    protected Node minRemove(Node node) {
        if (node.left == null) {
            return node;
        }
        return minRemove(node.left);
    }

    public E findMin() throws ItemNotFound {
        if (isEmpty()) {
            throw new ItemNotFound("The BST is empty");
        }
        return minRemove(root).data;
    }

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

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int countLeafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    public int area() {
        int height = height(root);
        int leafNodes = countLeafNodes(root);
        return height * leafNodes;
    }

    public int height() {
        return height(root);
    }

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
