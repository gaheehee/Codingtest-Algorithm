import java.util.*;
import java.io.*;

public class N14891 {
    static int[][] topnis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        topnis = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                topnis[i][j] = s.charAt(j) - '0';
            }
        }

        int iter_num = Integer.parseInt(br.readLine());
        int[][] iter_info = new int[iter_num][2];
        StringTokenizer st;

        for (int i = 0; i < iter_num; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                iter_info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ddd = {2, 6};

        for (int i = 0; i < iter_num; i++) {
            int n = iter_info[i][0] -  1;
            int d = iter_info[i][1];
            int[] turn = new int[4];
            turn[n] = d;

            // n 왼쪽
            for (int j = 0; n != 0 && j < n; j++) {
                if (topnis[n - j][6] != topnis[n - j - 1][2])
                    turn[n - j - 1] = j % 2 == 0 ? -d : d; // j가 짝수면 다른 방향, 홀수면 같은 방향
                else
                    break;
            }

            // n 오른쪽
            for (int j = 0; n != 3 && j < 4 - n - 1; j++) {
                if (topnis[n + j][2] != topnis[n + j + 1][6])
                    turn[n + j + 1] = j % 2 == 0 ? -d : d; // j가 짝수면 다른 방향, 홀수면 같은 방향
                else
                    break;
            }

            //회전
           for (int j = 0; j < 4; j++) {
               int tt = turn[j];
               if (tt != 0) {
                   rotate(j, tt);
               }
           }
        }

        int num = 1;
        int result = 0;

        for (int i = 0; i < 4; i++, num *= 2) {
            if (topnis[i][0] == 1)
                result += num;
        }

        //System.out.println(Arrays.deepToString(topnis));
        System.out.println(result);

    }


    public static void rotate(int n, int d) {
        //System.out.println("rotate " + n + ", " + d);
        int tmp = 0;

        //시계 방향
        if (d == 1) {

            tmp = topnis[n][7];
            for (int i = 7; i > 0; i--) {
                topnis[n][i] = topnis[n][i - 1];
            }
            topnis[n][0] = tmp;

        }
        //반시계 방향
        else {

            tmp = topnis[n][0];

            for (int i = 0; i < 7; i++) {
                topnis[n][i] = topnis[n][i + 1];
                //System.out.println(Arrays.deepToString(topnis));
            }
            topnis[n][7] = tmp;

        }

        //System.out.println(Arrays.deepToString(topnis));
    }
}
