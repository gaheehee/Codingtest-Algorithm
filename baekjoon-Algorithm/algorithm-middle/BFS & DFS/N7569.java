import java.util.*;
import java.io.*;

public class N7569 {
    final static int[] dh = {-1, +1, 0, 0, 0, 0};   //위, 아래, 오른, 왼, 앞, 뒤
    final static int[] dn = {0, 0, +1, -1, 0, 0};
    final static int[] dm = {0, 0, 0, 0, +1, -1};
    static int N;
    static int M;
    static int H;
    static int[][][] tomato;
    static boolean[][][] visited;
    static int cnt0;
    static int howdays;

    static class Node {
        int h;
        int n;
        int m;
        public Node (int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }

    static Queue<Node> bfs(Queue<Node> queue) {
        Queue<Node> q = new LinkedList<>();

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            visited[node.h][node.n][node.m] = true;

            for (int i = 0; i < 6; i++) {
                int nh = dh[i] + node.h;
                int nn = dn[i] + node.n;
                int nm = dm[i] + node.m;

                if (nh >= 0 && nn >= 0 && nm >= 0 && nh < H && nn < N && nm < M && !visited[nh][nn][nm]) {
                    if (tomato[nh][nn][nm] == 0) {
                        tomato[nh][nn][nm] = 1;
                        q.add(new Node(nh, nn, nm));
                        cnt0--;
                        //System.out.println("h: " + nh + " n: " + nn + " m: " + nm);
                        //System.out.println(cnt0);
                    }
                }
            }
        }

        return q;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());

                    if (tomato[i][j][k] == 0) {
                        cnt0++;
                    }

                    if (tomato[i][j][k] == 1) {
                        queue.add(new Node(i, j, k));
                    }
                }
            }
        }

        if (cnt0 == 0) {
            System.out.println(0);
        }
        else {
            howdays = 0;


            while(!queue.isEmpty()) {
                //System.out.println("bfs: ");
                queue = bfs(queue);
                howdays++;
            }

            if (cnt0 == 0) {
                System.out.println(howdays - 1);
            } else {
                System.out.println(-1);
            }
        }
    }
}
