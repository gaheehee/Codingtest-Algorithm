import java.util.*;
import java.io.*;

public class N14503 {
    static int[] dx = {-1, 0, +1, 0};
    static int[] dy = {0, +1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cur = new int[2];
        cur[0] = Integer.parseInt(st.nextToken());
        cur[1] = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //청소 한 경우: -1, 빈칸: 0, 벽: 1
        int nx = 0;
        int ny = 0;
        int clean_num = 0;

        while (true) {

            //1. 현재 칸이 청소되지 않은 경우, 현재 칸 청소한다.
            if (map[cur[0]][cur[1]] == 0) {
                map[cur[0]][cur[1]] = -1;
                clean_num++;
            }

            boolean exist = false;

            for (int i = 0; i < 4; i++) {
                nx = cur[0] + dx[i];
                ny = cur[1] + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    exist = true;
                }
            }

            //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            if (!exist) {
                int nd = (d+2) % 4;
                nx = cur[0] + dx[nd];
                ny = cur[1] + dy[nd];
                //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
                    cur[0] = nx;
                    cur[1] = ny;
                }
                //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                else {
                    break;
                }
            }
            //3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
            else {
                //반시계 방향으로 90도 회전한다.
                d = (d+3) % 4;
                nx = cur[0] + dx[d];
                ny = cur[1] + dy[d];
                //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    cur[0] = nx;
                    cur[1] = ny;
                }
            }
        }

        System.out.println(clean_num);

    }
}
