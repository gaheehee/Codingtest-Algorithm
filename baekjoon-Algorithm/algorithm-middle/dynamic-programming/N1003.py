'''
fibonacci(3)을 호출하면 1은 2번 출력되고, 0은 1번 출력된다. 

N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
'''

import sys

n = int(sys.stdin.readline())

# import sys

# n = int(sys.stdin.readline())
# nlist = []

# for _ in range(n):
#     nlist.append(int(sys.stdin.readline()))

# num = max(nlist)
# arr = [(1,0), (0,1)]

# for i in range(num-1):
#     arr.append((arr[i][0] + arr[i+1][0], arr[i][1] + arr[i+1][1]))

# for k in nlist:
#     print(arr[k][0], arr[k][1], sep=' ')
