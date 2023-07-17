import java.util.*;
import java.io.*;

public class N10819 {
    private static int N;
    private static int[] nlist;
    private static int[] per;
    private static boolean[] visited;   // 중복 제거를 위한 방문처리
    private static int result;

    public static void permutation_dfs(int depth) {
        if (depth == N) {
            int s = 0;
            for (int i = 0; i < N - 1; i++) {
                s += Math.abs(per[i] - per[i+1]);
            }
            result = Math.max(s, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                per[depth] = nlist[i];
                visited[i] = true;
                permutation_dfs(depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nlist = new int[N];
        per = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            nlist[i] = Integer.parseInt(st.nextToken());
        }

        permutation_dfs(0);
        System.out.println(result);
    }
}
