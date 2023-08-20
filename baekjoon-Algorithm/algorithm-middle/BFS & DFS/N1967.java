import java.io.*;
import java.util.*;

public class N1967 {
    static int N;
    static List<Node> adlist[];
    static boolean[] visited;
    static int ans;

    static class Node{
        int num, len;
        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }

    private static void dfs(int num, int dis) {
        for (Node n : adlist[num]) {
            if (!visited[n.num]) {
                visited[n.num] = true;
                dfs(n.num, n.len + dis);
            }
        }

        ans = (dis > ans) ? dis : ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adlist = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i < N + 1; i++) {
            adlist[i] = new ArrayList<Node>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            adlist[from].add(new Node(to, len));
            adlist[to].add(new Node(from, len));
        }

        ans = 0;
        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(ans);
    }
}
