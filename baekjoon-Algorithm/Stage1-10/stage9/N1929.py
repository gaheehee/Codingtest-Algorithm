'''
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
'''
# sec

m, n = map(int, input().split(' '))

for num in range(m, n+1):
    check = 0
    if num == 1:
        continue
    else:
        for i in range(2, int(num**(1/2))+1):
            if num%i == 0:
                check = 1
                break
        if check == 0:
            print(num)

# **: 제곱 연산자