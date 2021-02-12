public class BinaryTree {
    public BinaryTree left, right;
    public String name;

    public BinaryTree(String name, BinaryTree left, BinaryTree right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String form() {
        return this.form(0);
    }

    public String form(int seed) {
        if (this.left == null && this.right == null)
            return name;
        String s = name;
        s += bracket_l(seed);
        if (this.left != null)
            s += this.left.form(seed + 1);
        s += ",";
        if (this.right != null)
            s += this.right.form(seed + 1);
        return s + bracket_r(seed);
    }

    public void invert() {
        if (this.right != null)
            this.right.invert();
        if (this.left != null)
            this.left.invert();
        BinaryTree tmp = this.left;
        this.left = this.right;
        this.right = tmp;
    }

    /**
     * @param seed 
     * @return seed%3= 0: '(',  1: '[',  2: '{' 
     */
    private static char bracket_l(int seed) {
        return (char) (40 + 32 * (seed % 3) + 19 * ((seed % 3 + 1) / 2));
    }
    
    /**
     * @param seed 
     * @return seed%3= 0: ')',   1: ']',   2: '}'
     */
    private static char bracket_r(int seed) {
        return (char) (41 + 32 * (seed % 3) + 20 * ((seed % 3 + 1) / 2));
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree("O", null, null);
        tree.left = new BinaryTree("L", null, null);
        tree.right = new BinaryTree("R", null, null);
        tree.right.left = new BinaryTree("RL", null, null);
        tree.right.right = new BinaryTree("RR", null, null);
        tree.right.left.left = new BinaryTree("RLL", null, null);

        System.out.println(tree.form());
        tree.invert();
        System.out.println(tree.form());
        // for (int i = 0; i < 10; i++) {
        //     System.out.println("|" + (int)bracket_l(i) + "\t" + (char) bracket_l(i) + "\t|" + (int)bracket_r(i) + "\t"
        //             + (char) bracket_r(i));
        // }

    }
}
