import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TravellingSalesmanTest {
        public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("input.txt"));

            int n = sc.nextInt();           // number of cities
            int[][] dist = new int[n][n];   // distance matrix

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = sc.nextInt();
                }
            }
            sc.close();

            // Assign to TravellingSalesMan class static variables
            TravellingSalesMan.cities = n;
            TravellingSalesMan.dist = dist;

            // Call tsp
            int minCost = TravellingSalesMan.tsp();
            System.out.println("Minimum cost to visit all cities: " + minCost);
            // print path
            System.out.print("Path: ");
            for (int city : TravellingSalesMan.path) {
                System.out.print(city + " ");
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
            e.printStackTrace();
        }
    }
}
