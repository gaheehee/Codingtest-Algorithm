import java.io.*;
import java.util.*;

public class N14501 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n + 1];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i > -1; i--) {
            if (i + t[i] <= n) {
                dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]);
            } else {
                dp[i] = dp[i + 1];
            }

            max = Math.max(max, dp[i]);
        }
        //System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
