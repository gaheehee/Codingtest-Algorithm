import java.util.*;
import java.io.*;

public class N17070 {
    static int N;
    static int[][] house;
    static int result = 0;

    static void dfs(int x, int y, int type) {
        if (x == N && y == N) {
            result++;
            return;
        }

        if (type == 0){     //가로
            if (x < N + 1 && y + 1 < N + 1 && house[x][y+1] != 1) {
                dfs(x, y + 1, 0);    //가로
                if (x + 1 < N + 1 && y < N + 1 && house[x+1][y] != 1 && house[x+1][y+1] != 1)
                    dfs(x + 1, y + 1, 2);   //대각선
            }
        } else if (type ==  1) {    //세로
            if (x + 1 < N + 1 && y < N + 1 && house[x+1][y] != 1){
                dfs(x + 1, y, 1);   //세로
                if (x < N + 1 && y + 1 < N + 1 && house[x][y+1] != 1 && house[x+1][y+1] != 1)
                    dfs(x + 1, y + 1, 2);   //대각선
            }
        } else {    //대각선
            if (x < N + 1 && y + 1 < N + 1 && house[x][y+1] != 1)
                dfs(x, y + 1, 0);    //가로
            if (x + 1 < N + 1 && y < N + 1 && house[x+1][y] != 1)
                dfs(x + 1, y, 1);   //세로
            if (x + 1 < N + 1 && y < N + 1 && x < N + 1 && y + 1 < N + 1 && house[x+1][y] != 1 && house[x][y+1] != 1 && house[x+1][y+1] != 1)
                dfs(x + 1, y + 1, 2);   //대각선
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        house = new int[N+1][N+1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < N + 1; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 2, 0);
        System.out.println(result);
    }
}
