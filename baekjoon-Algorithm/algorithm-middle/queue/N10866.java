import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class N10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        Integer num = 0;

        StringTokenizer command = null;

        for (int i=0; i < n; i++) {
            try {
                command = new StringTokenizer(br.readLine(), " ");
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch(command.nextToken()) {
                case "push_front":
                    num = Integer.parseInt(command.nextToken());
                    dq.addFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(command.nextToken());
                    dq.addLast(num);
                    break;
                case "pop_front":
                    num = dq.pollFirst();
                    if ( num == null) sb.append(-1).append("\n");
                    else sb.append(num).append("\n");
                    break;
                case "pop_back":
                    num = dq.pollLast();
                    if (num == null) sb.append(-1).append("\n");
                    else sb.append(num).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    num = dq.peekFirst();
                    if (num ==  null) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    num = dq.peekFirst();
                    if (num ==  null) sb.append(-1).append("\n");
                    else sb.append(num).append("\n");
                    break;
                case "back":
                    num = dq.peekLast();
                    if (num ==  null) sb.append(-1).append("\n");
                    else sb.append(num).append("\n");
                    break;
            }
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }
}
