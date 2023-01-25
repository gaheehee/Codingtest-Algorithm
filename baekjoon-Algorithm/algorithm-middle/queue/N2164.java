import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class N2164 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();

        for (int i=1; i < n+1; i++) q.add(i);

        while(q.size() > 1) {
            q.removeFirst();
            if(q.size() == 1) break;
            int emt = q.removeFirst();
            q.addLast(emt);
        }

        System.out.println(q.removeFirst());
    }
}
