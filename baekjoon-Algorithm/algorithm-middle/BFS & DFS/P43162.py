def solution(n, computers):
    cnt = 0
    visited = [0] * n

    def dfs(v):
        visited[v] = 1

        for k in range(n):
            if not visited[k] and computers[v][k]:
                dfs(k)

    for i in range(n):
        if not visited[i]:
            cnt += 1
            dfs(i)

    return cnt