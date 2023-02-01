import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer command = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i < n; i++) {
            arr[i] = Integer.parseInt(command.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];

        for (int i=1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i-1]+arr[i]);
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
