import java.util.Stack;
import java.io.*;

public class N10773 {
    private int k = 0;
    private  int sum = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        sum = 0;

        for (int i=0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n==0) {
                sum -= stack.pop();
            } else {
                stack.push(n);
                sum += n;
            }
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new N10773().solution();
    }
}
