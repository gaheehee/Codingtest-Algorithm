import java.util.*;
import java.io.*;

public class N11722 {
    static public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nlist = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            nlist[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int result = 1;
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            cnt = 1;

            for (int j = i-1; j > -1; j--) {
                if (nlist[j] > nlist[i]) {
                    if ((1 + dp[j]) > cnt) {
                        cnt = 1 + dp[j];
                    }
                }
            }

            dp[i] = cnt;

            if (cnt > result) {
                result = cnt;
            }
        }

        System.out.println(result);
    }
}
