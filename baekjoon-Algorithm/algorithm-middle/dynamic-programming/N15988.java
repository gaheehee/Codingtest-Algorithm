import java.io.*;

public class N15988 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int i = 0;

        for (i = 4; i < 1000001; i++) {
            dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % 1000000009;
        }

        int T = Integer.parseInt(br.readLine());

        for (i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N] % 1000000009);
        }
    }
}
