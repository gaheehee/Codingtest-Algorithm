'''
재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***

N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 

예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
'''

import sys

def star(n):
    if n == 1:
        return ['*']
    
    stars = star(n//3)
    slist = []

    for s in stars:
        slist.append(s*3)
    for s in stars:
        slist.append(s + ' '*(n//3) + s)
    for s in stars:
        slist.append(s*3)
    return slist
    

n = int(sys.stdin.readline())
print('\n'.join(star(n)))

# '구분자'.join(리스트): ex)'_'.join(['a', 'b', 'c']) -> "a_b_c"