import java.util.*;
import java.io.*;

public class N14888 {
    static int n;
    static int[] nums;
    static String[] op = {"+", "-", "*", "/"};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        int[] ops = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        permutation(ops, new String[n-1], n-1, 0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void permutation(int[] ops, String[] output, int r, int depth) {

        if (depth == r) {
            int result = nums[0];
            //System.out.println("output: " + Arrays.toString(output));
            //System.out.println(result);

            for (int i = 0; i < r; i++) {
                if (output[i].equals("+")) {
                    result += nums[i + 1];
                } else if (output[i].equals("-")) {
                    result -= nums[i + 1];
                } else if (output[i].equals("*")) {
                    result *= nums[i + 1];
                }
                else {
                    if (result < 0) {
                        result *= -1;
                        result /= nums[i + 1];
                        result *= -1;
                    } else
                        result /= nums[i + 1];
                }
                //System.out.println(result);
            }

            min = Math.min(min, result);
            max = Math.max(max, result);

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (ops[i] > 0) {
                output[depth] = op[i];
                ops[i] -= 1;
                permutation(ops, output, r, depth + 1);
                ops[i] += 1;
            }
        }
    }
}
