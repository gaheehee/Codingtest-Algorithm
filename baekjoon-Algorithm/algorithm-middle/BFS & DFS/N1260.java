import java.util.*;
import java.io.*;

public class N1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int N, M, startV;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken());

        int i, a, b = 0;
        arr = new int[N+1][N+1];
        check = new boolean[N+1];

        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        DFS(startV);
        sb.append("\n");
        check = new boolean[N+1];
        BFS(startV);

        System.out.println(sb);
    }

    public static void DFS(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 0; i <= N; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");

            for (int i = 0; i <= N; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
