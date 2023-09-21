import java.util.*;
import java.io.*;

public class N14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            int k = 0;
            boolean[] created = new boolean[n];
            boolean flag = true;

            //가로
            while((k + 1) < n) {
                ///System.out.println("k: " + k);

                if (map[i][k] == map[i][k+1]) { //평지
                    //System.out.println("평지");
                    k++;

                } else if (map[i][k] > map[i][k+1]) {   //내리막
                    if ((k + l) < n && Math.abs(map[i][k] - map[i][k+1]) == 1) {
                        created[k+1] = true;

                        for (int j = k + 2; j <= k + l; j++) {
                            if (map[i][k+1] == map[i][j]) {
                                //System.out.println("내리막 경사도");
                                created[j] = true;
                            } else {
                                //System.out.println("x 내리막 경사도");
                                flag = false;
                                break;
                            }
                        }
                        k += l;

                        if (!flag)
                            break;

                    }
                    else {
                        flag = false;
                        break;
                    }

                } else if (map[i][k] < map[i][k+1]) {  //오르막
                    if ((k - (l-1)) >= 0 && Math.abs(map[i][k] - map[i][k+1]) == 1 && !created[k]) {
                        created[k] = true;

                        for (int j = k - 1; j > k - l; j--) {
                            if (map[i][k] == map[i][j] && !created[j]) {
                                //System.out.println("오르막 경사도");
                                created[j] = true;
                            } else {
                                //System.out.println("x 오르막 경사도");
                                flag = false;
                                break;
                            }
                        }

                        k++;

                        if (!flag)
                            break;

                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                answer++;
                //System.out.println("!!가로 " + i);
            }

            k = 0;
            created = new boolean[n];
            flag = true;

            //세로
            //System.out.println("세로 " + i);
            while((k + 1) < n) {
                //System.out.println("k: " + k);

                if (map[k][i] == map[k+1][i]) { //평지
                    //System.out.println("평지");
                    k++;

                } else if (map[k][i] > map[k+1][i]) {   //내리막
                    if ((k + l) < n && Math.abs(map[k][i] - map[k+1][i]) == 1) {
                        created[k+1] = true;

                        for (int j = k+2; j <= k + l; j++) {
                            if (map[k+1][i] == map[j][i]) {
                                //System.out.println("내리막 경사도");
                                created[j] = true;
                            } else {
                                //System.out.println("x 내리막 경사도");
                                flag = false;
                                break;
                            }
                        }

                        k += l;

                        if (!flag)
                            break;
                    }
                    else {
                        flag = false;
                        break;
                    }

                } else if (map[k][i] < map[k+1][i]) {  //오르막
                    if ((k - (l-1)) >= 0 && Math.abs(map[k][i] - map[k+1][i]) == 1 && !created[k]) {
                        created[k] = true;

                        for (int j = k - 1; j > k - l; j--) {
                            if (map[k][i] == map[j][i] && !created[j]) {
                                //System.out.println("오르막 경사도");
                                created[j] = true;
                            } else {
                                //System.out.println("x 오르막 경사도");
                                flag = false;
                                break;
                            }
                        }

                        k++;

                        if (!flag)
                            break;

                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                answer++;
                //System.out.println("!!세로 " + i);
            }

        }

        System.out.println(answer);
    }
}
