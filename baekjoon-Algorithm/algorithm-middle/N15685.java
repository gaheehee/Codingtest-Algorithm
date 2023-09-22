import java.util.*;
import java.io.*;

public class N15685 {
    static int[] dx = {0, -1, 0, +1};
    static int[] dy = {+1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[101][101];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();

            int[] xy = new int[2];
            xy[1] = Integer.parseInt(st.nextToken());
            xy[0] = Integer.parseInt(st.nextToken());
            visited[xy[0]][xy[1]] = true;

            int d = Integer.parseInt(st.nextToken());
            int nx = xy[0] + dx[d];
            int ny = xy[1] + dy[d];
            list.add(d);
            visited[nx][ny] = true;
            int[] last_xy = {nx, ny};

            int cnt = Integer.parseInt(st.nextToken());

            while (cnt > 0) {

                for (int j = list.size() - 1; j > -1; j--) {
                    int newd = (list.get(j) + 1) % 4;
                    list.add(newd);
                    last_xy[0] = last_xy[0] + dx[newd];
                    last_xy[1] = last_xy[1] + dy[newd];
                    visited[last_xy[0]][last_xy[1]] = true;
                }

                cnt--;
            }
        }

        //System.out.println(Arrays.deepToString(visited));

        int answer = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {

                if (visited[i][j] && visited[i][j + 1] && visited[i + 1][j] && visited[i + 1 ][j + 1])
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
