package Lab_6.j;

/**
 * Self balancing, height of left subtree cannot be +- 1 compared to right
 * subtree for all nodes.
 * 
 * Most BST operations have O(h) runtime, which approaches O(n) as the tree
 * becomes more unbalanced.
 */
public class AVLTree {
    private static final boolean RIGHT = true;
    private static final boolean LEFT = false;

    public class Node {
        int data, height;
        Node left, right, up;

        Node(int value, Node parent) {
            data = value;
            height = 1;
            up = parent;
        }

        public String toString() {
            String l_string = (left != null ? left.toString() : "");
            String r_string = (right != null ? right.toString() : "");
            return data + " " + l_string + r_string;
        }

        public void updateHeight() {
            height = 1 + max(height(left), height(right));
        }
    }

    Node root;

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static int height(Node n) {
        return n == null ? 0 : n.height;
    }

    private static void updateHeightFrom(Node w) {
        while (w != null) {
            w.updateHeight();
            w = w.up;
        }
    }

    private static boolean isUnbalanced(Node n) {
        return (height(n.left) - height(n.right)) / 2 != 0;
    }

    private void rebalance(Node w) {
        Node x = null, y = null, z = w;
        while (!isUnbalanced(z)) {
            if (z.up == null)
                return;
            x = y;
            y = z;
            z = z.up;
        }

        if (z.data > y.data) { // Left-
            if (y.data < x.data) // -Right
                rotateLeft(y);
            rotateRight(z); // -Left
        } else { // Right-
            if (y.data > x.data) // -Left
                rotateRight(y);
            rotateLeft(z); // -Right
        }
    }

    private void rotateLeft(Node x) {
        rotate(x, LEFT);
    }

    private void rotateRight(Node x) {
        rotate(x, RIGHT);
    }

    private void rotate(Node x, boolean direction) {
        Node y = direction ? x.left : x.right;
        y.up = x.up;
        x.up = y;
        if (direction) {
            x.left = y.right;
            y.right = x;
        } else {
            x.right = y.left;
            y.left = x;
        }
        x.updateHeight();
        y.updateHeight();
        updateChild(x, y);
    }

    private void updateChild(Node orig, Node rebalanced) {
        if (rebalanced.up != null) {
            if (rebalanced.up.left == orig)
                rebalanced.up.left = rebalanced;
            else
                rebalanced.up.right = rebalanced;
        } else {
            root = rebalanced;
        }
    }

    // private void updateRoot() {
    // while (root.up != null) {
    // root = root.up;
    // }
    // }

    private Node bst_insert(Node node, int value) {
        // normal insert
        if (node == null) {
            return root = new Node(value, null);
        }
        while (true) {
            if (value < node.data) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    return node.left = new Node(value, node);
                }
            } else if (value > node.data) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    return node.right = new Node(value, node);
                }
            } else {
                return null;
            }
        }
    }

    public void insert(int value) {
        Node w = bst_insert(root, value);
        updateHeightFrom(w);
        rebalance(w);
    }

    /**
     * Preorder Representation
     */
    public String toString() {
        return root.toString().substring(0, root.toString().length() - 1);
    }

    public void print() {
        System.out.print((root.left != null || root.right != null) ? "┬" : "─");
        tree_draw(root, "");
    }

    private void draw_branch(Node head, String lpad, boolean end) {
        System.out.print(lpad + (end ? "└" : "├") /* + "─" */);
        if (head == null) {
            System.out.println("─");
        } else if (head.right == null && head.left == null) {
            int value = head.data;
            System.out.println("─" + value);
        } else {
            System.out.print("┬");
            tree_draw(head, lpad + (end ? " " : "│") /* + " " */);
        }
    }

    private void tree_draw(Node head, String lpad) {
        System.out.println(head.data);
        if (head.right != null || head.left != null) {
            draw_branch(head.left, lpad, false);
            draw_branch(head.right, lpad, true);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.print();
        tree.insert(20);
        tree.print();
        tree.insert(30);
        tree.print();
        tree.insert(40);
        tree.print();
        tree.insert(50);
        tree.print();
        tree.insert(25);
        tree.print();
    }
}
