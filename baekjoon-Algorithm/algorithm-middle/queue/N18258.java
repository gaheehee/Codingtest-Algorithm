import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;
//  LinkedList는 Deque(Queue를 상속받고 있음)도 구현하고 있음
import java.util.StringTokenizer;

public class N18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = 0;

        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Deque<Integer> q = new LinkedList<>();
        StringTokenizer command = null;
        Integer result = 0;

        while(n != 0) {
            try {
                command = new StringTokenizer(br.readLine(), " ");  //문자열 분리
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (command.nextToken()) {
                case "push":
                    q.offer(Integer.parseInt(command.nextToken()));
                    break;

                case "pop":
                    result = q.poll();  //Integer은 null 허용, int는 null 허용 x
                    if (result == null) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(result).append('\n');
                    }
                    break;

                case "size":
                    sb.append(q.size()).append('\n');
                    break;

                case "empty":
                    if (q.size() == 0) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;

                case "front":
                    result = q.peekFirst();
                    if (result == null) sb.append(-1).append('\n');
                    else sb.append(result).append('\n');
                    break;

                case "back":
                    result = q.peekLast();
                    if (result == null) sb.append(-1).append('\n');
                    else sb.append(result).append('\n');
                    break;

            }
            n--;
        }
        System.out.println(sb);
    }
}
