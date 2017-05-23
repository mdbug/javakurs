package blatt08;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Graph {
    private ArrayList<ArrayList<Integer>> adjazenzliste;

    public Graph(int v) {
        adjazenzliste = new ArrayList<>();
        for (int i = 0; i < v; ++i) {
            adjazenzliste.add(new ArrayList<>());
        }
    }

    public Graph(int[] list) {
        this(list[0]);
        int kanten = list[1];
        for (int i = 0; i < kanten; ++i) {
            adjazenzliste.get(list[i * 2 + 2] - 1).add(list[i * 2 + 3] - 1);
        }
    }

    public Graph(int v, int e) {
        this(v);
        for (int i = 0; i < e; ++i) {
            boolean erfolg;
            do {
                erfolg = addEdge((int) (Math.random() * v) + 1, (int) (Math.random() * v) + 1);
            } while(!erfolg);
        }
    }

    public Graph(InputStream in) {
        try(Scanner scanner = new Scanner(in)) {
            int node = 1;
            while(scanner.hasNextLine()) {
                adjazenzliste.add(new ArrayList<>());
                String line = scanner.nextLine();
                String[] tokens = line.split("\\s*;\\s*");
                for (String token : tokens) {
                    addEdge(node, Integer.parseInt(token));
                }
                ++node;
            }
        }
    }

    public int getVertexCount() {
        return adjazenzliste.size();
    }

    public int getEdgeCount() {
        int kanten = 0;
        for (ArrayList<Integer> node : adjazenzliste) {
            kanten += node.size();
        }
        return kanten;
    }

    public boolean addEdge(int from, int to) {
        if (adjazenzliste.get(from-1).indexOf(to-1) == -1)
        {
            adjazenzliste.get(from-1).add(to-1);
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getAdjacent(int v) {
        return adjazenzliste.get(v);
    }

    public String toString() {
        StringBuilder s = new StringBuilder("[");

        for (ArrayList<Integer> node : adjazenzliste) {
            s.append('[');
            for (int edge : node) {
                s.append(edge + 1).append(',');
            }
            s.setCharAt(s.length() - 1, ']');
        }
        s.append(']');
        return s.toString();
    }

    public ArrayList<Integer> dfs(int start) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(start, list);
        return list;
    }

    public void dfs(int start, ArrayList<Integer> list) {
        if (list.indexOf(start) != -1) {
            return;
        }
        list.add(start);
        Collections.sort(adjazenzliste.get(start-1));
        for (int child : adjazenzliste.get(start-1)) {
            dfs(child + 1, list);
        }
    }

    public ArrayList<Integer> bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        bfs(start, queue);
        return list;
    }

    public void bfs(int start, ArrayDeque<Integer> queue) {
        if (list.indexOf(start) != -1) {
            return;
        }

        Collections.sort(adjazenzliste.get(start-1));
        for (int child : adjazenzliste.get(start-1)) {
            list.add(child + 1);
        }
    }
}
