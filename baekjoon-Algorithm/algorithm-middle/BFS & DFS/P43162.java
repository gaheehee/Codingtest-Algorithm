class Solution {
    static boolean[] visited;

    public static void dfs(int v, int n, int[][] computers) {
        visited[v] = true;

        for (int i = 0; i < n; i++) {
            if (computers[v][i] == 1 && visited[i] == false) {
                dfs(i, n, computers);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n];

        for (int j = 0; j < n; j++) {
            if (visited[j] == false) {
                cnt += 1;
                dfs(j, n, computers);
            }
        }

        return cnt;
    }
}