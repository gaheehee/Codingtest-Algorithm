import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class N9655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for (int i = 4; i < 1001; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-1]) + 1;
        }

        if (dp[N] % 2 == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
