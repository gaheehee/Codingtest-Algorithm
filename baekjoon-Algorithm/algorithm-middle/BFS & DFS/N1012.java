import java.util.*;
import java.io.*;

public class N1012 {
    static final int[] dx = {-1, +1, 0, 0};
    static final int[] dy = {0, 0, -1, +1};
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] visited;

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                map[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine(), " ");
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                map[n][m] = 1;
            }

            int cnt = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (map[n][m] == 1) {
                        visited[n][m] = true;
                        map[n][m] = 0;
                        cnt++;
                        dfs(n, m);
                    }
                }
            }

            System.out.println(cnt);

        }
    }
}

