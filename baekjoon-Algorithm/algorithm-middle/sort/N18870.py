'''
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
'''

# 직접 arr.index(a)하는 인덱싱보다 dictionary {key: value} 이용한 인덱싱이 시간복잡도가 낮다.
import sys

n = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))

sequence = list(set(arr))
sequence.sort()

dic = {sequence[i] : i for i in range(len(sequence))}

for k in arr:
    print(dic[k], end= ' ')


# O(n)
# import sys

# n = int(sys.stdin.readline())

# arr = list(map(int, sys.stdin.readline().split()))

# sequence = list(set(arr))
# sequence.sort()

# for i in arr:
#     print(sequence.index(i), end=" ")