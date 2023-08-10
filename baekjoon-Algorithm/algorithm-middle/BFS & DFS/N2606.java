import java.util.*;
import java.io.*;

public class N2606 {
    static int pair_num;
    static int[][] connect;
    static boolean[] visited;
    static int cnt = 0;

    static void bfs(int target) {
        visited[target] = true;
        Deque<Integer> q = new LinkedList<>();
        q.add(target);

        while (!q.isEmpty()) {
            int t = q.poll();

            for (int i = 0; i < connect.length; i++) {
                //System.out.println("!!!: " + connect[i][0] + ", " + connect[i][1]);
                if (connect[i][0] == t && !visited[connect[i][1]]) {
                    //System.out.println(connect[i][1]);
                    q.add(connect[i][1]);
                    visited[connect[i][1]] = true;
                    cnt++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        pair_num = Integer.parseInt(br.readLine());
        connect = new int[pair_num * 2][2];
        visited = new boolean[n+1];

        if (pair_num > 0){
            for (int i = 0; i < pair_num; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int tmp1 = Integer.parseInt(st.nextToken());
                int tmp2 = Integer.parseInt(st.nextToken());
                connect[i*2] = new int[]{tmp1, tmp2};
                connect[i*2 + 1] = new int[]{tmp2, tmp1};
            }
            bfs(1);
        }

        System.out.println(cnt);
    }
}
