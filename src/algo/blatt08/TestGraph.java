package algo.blatt08;

public class TestGraph {
    public static void main(String[] args) {
//        int[] vlist = {6, 10, 1, 5, 1, 4, 2, 3, 2, 6, 3, 4, 3, 5, 4, 5, 4, 6, 5, 6, 6, 4};
//        Graph g = new Graph(vlist);
//        System.out.println(g);
//
//        Graph g2 = new Graph(5, 20);
//        System.out.println(g2);
        Graph g = new Graph(new int[] {6,10,1,5,1,4,2,3,2,6,3,4,3,5,4,5,4,2,5,4,6,6,1});
        System.out.println(g.dfs(1));
    }
}
