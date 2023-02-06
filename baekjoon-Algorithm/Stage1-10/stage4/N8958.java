import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseNum = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        StringTokenizer command = null;

        String[] arr = new String[testCaseNum];

        for (int i=0; i < testCaseNum; i++) {
            arr[i] = br.readLine();
        }

        int cnt = 0;
        int sum = 0;

        for (int i=0; i < testCaseNum; i++) {
            cnt = 0;
            sum = 0;

            for (int j=0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                sum += cnt;
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
