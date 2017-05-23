package algo.blatt06;

/**
 * Created by micha on 09.05.2017.
 */
public class TestBinTree {
    public static void main(String[] args) {
        //BinTree tree = new BinTree(new int[] {1, 2, 3});
        BinTree tree = new BinTree(30, 1, 100);

        System.out.println(tree.getNodeCount());
        System.out.println(tree.toString());
        System.out.println(tree.getHeight());
        System.out.println(tree.isComplete());
    }
}
