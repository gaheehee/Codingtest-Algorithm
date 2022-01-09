'''
그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 

예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 

aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.

단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
'''
# 11 sec

N = int(input())
count = 0
for i in range(0,N):
    word = input()
    count += 1
    strlist = list(word)
    before = strlist[0]
    arr = []
    arr.append(before)
    for j in strlist[1:]:
        if j != before and j not in arr:
            arr.append(j)
        elif j != before and j in arr:
            count -= 1
            break
        before = j

print(count)



'''
N = int(input())
count = N
for i in range(0,N):
    word = input()
    for j in range(0, len(word)-1):
        if (word[j] != word[j+1]) and (word[j] in word[j+1:]):
            count -= 1
            break
print(count)
'''
        