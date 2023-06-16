import java.util.*;
import java.io.*;

public class N1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] gd = new int[N][2];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                gd[j][0] = Integer.parseInt(st.nextToken());
                gd[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(gd, Comparator.comparingInt(o1 -> o1[0]));

            int top = gd[0][1];
            int cnt = 1;

            for (int j = 0; j < N; j++) {
                if (gd[j][1] < top) {
                    top = gd[j][1];
                    cnt += 1;
                }
            }

            System.out.println(cnt);

        }
    }
}
