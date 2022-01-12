'''
자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.

예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 

이들 소수의 합은 620이고, 최솟값은 61이 된다.
'''
# 18sec

m =  int(input())
n = int(input())
sousulist = []

for num in range(m, n+1):
    check = 0
    if num == 1:
        continue
    else:
        for i in range(2, num):
            if num%i == 0:
                check = 1
                break
        if check == 0:
                sousulist.append(num)

if len(sousulist) > 0:
    print(sum(sousulist))
    print(min(sousulist))
else:
    print(-1)


# continue: 아래 코드 실행 시키지 않고 건너뜀