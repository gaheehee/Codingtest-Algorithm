import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt_5, cnt_3 = 0;
        int remain_5, remain_3 = 0;
        int result = 0;

        cnt_5 = N / 5;
        remain_5 = N % 5;

        cnt_3 = remain_5 / 3;
        remain_3 = remain_5 % 3;

        if (remain_3 != 0) {
            while(remain_3 != 0) {
                if (cnt_5 == 0) {
                    result = -1;
                    break;
                } else {
                    cnt_5 -= 1;
                    remain_5 += 5;

                    cnt_3 = remain_5 / 3;
                    remain_3 = remain_5 % 3;
                    result = cnt_5 + cnt_3;
                }
            }
        } else {
            result = cnt_5 + cnt_3;
        }
        System.out.println(result);
    }
}
