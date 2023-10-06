import java.util.*;
import java.io.*;

public class N14499 {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //System.out.println("map: " +  Arrays.deepToString(map));

        int[] ops = new int[k];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        int[][] lw = new int[4][4];
        int tmp = 0;

        for (int i = 0; i < k; i++) {
            int op = ops[i];

            int nx = dx[op] + x;
            int ny = dy[op] + y;

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                x = nx;
                y = ny;

                if (op == 1) {

                    tmp = lw[1][3];
                    for (int j = 3; j > 0; j--) {
                        lw[1][j] = lw[1][j - 1];
                    }
                    lw[1][0] = tmp;
                    lw[3][1] = lw[1][3];

                    if (map[x][y] == 0) {
                        map[x][y] = lw[1][3];
                    } else {
                        lw[1][3] = map[x][y];
                        lw[3][1] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(lw[1][1]);
                } else if (op == 2) {

                    tmp = lw[1][0];
                    for (int j = 0; j < 3; j++) {
                        lw[1][j] = lw[1][j + 1];
                    }
                    lw[1][3] = tmp;
                    lw[3][1] = lw[1][3];

                    if (map[x][y] == 0) {
                        map[x][y] = lw[1][3];
                    } else {
                        lw[1][3] = map[x][y];
                        lw[3][1] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(lw[1][1]);
                } else if (op == 3) {

                    tmp = lw[0][1];
                    for (int j = 0; j < 3; j++) {
                        lw[j][1] = lw[j + 1][1];
                    }
                    lw[3][1] = tmp;
                    lw[1][3] = lw[3][1];

                    if (map[x][y] == 0) {
                        map[x][y] = lw[1][3];
                    } else {
                        lw[1][3] = map[x][y];
                        lw[3][1] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(lw[1][1]);
                } else {

                    tmp = lw[3][1];
                    for (int j = 3; j > 0; j--) {
                        lw[j][1] = lw[j - 1][1];
                    }
                    lw[0][1] = tmp;
                    lw[1][3] = lw[3][1];

                    if (map[x][y] == 0) {
                        map[x][y] = lw[1][3];
                    } else {
                        lw[1][3] = map[x][y];
                        lw[3][1] = map[x][y];
                        map[x][y] = 0;
                    }
                    System.out.println(lw[1][1]);
                }

                //System.out.println("x: " + x + " y: " + y);
                //System.out.println("map: " + Arrays.deepToString(map));
                //System.out.println("lw: " + Arrays.deepToString(lw));
            }
        }
    }
}
