import java.util.*;
import java.io.*;

public class N16234 {
    static final int[] dx = {-1, +1, 0, 0};
    static final int[] dy = {0, 0, -1, +1};

    static class Node{
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        List<Node> union = new ArrayList<>();
        boolean[][] visited = new boolean[N][N];
        boolean flag = false;

        while (true) {
            visited = new boolean[N][N];
            //System.out.println(Arrays.deepToString(A));

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    union = new ArrayList<>();
                    //System.out.println("this: " + i  + ", " + j);

                    if (!visited[i][j]) {
                        //System.out.println("in here");
                        visited[i][j] = true;
                        q.add(new Node(i, j));
                        union.add(new Node(i, j));

                        while (!q.isEmpty()) {
                            Node n = q.poll();

                            for (int k = 0; k < 4; k++) {
                                int nx = dx[k] + n.x;
                                int ny = dy[k] + n.y;

                                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && L <= Math.abs(A[n.x][n.y] - A[nx][ny]) && Math.abs(A[n.x][n.y] - A[nx][ny]) <= R) {
                                    flag = true;
                                    visited[nx][ny] = true;
                                    q.add(new Node(nx, ny));
                                    union.add(new Node(nx, ny));
                                    //System.out.println("!!" + nx + ", " + ny);
                                }
                            }
                        }

                        int allUnionPeople = 0;
                        for (int a = 0; a < union.size(); a++) {
                            Node n1 = union.get(a);
                            allUnionPeople += A[n1.x][n1.y];
                        }

                        //System.out.println(allUnionPeople);

                        int num = allUnionPeople / union.size();

                        //System.out.println(num);
                        for (int a = 0; a < union.size(); a++) {
                            Node n1 = union.get(a);
                            //System.out.println("union!! " + n1.x + ", " + n1.y);
                            A[n1.x][n1.y] = num;
                        }

                    }

                }
            }

            if (!flag) {    //인구이동 x
                break;
            } else {
                cnt++;
                flag = false;
            }
        }

        System.out.println(cnt);
    }
}
