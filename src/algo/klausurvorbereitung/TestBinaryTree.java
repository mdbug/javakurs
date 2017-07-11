package algo.klausurvorbereitung;

public class TestBinaryTree {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree(1);
        b.root.left = new Node();
        b.root.left.value = 2;
        b.root.right = new Node();
        b.root.right.value = 3;
        b.root.left.left = new Node();
        b.root.left.left.value = 4;

        BinaryTree c = new BinaryTree(b);
        System.out.println(c.getLevelSum(0));
        System.out.println(c.getLevelSum(1));
        System.out.println(c.getLevelSum(2));
    }
}
