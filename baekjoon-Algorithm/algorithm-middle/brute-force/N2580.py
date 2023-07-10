'''
게임 시작 전 스도쿠 판에 쓰여 있는 숫자들의 정보가 주어질 때 모든 빈 칸이 채워진 최종 모습을 출력하는 프로그램을 작성하시오.
'''

import sys

sudoku = []
blank = []

for _ in range(9):
    sudoku.append(list(map(int, sys.stdin.readline().split())))

for i in range(9):
    for j in range(9):
        if sudoku[i][j] == 0:
            blank.append((i,j))

n = len(blank)


def check(blank_x, blank_y, k):
    x = blank_x // 3 * 3
    y = blank_y // 3 * 3

    for i in range(9):
        if sudoku[blank_x][i] == k or sudoku[i][blank_y] == k:
            return False

    for i in range(3):
        for j in range(3):
            if sudoku[x + i][y + j] == k:
                return False
    return True


def dfs(depth):
    if depth == n:
        for i in range(9):
            print(*sudoku[i])
        exit(0)

    for i in range(1, 10):
        blank_x = blank[depth][0]
        blank_y = blank[depth][1]

        if check(blank_x, blank_y, i):
            sudoku[blank_x][blank_y] = i
            dfs(depth + 1)
            sudoku[blank_x][blank_y] = 0


dfs(0)


# *(asterisk): 다수의 인자를 받을 때 (tuple이나 list 형태로 전달)
# **: 키워드 인자를 받을 때 (dictionary 형태로 전달)

# exit(0) 오류 / 문제없이 깨끗한 출구를 의미
# exit(1) 문제 / 오류 / 문제가 있음을 의미하므로 프로그램이 종료
# 일반적으로 0은 성공, 1은 오류

'''
import sys

sudoku = []
blank = []

for _ in range(9):
    sudoku.append(list(map(int, sys.stdin.readline().split())))

for i in range(9):
    for j in range(9):
        if sudoku[i][j] == 0:
            blank.append((i,j))

n = len(blank)


def check_row(blank_x, k):
    for i in range(9):
        if sudoku[blank_x][i] == k:
            return False
    
    return True


def check_column(k, blank_y):
    for i in range(9):
        if sudoku[i][blank_y] == k:
            return False

    return True


def check_nine(blank_x, blank_y, k):
    x = blank_x // 3 * 3
    y = blank_y // 3 * 3

    for i in range(3):
        for j in range(3):
            if sudoku[x + i][y + j] == k:
                return False
    return True


def dfs(depth):
    if depth == n:
        for i in range(9):
            print(*sudoku[i])
        exit(0)

    for i in range(1, 10):
        blank_x = blank[depth][0]
        blank_y = blank[depth][1]

        if check_row(blank_x, i) and check_column(i, blank_y) and check_nine(blank_x, blank_y, i):
            sudoku[blank_x][blank_y] = i
            dfs(depth + 1)
            sudoku[blank_x][blank_y] = 0


dfs(0)
'''






