import java.util.*;
import java.io.*;

public class N1967timeout {
    static int[][] edges;
    static int N;
    static int max = 0;
    static int weight;

    static void dfs(int leaf_1, int leaf_2) {
        //System.out.println("in: " + leaf_1 + ", " + leaf_2);
        int[] l1 = new int[3];
        int[] l2 = new int[3];

        for (int i = 0;  i < N-1; i++) {
            if (leaf_1 == edges[i][1]) {
                l1 = edges[i];
            }
            if (leaf_2 == edges[i][1]) {
                l2 = edges[i];
            }
        }

        if (l1[0] == l2[0]) {
            weight += (l1[2] + l2[2]);
            if (weight > max) max= weight;
            return;
        } else {
            weight += (l1[2] + l2[2]);
            dfs(l1[0], l2[0]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        boolean[] parents = new boolean[N + 1];
        edges = new int[N-1][3];
        ArrayList<Integer> leafs = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            edges[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            parents[edges[i][0]] = true;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!parents[i]) leafs.add(i);
        }

        for (int i = 0; i < leafs.size() - 1; i++) {
            for (int j = i+1; j < leafs.size(); j++) {
                weight = 0;
                dfs(leafs.get(i), leafs.get(j));
            }
        }

        System.out.println(max);
    }
}
