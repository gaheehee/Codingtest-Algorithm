import java.io.*;
import java.util.*;

public class N12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);
        int[][] items = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(st[0]);
            items[i][1] = Integer.parseInt(st[1]);
        }

        int[][] dp = new int[N+1][K+1];
        int a = 0;
        int b = 0;

        for (int i = 1; i < N+1; i++) {
            int w = items[i-1][0];
            int v = items[i-1][1];

            for (int j = 1; j < K+1; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K]);

    }
}
