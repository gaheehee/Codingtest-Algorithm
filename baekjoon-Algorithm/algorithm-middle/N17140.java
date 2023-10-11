import java.util.*;
import java.io.*;

public class N17140 {
    static int[][] A = new int[100][100];
    static int max_r = 3;
    static int max_c = 3;

    static class Pair {
        int num;
        int cnt;

        Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Integer.parseInt(st.nextToken());
        }

        int sec = -1;

        for (int time = 0; time <= 100; time++) {
            if (A[r][c] == k) {
                sec = time;
                break;
            }

            if (max_r < max_c) c_operation();
            else r_operation();
            //System.out.println(Arrays.deepToString(A));
        }

        System.out.println(sec);
    }


    static public void r_operation() {
        int[][] A_tmp = new int[100][100];
        int max_cc = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt)
                return o1.num - o2.num;
            else
                return o1.cnt - o2.cnt;
        });

        for (int i = 0; i < A.length; i++) {
            hm.clear();
            pq.clear();

            for (int j = 0; j < A[0].length; j++) {
                int a = A[i][j];
                if (a == 0) continue;
                hm.put(a, hm.getOrDefault(a, 0) + 1);
            }

            for (int key : hm.keySet()) {    //map.forEach((k, v) -> pq.add(new Pair(k, v)));
                pq.add(new Pair(key, hm.get(key)));
            }

            max_cc = Math.max(max_cc, pq.size() * 2);

            //넣기
            int idx = 0;
            if (pq.size() <= 50) {
                while (!pq.isEmpty()) {
                    Pair p = pq.poll();
                    A_tmp[i][idx] = p.num;
                    idx++;
                    A_tmp[i][idx] = p.cnt;
                    idx++;
                }
            }
            else {
                for (int j = 0; j < 50; j++) {
                    Pair p = pq.poll();
                    A_tmp[i][idx] = p.num;
                    idx++;
                    A_tmp[i][idx] = p.cnt;
                    idx++;
                }
            }
        }

        max_c = Math.max(max_c, max_cc);

        for (int i = 0; i < A.length; i++) {
            A[i] = A_tmp[i].clone();
        }
    }


    static public void c_operation() {
        int[][] A_tmp = new int[100][100];
        int max_rr = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.cnt == o2.cnt)
                return o1.num - o2.num;
            else
                return o1.cnt - o2.cnt;
        });

        for (int i = 0; i < A[0].length; i++) {
            hm.clear();
            pq.clear();

            for (int j = 0; j < A.length; j++) {
                int a = A[j][i];
                if (a == 0) continue;
                hm.put(a, hm.getOrDefault(a, 0) + 1);
            }

            for (int key : hm.keySet()) {    //map.forEach((k, v) -> pq.add(new Pair(k, v)));
                pq.add(new Pair(key, hm.get(key)));
            }

            max_rr = Math.max(max_rr, pq.size() * 2);

            //넣기
            int idx = 0;
            if (pq.size() <= 50) {
                while (!pq.isEmpty()) {
                    Pair p = pq.poll();
                    A_tmp[idx][i] = p.num;
                    idx++;
                    A_tmp[idx][i] = p.cnt;
                    idx++;
                }
            }
            else {
                for (int j = 0; j < 50; j++) {
                    Pair p = pq.poll();
                    A_tmp[idx][i] = p.num;
                    idx++;
                    A_tmp[idx][i] = p.cnt;
                    idx++;
                }
            }
        }

        max_r = Math.max(max_r, max_rr);

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = A_tmp[i][j];
            }
        }
    }
}
