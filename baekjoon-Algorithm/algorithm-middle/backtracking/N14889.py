'''
축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 

위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 

링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.
'''

import sys
from itertools import combinations

n = int(sys.stdin.readline())
total = list(range(n))
s = []
minn = int(sys.maxsize)

for _ in range(n):
    s.append(list(map(int, sys.stdin.readline().split())))

arr = list(combinations(total, n // 2))
# arr[i][0], arr[i][1] vs arr[(len(arr) - 1) - i][0], arr[(len(arr) - 1) - i][1]

for i in range(len(arr) // 2):
    arr1 = list(arr[i][:])
    arr2 = list(set(total) - set(arr1))
    add1, add2 = 0, 0

    for r1 in combinations(arr1, 2):
        add1 += s[r1[0]][r1[1]]
        add1 += s[r1[1]][r1[0]]
    
    for r2 in combinations(arr2, 2):
        add2 += s[r2[0]][r2[1]]
        add2 += s[r2[1]][r2[0]]
    
    minn = min(minn, abs(add1 - add2))

print(minn)

# set의 차집합: s1 - s2