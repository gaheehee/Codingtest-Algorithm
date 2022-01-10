'''
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 

문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.

"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
'''

N = int(input())
for i in range(N):
    score = 0
    inn = input()
    arr = list(inn)
    for j in range(0,len(arr)):
        if arr[j] == "O":
            num = 0
            a = j
            while a >= 0:
                num += 1
                a -= 1
                if arr[a] == "X":
                    break
            score += num
    print(score)


# list(string): 문자열을 한 문자씩 나누어서 리스트에 저장