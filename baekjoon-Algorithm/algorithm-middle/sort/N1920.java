package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class N1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> nlist = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 0;

        for (i = 0; i < N; i++) {
            nlist.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        int[] mlist = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        for (i = 0; i < M; i++) {
            mlist[i] = Integer.parseInt(st.nextToken());
        }

        Collections.sort(nlist);

        for (int num : mlist) {
            if (Collections.binarySearch(nlist, num) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
