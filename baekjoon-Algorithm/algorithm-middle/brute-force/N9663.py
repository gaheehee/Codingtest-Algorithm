import sys

input = sys.stdin.readline

N = int(input())

cnt = 0
row = [0] * N


def is_promising(x):
    for i in range(x):
        # 세로 체크, 대각선 체크
        if row[x] == row[i] or abs(row[x] - row[i]) == x - i:
            return False

    return True


def n_queens(x):
    global cnt

    if x == N:
        cnt += 1
        return

    for i in range(N):
        row[x] = i  # (x, i)에 퀸을 놓음
        # 유망성 판단: 다음 칸에 놓을 수 있는 경우가 있는지
        if is_promising(x):
            n_queens(x + 1)


n_queens(0)
print(cnt)