import java.util.*;
import java.io.*;

public class N13458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long cnt = 0;
        int a = 0;

        for (int i = 0; i < n; i++) {
            a = A[i] - b;
            cnt++;

            if (a <= 0)
                continue;

            cnt += (a / c);

            if (a % c != 0)
                cnt++;

        }

        System.out.println(cnt);
    }

}
