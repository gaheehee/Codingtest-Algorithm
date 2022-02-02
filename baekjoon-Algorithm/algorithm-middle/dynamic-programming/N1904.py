'''
지원이에게 2진 수열을 가르쳐 주기 위해, 지원이 아버지는 그에게 타일들을 선물해주셨다. 

그리고 이 각각의 타일들은 0 또는 1이 쓰여 있는 낱장의 타일들이다.

어느 날 짓궂은 동주가 지원이의 공부를 방해하기 위해 0이 쓰여진 낱장의 타일들을 붙여서 한 쌍으로 이루어진 00 타일들을 만들었다. 

결국 현재 1 하나만으로 이루어진 타일 또는 0타일을 두 개 붙인 한 쌍의 00타일들만이 남게 되었다.

그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 

예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 

또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

우리의 목표는 N이 주어졌을 때 지원이가 만들 수 있는 모든 가짓수를 세는 것이다. 단 타일들은 무한히 많은 것으로 가정하자.

첫 번째 줄에 지원이가 만들 수 있는 길이가 N인 모든 2진 수열의 개수를 15746으로 나눈 나머지를 출력한다.
'''

# 갯수 직접 세보면 피보나치랑 동일

import sys

n = int(sys.stdin.readline())
case = [0, 1, 2]

for i in range(3, n+1):
    case.append((case[i-1] + case[i-2]) % 15746)

print(case[n])

''' 너무 큰 수를 넣어도 메모리 초과가 일어날 수 있음'''

# import sys

# n = int(sys.stdin.readline())
# bbefore, before = 1, 2

# for i in range(3, n+1):
#     casenum = bbefore + before
#     bbefore, before = before, casenum

# print(casenum)



# import sys

# n = int(sys.stdin.readline())
# case = [[0]]
# arr = ['1']
# case.append(arr)
# arr = ['11', '00']
# case.append(arr)

# for i in range(3, n+1):
#     arr = []
#     half = i // 2
#     for j in range(1, half+1):
#         # j and n-j
#         for num1 in case[j][:]:
#             for num2 in case[i-j][:]:
#                 arr.append(num1 + num2)
#                 arr.append(num2 + num1)
#     arr1 = list(set(arr))
#     case.append(arr1)

# print(len(case[n]) % 15746)




# import sys

# n = int(sys.stdin.readline())
# case = [0, 1, 2]

# for i in range(3, n+1):
#     case.append(case[i-1] + case[i-2])

# print(case[n] % 15746)
