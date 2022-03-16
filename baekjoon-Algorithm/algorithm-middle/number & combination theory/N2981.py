'''
트럭을 타고 이동하던 상근이는 경찰의 검문을 받게 되었다. 
경찰은 상근이가 운반하던 화물을 하나하나 모두 확인할 것이기 때문에, 검문하는데 엄청나게 오랜 시간이 걸린다.

상근이는 시간을 때우기 위해서 수학 게임을 하기로 했다.

먼저 근처에 보이는 숫자 N개를 종이에 적는다. 
그 다음, 종이에 적은 수를 M으로 나누었을 때, 나머지가 모두 같게 되는 M을 모두 찾으려고 한다. M은 1보다 커야 한다.

N개의 수가 주어졌을 때, 가능한 M을 모두 찾는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())
nlist = list(int(sys.stdin.readline() for _ in range(n)))
nlist.sort()



result = list()
for i in range(2,min(nlist)):
    a = nlist[0] % i
    check = 1
    for j in nlist:
        if j % i != a:
            check = 0
            break
    if check == 1:
        result.append(i)

for i in result:
    print(i, end=' ')