import java.io.*;

public class N9663 {
    static int N;
    static int[] row;
    static int cnt;

    static boolean is_promising(int x) {
        for (int i = 0; i < x; i++) {
            if (Math.abs(row[x] - row[i]) == x - i || row[x] == row[i]) {
                return false;
            }
        }
        return true;
    }

    static void n_queen(int x) {
        if (x == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            row[x] = i;

            if (is_promising(x)) {
                n_queen(x+1);
            }
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        row = new int[N];
        cnt = 0;

        n_queen(0);
        System.out.println(cnt);

    }
}
