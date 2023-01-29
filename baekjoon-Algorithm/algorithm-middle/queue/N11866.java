import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N11866 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        StringTokenizer command = null;
        try {
            command = new StringTokenizer(br.readLine(), " ");
        } catch(IOException e){
            e.printStackTrace();
        }

        int n = Integer.parseInt(command.nextToken());
        int k = Integer.parseInt(command.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i < n+1; i++) q.add(i);

        sb.append('<');

        while(q.size() > 1) {
            for (int i=0; i < k-1; i++) {
                int val = q.poll();
                q.offer(val);
            }

            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll());
        sb.append('>');

        System.out.println(sb);
    }
}
