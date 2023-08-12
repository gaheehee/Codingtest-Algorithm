import java.util.*;
import java.io.*;

public class N2225 {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K == 1) {
            System.out.println(1);
        } else {

            int[][] dp = new int[K][N];

            for (int i = 0; i < N; i++) {
                dp[0][i] = 1;
            }

            for (int k = 0; k < K; k++){
                dp[k][0] = k + 1;
            }

            for (int k = 1; k < K; k++) {
                for (int i = 1; i < N; i++) {
                    dp[k][i] = (dp[k-1][i] + dp[k][i-1]) % MOD;
                }
            }
            //System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[K-1][N-1]);
        }
    }
}
