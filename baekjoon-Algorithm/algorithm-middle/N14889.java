import java.io.*;
import java.util.*;

public class N14889 {
    static int[][] smap;
    static int n;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        smap = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                smap[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        combination(new boolean[n], 0, n/2 , 0);

        System.out.println(answer);
    }

    //n/3개로 뽑아내는 조합 구하는 함수
    public static void combination(boolean[] visited, int start, int r, int depth) {

        if (depth == r) {
            check_power(visited);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(visited, i + 1, r, depth + 1);
                visited[i] = false;
            }
        }
    }

    //두 팀의 능력치 차이 값 계산하는 함수
    public static void check_power(boolean[] visited) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                //i, j 같은 팀
                if (visited[i] && visited[j]) {
                    sum1 += smap[i][j];
                    sum1 += smap[j][i];
                }
                else if (!visited[i] && !visited[j]) {
                    sum2 += smap[i][j];
                    sum2 += smap[j][i];
                }
            }
        }

        answer = Math.min(answer, Math.abs(sum1 - sum2));
    }
}
