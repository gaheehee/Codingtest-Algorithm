import java.util.*;
import java.io.*;

public class N11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] candies = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                candies[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + candies[i-1][j-1];
            }
        }

        System.out.println(dp[N][M]);

    }
}


