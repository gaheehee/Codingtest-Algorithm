import java.util.*;
import java.io.*;

public class N1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a, b = 0;
        int min6 = 1001;
        int min1 = 1001;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a < min6) min6 = a;
            if (b < min1) min1 = b;
        }

        int num6 = N / 6;
        int num1 = N % 6;

        int result = Math.min(N *min1, Math.min((num6 + 1) * min6, (num6 * min6) + (num1 * min1)));

        System.out.println(result);
    }
}
