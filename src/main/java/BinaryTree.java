public class BinaryTree {

    // Root node
    private Node root;

    public BinaryTree() {
        root = null;
    }

    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }

    /**
     * Return true if data is in the tree
     */
    public boolean lookup(int data) {
        return lookup(root, data);
    }

    /**
     * Recursive lookup
     */
    private boolean lookup(Node node, int data) {
        // Root node is null so tree is empty
        if(node == null)
            return false;

        if(data == node.data)
            return true;

        else if(data < node.data)
            return lookup(node.left, data);

        else
            return lookup(node.right, data);
    }

    /**
     * Insert data into the tree
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Recursive insert
     */
    private Node insert(Node node, int data) {
        // If root is null then tree is empty
        if(node == null)
            node = new Node(data);

        else {
            if(data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }

        return node;
    }

    /**
     * Get the amount of nodes in the tree
     */
    public int size() {
        return size(root);
    }

    /**
     * Recursive size
     */
    private int size(Node node) {
        if(node == null)
            return 0;
        else
            return size(node.left) + 1 + size(node.right);
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    private int maxDepth(Node node) {
        if(node == null)
            return 0;
        else {
            int leftDepth = maxDepth(node.left);
            int rightDepth = maxDepth(node.right);

            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    public int minValue() {
        return minValue(root);
    }

    private int minValue(Node node) {
        if(node.left == null)
            return node.data;
        else
            return minValue(node.left);
    }

    public int maxValue() {
        return maxValue(root);
    }

    private int maxValue(Node node) {
        if(node.right == null)
            return node.data;
        else
            return maxValue(node.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(5);
        binaryTree.insert(8);
        binaryTree.insert(9);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(1);
        System.out.println(binaryTree.maxValue());
    }
}