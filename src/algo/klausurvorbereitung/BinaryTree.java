package algo.klausurvorbereitung;

public class BinaryTree {
    public Node root;

    public BinaryTree(int x) {
        root = new Node();
        root.value = x;
    }

    public BinaryTree(BinaryTree b) {
        if (b.root != null) {
            root = new Node();
            copy(root, b.root);
        }
    }

    public int getLevelSum(int level) {
        return getLevelSum(level, root);
    }

    private int getLevelSum(int level, Node node) {
        if (node == null) {
            return 0;
        }

        if (level == 0) {
            return node.value;
        }

        return getLevelSum(level-1, node.left) + getLevelSum(level-1, node.right);
    }

    private void copy(Node to, Node from) {
        to.value = from.value;
        if (from.left != null) {
            to.left = new Node();
            copy(to.left, from.left);
        }
        if (from.right != null) {
            to.right = new Node();
            copy(to.right, from.right);
        }
    }
}
