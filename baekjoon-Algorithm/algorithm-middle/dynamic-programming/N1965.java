import java.io.*;
import java.util.*;

public class N1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nlist = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i= 0; i < n; i++) {
            nlist[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nlist[j] < nlist[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
