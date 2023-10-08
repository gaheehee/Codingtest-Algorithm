import java.util.*;
import java.io.*;

public class N17144 {
    static int[] dx = {-1, +1, 0, 0};
    static int[] dy = {0, 0, -1, +1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] map = new int[r][c];
        int[] airclean = new int[2];
        int tmp = 0;
        int num = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < c; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == -1) {
                    airclean[tmp] = i;
                    tmp = 1;
                }
            }
        }

        int[][] around;
        int[][] update;

        for (int i = 0; i < t; i++) {
            around = new int[r][c];
            update = new int[r][c];

            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {

                    //주변, 자기자신 업데이트
                    if (map[j][k] != 0 && map[j][k] != -1) {
                        List<Integer> possible = new ArrayList<>();

                        for (int l = 0; l < 4; l++) {
                            int nx = j + dx[l];
                            int ny = k + dy[l];

                            if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != -1) {
                                possible.add(l);
                            }
                        }

                        int rrr = map[j][k] / 5;

                        for (int l = 0; l < possible.size(); l++) {
                            around[j + dx[possible.get(l)]][k + dy[possible.get(l)]] += rrr;
                        }
                        
                        update[j][k] = map[j][k] - (rrr * possible.size()); // =, += 중 고민
                    }
                }
            }

            //map 갱신
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    map[j][k] = update[j][k] + around[j][k];
                }
            }

            map[airclean[0]][0] = -1;
            map[airclean[1]][0] = -1;
            //System.out.println(Arrays.deepToString(map));

            //공청기 순환
            //반시계
            tmp = map[airclean[0]][c-1];
            for (int j = c-1; j > 1; j--) {
                map[airclean[0]][j] = map[airclean[0]][j-1];
            }
            map[airclean[0]][1] = 0;
            int tmp2 = map[0][c-1];
            for (int j = 0; j < airclean[0] - 1; j++) {
                map[j][c-1] = map[j+1][c-1];
            }
            map[airclean[0] - 1][c-1] = tmp;
            tmp = map[0][0];
            for (int j = 0; j < c-2; j++) {
                map[0][j] = map[0][j+1];
            }
            map[0][c-2] =tmp2;
            for (int j = airclean[0]-1; j > 1; j--) {
                map[j][0] = map[j-1][0];
            }
            map[1][0] = tmp;

            //시계
            tmp = map[airclean[1]][c-1];
            for (int j = c-1; j > 1; j--) {
                map[airclean[1]][j] = map[airclean[1]][j-1];
            }
            map[airclean[1]][1] = 0;

            tmp2 = map[r-1][c-1];
            for (int j = r-1; j > airclean[1] + 1; j--) {
                map[j][c-1] = map[j-1][c-1];
            }

            map[airclean[1] + 1][c-1] = tmp;
            tmp = map[r-1][0];
            for (int j = 0; j < c-2; j++) {
                map[r-1][j] = map[r-1][j+1];
            }
            map[r-1][c-2] =tmp2;
            for (int j = airclean[1]+1; j < r-2; j++) {
                map[j][0] = map[j+1][0];
            }
            map[r-2][0] = tmp;
            //System.out.println("시계" + Arrays.deepToString(map));

        }

        num = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != -1 && map[i][j] != 0)
                    num += map[i][j];
            }
        }

        //System.out.println(Arrays.deepToString(map));
        System.out.println(num);
    }
}
