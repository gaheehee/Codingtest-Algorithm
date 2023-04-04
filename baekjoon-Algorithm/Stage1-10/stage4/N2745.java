import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2745 {
    static String n;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = st.nextToken();
        b = Integer.parseInt(st.nextToken());

        int ans = 0; // 시작은 0으로 시작

        // 아래에서 ans를 0으로 시작하고 계속 N(기존 진법)을 곱하고 있다.
        // 이는, 앞자리의 숫자는 전체 m자리라면 m-1승 까지 곱해야 하기 때문
        // 1의 자리는 0승 곱하면 되기 때문에 0으로 시작하는 것임
        for(int i=0; i < n.length(); i++){
            char c = n.charAt(i);
            // 'A'이상의 숫자, 즉 10이상의 경우에는 'A'를 빼고 10을 더하면 원래 숫자가 됨
            if(c >= 'A'){
                ans = ans * b + (c - 'A' + 10);
                // 그 이하는 단순히 '0'만 빼면 된다.
            } else {
                ans = ans * b + (c - '0');
            }
        }
        System.out.println(ans);
    }
}
