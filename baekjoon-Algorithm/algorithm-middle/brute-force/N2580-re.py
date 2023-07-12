import sys

input = sys.stdin.readline

def is_ok(i, j, n):
    for idx in range(9):
        if sdoku[i][idx] == n or sdoku[idx][j] == n:
            return False

    i = (i // 3) * 3
    j = (j // 3) * 3

    for k in range(i, i+3):
        for l in range(j, j+3):
            if sdoku[k][l] == n:
                return False

    return True


sdoku = [list(map(int, input().split())) for _ in range(9)]
blank = []

for i in range(9):
    for j in range(9):
        if sdoku[i][j] == 0:
            blank.append([i,j])

leng = len(blank)

def dfs(idx):
    if idx == leng:
        for i in range(9):
            print(*sdoku[i])
        exit()

    # 빈칸마다 넣을 수 있는 수를 넣고 행, 열, 3*3에 없는 수임을 확인
    for n in range(1, 10):
        i = blank[idx][0]
        j = blank[idx][1]

        if is_ok(i, j, n):
            sdoku[i][j] = n
            dfs(idx + 1)
            sdoku[i][j] = 0

dfs(0)