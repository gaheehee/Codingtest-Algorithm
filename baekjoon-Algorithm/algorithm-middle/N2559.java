import java.util.*;
import java.io.*;

public class N2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nlist = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nlist[i] = Integer.parseInt(st.nextToken());
        }

        int num = 0;

        for (int i = 0; i < k; i++) {
            num += nlist[i];
        }

        int result = num;

        for (int i = k; i < n; i++) {
            num = num - nlist[i-k] + nlist[i];
            result = Math.max(result, num);
        }

        System.out.println(result);
    }
}
