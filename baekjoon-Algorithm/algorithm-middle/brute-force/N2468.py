import sys
sys.setrecursionlimit(100000)

input = sys.stdin.readline

N = int(input())
heights = [ list(map(int, input().split())) for _ in range(N)]
result = 0

# 2차원 배열에서 최대값 찾기 - map 이용
max_value = max(map(max, heights))

# 상하좌우
dx = [-1, +1, 0, 0]
dy = [0, 0, -1, +1]

#x, y 지점을 기준으로 주변을 탐색하는 재귀함수
def sink_DFS(x, y, h):

    for m in range(4):
        nx = x + dx[m]
        ny = y + dy[m]

        # 자신이 건너갈 nx, ny 좌표에 대한 유효성을 먼저 검증함
        if (0 <= nx < N) and (0 <= ny < N) and not visited[nx][ny] and heights[nx][ny] > h:
            # 유효성이 검증된 좌표에 한해서 재귀함수를 호출
            visited[nx][ny] = 1
            # 실질적으로 재귀함수가 하는 역할은 visited boolean 값만 바꾸는 역할
            sink_DFS(nx, ny, h)


for i in range(max_value):
    visited = [[0] * N for _ in range(N)]
    cnt = 0

    for j in range(N):
        for k in range(N):
            if heights[j][k] > i and not visited[j][k]:
                cnt += 1
                visited[j][k] = 1
                sink_DFS(j, k, i)

    result = max(result, cnt)

print(result)