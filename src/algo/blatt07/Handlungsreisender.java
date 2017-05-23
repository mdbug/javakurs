package algo.blatt07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Handlungsreisender {
    private static ArrayList<String> cities = new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> distances = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File("hauptstaedte.txt");
        try(Scanner scan = new Scanner(file, "UTF-8")) {
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] tokens = line.split("\\s+");
                cities.add(tokens[0]);
                ArrayList<Integer> dist = new ArrayList<>();
                for (int j = 1; j < tokens.length; ++j) {
                    dist.add(Integer.parseInt(tokens[j]));
                }
                distances.add(dist);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }

        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Bitte Anfangsstadt der Reise eingeben (x für Ende): ");
            String start = input.nextLine();
            if (start.equals("x")) {
                System.exit(0);
            }
            System.out.println(getRoute(start));
        }
    }

    private static String getRoute(String start) {
        StringBuilder route = new StringBuilder();
        boolean[] visited = new boolean[cities.size()];
        int city = cities.indexOf(start);
        if (city == -1) {
            return "WTF?";
        }
        int nextCity;
        while(city != -1) {
            route.append(cities.get(city)).append(" - ");
            visited[city] = true;
            nextCity = -1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < distances.get(city).size(); ++j) {
                if (!visited[j]) {
                    int dist = distances.get(city).get(j);
                    if (dist < minDist) {
                        minDist = dist;
                        nextCity = j;
                    }
                }
            }
            city = nextCity;
        }
        route.append(start);
        return route.toString();
    }
}