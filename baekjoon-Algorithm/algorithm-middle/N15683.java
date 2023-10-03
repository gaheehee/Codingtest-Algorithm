import java.util.*;
import java.io.*;

public class N15683 {
    static int n, m, depth;
    static int min = Integer.MAX_VALUE;
    static int[] dx = {-1, +1, 0, 0};
    static int[] dy = {0, 0, +1, -1};
    static int[][][] direct = {{},
            {{0}, {1}, {2}, {3}},
            {{0,1}, {2,3}},
            {{0,2}, {1,2}, {1,3}, {0,3}},
            {{0,2,3}, {0,1,2}, {1,2,3}, {0,1,3}},
            {{0,1,2,3}}
    };
    static List<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;
                if (tmp != 0 && tmp != 6) {
                    cctv.add(new int[]{i, j, tmp});
                }
            }
        }

        depth = cctv.size();

        backtracking(map, 0);

        System.out.println(min);
    }

    private static void backtracking(int[][] map, int dep) {
        if (dep == depth) {
            min = Math.min(min, check(map));
            return;
        }

        int x = cctv.get(dep)[0];
        int y = cctv.get(dep)[1];
        int d = cctv.get(dep)[2];

        for (int i = 0; i < direct[d].length; i++) {
            int[][] m_copy = new int[n][m];

            for (int k = 0; k < n; k++) {
                m_copy[k] = map[k].clone();
            }

            for (int j = 0; j < direct[d][i].length; j++) {
                int dir = direct[d][i][j];
                int nx = dx[dir] + x;
                int ny = dy[dir] + y;

                while (true) {
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 6)
                        break;

                    m_copy[nx][ny] = -1;
                    nx += dx[dir];
                    ny += dy[dir];
                }
            }

            backtracking(m_copy, dep + 1);
        }
    }

    private static int check(int[][] map) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
