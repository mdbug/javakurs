package algo.blatt09;

import java.util.ArrayList;

/**
 * algo.blatt09
 */
public class Zusatzaufgabe {
    public static ArrayList<Integer> shortestWay(int[] f) {
        ArrayList<Integer> way = new ArrayList<>();
        way.add(0);
        shortestWay(f, way, new boolean[f.length]);
        return way;
    }

    private static int shortestWay(int[] f, ArrayList<Integer> path, boolean[] visited) {
        int pos = path.get(path.size() - 1);
        if (pos == f.length - 1) {
            return f[pos];
        }
        visited[pos] = true;
        int back = Integer.MAX_VALUE;
        int forward = Integer.MAX_VALUE;

        ArrayList<Integer> p0 = new ArrayList<>();
        ArrayList<Integer> p1 = new ArrayList<>();
        if (pos > 0 && !visited[pos - 1]) {
            p0.add(pos - 1);
            back = shortestWay(f, p0, visited);
        }
        if (pos + 3 < f.length && !visited[pos + 3]) {
            p1 = new ArrayList<>();
            p1.add(pos + 3);
            forward = shortestWay(f, p1, visited);
        }
        visited[pos] = false;
        if (back < forward) {
            path.addAll(p0);
            return back + f[pos];
        } else if (back > forward || back != Integer.MAX_VALUE){
            path.addAll(p1);
            return forward + f[pos];
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(shortestWay(new int[]{5, 2, 9, 2, 9, 5, 3, 10, 5}));
    }
}
