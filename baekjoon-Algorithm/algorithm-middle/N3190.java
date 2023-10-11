import java.util.*;
import java.io.*;


public class N3190 {
    static int[] dx = {0, +1, 0, -1};
    static int[] dy = {+1, 0, -1, 0};

    static class Pair {
        int x;
        int y;

        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dmove {
        int sec;
        String d;

        Dmove (int sec, String d) {
            this.sec = sec;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int apple_num = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        StringTokenizer st;

        //1: 사과, 0: 빈, -1: 뱀
        for (int i = 0; i < apple_num; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        int l = Integer.parseInt(br.readLine());
        List<Dmove> direction_change = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            direction_change.add(new Dmove(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        List<Pair> snake = new ArrayList<>();
        snake.add(new Pair(1, 1));
        map[1][1] = -1;
        int time = 0;
        int d = 0;
        int change_time = -1;
        Pair cur_head = new Pair(1, 1);

        if (!direction_change.isEmpty())
            change_time = direction_change.get(0).sec;

        while (true) {
            time++;
            System.out.println("time: " + time);
            int nx = cur_head.x + dx[d];
            int ny = cur_head.y + dy[d];

            System.out.println("nx: " + nx + " ny: " + ny);

            if (nx > 0 && nx <= n && ny > 0 &&  ny <= n && map[nx][ny] != -1) {

                if (map[nx][ny] == 0) {
                    Pair tail = snake.get(0);
                    map[tail.x][tail.y] = 0;
                    snake.remove(0);
                }
                map[nx][ny] = -1;
                snake.add(new Pair(nx, ny));
                cur_head = new Pair(nx, ny);
            }
            else {
                break;
            }

            //방향 바꾸기
            if (change_time == time) {
                System.out.println("change time");
                if (direction_change.get(0).d.equals("D"))
                    d = (d + 1) % 4;
                else
                    d = (d + 3) % 4;

                direction_change.remove(0);

                if (direction_change.isEmpty())
                    change_time = -1;
                else
                    change_time = direction_change.get(0).sec;
            }

            System.out.println("snake " + snake.get(0).x + " " + snake.get(0).y);
        }

        System.out.println(time);
    }

}
