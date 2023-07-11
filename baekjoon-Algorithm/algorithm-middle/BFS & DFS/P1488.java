import java.util.*;

class Solution {
    public int solution(int[][] maps) {

        int n = maps[0].length;
        int m = maps.length;

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        // 상하좌우
        int[] dx = {+1, -1, 0, 0};
        int[] dy = {0, 0, +1, -1};

        q.add(new int[]{0,0});
        visited[0][0] = true;

        int[] xy = new int[2];
        int nx, ny = 0;

        while (!q.isEmpty()) {
            xy = q.remove();
            //System.out.println("x와 y: " + xy[0] + ", " + xy[1]);

            for (int i = 0; i < 4; i++) {
                nx = xy[0] + dx[i];
                ny = xy[1] + dy[i];

                if ((0 <= nx) && (nx < m) && (0 <= ny) && (ny < n) && visited[nx][ny] == false && maps[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[xy[0]][xy[1]] + 1;
                    //System.out.println(maps[nx][ny]);
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if (maps[m-1][n-1] == 1) {
            return -1;
        } else {
            return maps[m-1][n-1];
        }
    }
}