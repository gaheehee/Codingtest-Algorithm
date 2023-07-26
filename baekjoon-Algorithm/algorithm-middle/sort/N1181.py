'''
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
'''

import sys

n = int(sys.stdin.readline())
arr = []

for _ in range(n):
    arr.append(sys.stdin.readline().strip())

arr = list(set(arr))
arr.sort()
arr.sort(key = len)

for i in arr:
    print(i)

# readline().strip(): 개행문자 제거
# 문자열리스트 sort -> 알파벳 사전순: arr.sort()
# 길이 순으로 정렬: arr.sort(key = len)
