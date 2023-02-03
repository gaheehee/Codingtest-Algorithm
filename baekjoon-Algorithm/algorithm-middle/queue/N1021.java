import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer command = null;

        command = new StringTokenizer(br.readLine(), " ");

        int queueSize = Integer.parseInt(command.nextToken());
        int m = Integer.parseInt(command.nextToken());

        LinkedList<Integer> dq = new LinkedList<>();

        for (int i=1; i < queueSize + 1; i++) {
            dq.offerLast(i);
        }

        command = new StringTokenizer(br.readLine(), " ");
        int targetNum = 0;
        int cnt = 0;

        for (int i=0; i < m; i++) {
            targetNum = Integer.parseInt(command.nextToken());

            while (true) {
                if (dq.getFirst() == targetNum) {
                    dq.pollFirst();
                    break;
                }
                else {
                    if (dq.indexOf(targetNum) <= dq.size() / 2 ) {
                        dq.offerLast(dq.pollFirst());
                        cnt++;
                    }
                    else {
                        dq.offerFirst(dq.pollLast());
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
