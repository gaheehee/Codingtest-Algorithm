import java.util.*;
import java.io.*;

public class N15686 {
    static int n;
    static int m;
    static List<Node> houses = new ArrayList<>();
    static List<Node> chickens = new ArrayList<>();
    static int city_dist = Integer.MAX_VALUE;
    static int clen;
    static int hlen;

    static class Node {
        int x;
        int y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1)
                    houses.add(new Node(i, j));
                else if (num == 2)
                    chickens.add(new Node(i, j));
            }
        }

        hlen = houses.size();
        clen = chickens.size();

        combination(new boolean[clen], 0, m, 0);

        System.out.println(city_dist);
    }

    public static void combination(boolean[] visited, int start, int r, int depth) {
        if (depth == r) {
            chicken_dist(visited);
            return;
        }

        for (int i = start; i < clen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(visited, i + 1, r, depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void chicken_dist(boolean[] visited) {
        //System.out.println("vistied: " + Arrays.toString(visited));
        int min = Integer.MAX_VALUE;
        int total = 0;

        for (int i = 0; i < hlen; i++) {
            int hx = houses.get(i).x;
            int hy = houses.get(i).y;
            min = Integer.MAX_VALUE;

            for (int j = 0; j < clen; j++) {
                if (visited[j]) {
                    min = Math.min(min, Math.abs(hx - chickens.get(j).x) +  Math.abs(hy - chickens.get(j).y));
                }
            }
            //System.out.println("total: " + total);
            total += min;
        }

        city_dist = Math.min(total, city_dist);
        //System.out.println("city_dist: " + city_dist);
        return;
    }
}
