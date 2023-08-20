import java.util.*;
import java.io.*;

public class N2629 {
    static int chooN, marbleN, marble, choos[];
    static final int max = 15000;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        chooN = Integer.parseInt(br.readLine());
        choos = new int[chooN + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < chooN + 1; i++) {
            choos[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[chooN + 1][max + 1];
        find_dp(0, 0);

        marbleN = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < marbleN + 1; i++) {
            marble = Integer.parseInt(st.nextToken());
            if (marble > max) {
                sb.append("N ");
            } else {
                sb.append(dp[chooN][marble]? "Y ": "N ");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static void find_dp(int idx, int weight) {
        if (dp[idx][weight]) return;
        dp[idx][weight] = true;
        if (idx == chooN) return;

        find_dp(idx + 1, weight + choos[idx + 1]);
        find_dp(idx + 1, weight);
        find_dp(idx + 1, Math.abs(weight - choos[idx + 1]));
    }
}
